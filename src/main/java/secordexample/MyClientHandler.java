package secordexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @Author virtual
 * @Date 2022/4/25 0:49
 * @description£º
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            System.out.println("from server(" + ctx.channel().remoteAddress() + "):" + msg);
            ctx.writeAndFlush(new Scanner(System.in).nextLine());
//            ctx.writeAndFlush(LocalDateTime.now().toString());
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }

}
