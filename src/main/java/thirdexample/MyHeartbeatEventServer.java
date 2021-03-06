package thirdexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.charset.StandardCharsets;

/**
 * @Author virtual
 * @Date 2022/4/25 17:32
 * @description：心跳事件服务器
 * 背景：建立tcp连接后，如果客户端直接断开（飞行模式/关机等），服务器是无法感知到的，因此需要一个心跳机制来保证服务端关闭那些没有心跳（长时间未发信息）的客户端
 */
public class MyHeartbeatEventServer {
    public static void main(String[] args) throws Exception {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // childHandler针对workerGroup的每个channel
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            // 使用netty提供的字符串分割的编解码器
                            // 添加心跳检查handler(三秒未发送消息视为心跳异常、五秒未响应信息、七秒都有)
                            pipeline.addLast(new IdleStateHandler(3, 5 , 7))
                                    .addLast(new MyHeartbeatEventServerHandler());
                        }
                    });
            ChannelFuture future = server.bind(8082).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
