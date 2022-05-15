package thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @Author virtual
 * @Date 2022/4/25 13:01
 * @description：客户端实现
 */
public class MyChatClient {
    public static void main(String[] args)throws Exception{
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap client = new Bootstrap();
            client.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()))
                                    .addLast(new StringDecoder(StandardCharsets.UTF_8))
                                    .addLast(new StringEncoder(StandardCharsets.UTF_8))
                                    .addLast(new MyChatClientHandler());
                        }
                    });
            Channel channel = client.connect("localhost", 8082).sync().channel();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }


        }finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
