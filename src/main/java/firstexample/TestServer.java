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
 * @description��
 */
public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // ����һ�������
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // ��������ʼ��������
                    .childHandler(new ChannelInitializer() {
                        @Override
                        // Channel�����û��Զ����ø÷������൱��һ���ص�����
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("httpsServerCodec",new HttpServerCodec());
                            pipeline.addLast("testHttpServerHandler",new TestServerHandler());
                        }
                    });

            // �󶨶˿�
            ChannelFuture future = server.bind(8080).sync();
            future.channel().closeFuture().sync();
        } finally {
            // �ͷ���Դ
            // ctrl alt t ����surround code'
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }


    }
}
