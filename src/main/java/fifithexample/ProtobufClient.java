package fifithexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import protobuf.StudentBook;

/**
 * @Author virtual
 * @Date 2022/4/26 22:23
 * @description£ºprotobuf¿Í»§¶Ë
 */
public class ProtobufClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap client = new Bootstrap();
            client.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ProtobufVarint32FrameDecoder())
                                    .addLast(new ProtobufDecoder(StudentBook.Book.getDefaultInstance()))
                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
                                    .addLast(new ProtobufEncoder())
                                    .addLast(new ProtobufClientHandler());
                        }
                    })
                    .handler(new LoggingHandler(LogLevel.INFO));
            ChannelFuture future = client.connect("localhost", 8085).sync();
            future.channel().closeFuture().sync();

        }finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
