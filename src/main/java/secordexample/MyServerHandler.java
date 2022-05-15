package secordexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Scanner;
import java.util.UUID;

/**
 * @Author virtual
 * @Date 2022/4/25 0:35
 * @description：
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("from client("+ctx.channel().remoteAddress()+":" + msg);
        //将消息发送给客户端
        ctx.channel().writeAndFlush(UUID.randomUUID().toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush("welcome to server");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        // C
        ctx.close();
    }
}
