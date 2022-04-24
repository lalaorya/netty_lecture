package firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @Author virtual
 * @Date 2022/4/24 18:05
 * @description：
 */
public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建一个服务端
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 处理器初始化及定义
                    .childHandler(new ChannelInitializer() {
                        @Override
                        // Channel创建好会自动调用该方法，相当于一个回调函数
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("httpsServerCodec",new HttpServerCodec());
                            pipeline.addLast("testHttpServerHandler",new TestServerHandler());
                        }
                    });

            // 绑定端口
            ChannelFuture future = server.bind(8080).sync();
            future.channel().closeFuture().sync();
        } finally {
            // 释放资源
            // ctrl alt t 快速surround code'
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }


    }
}
