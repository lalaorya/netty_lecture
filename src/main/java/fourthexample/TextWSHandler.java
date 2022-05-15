package fourthexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author virtual
 * @Date 2022/4/25 22:08
 * @description��c�����ı����͵�handler
 * websocket�����������ͣ�
 * 1.�ı����ͣ�Text
 * 2.���������ͣ�Binary
 * 3.�ر����ͣ�Close
 * 4.ping���ͣ�Ping
 * 5.pong���ͣ�Pong
 * 6.�������ͣ�Continuation
 * ������ʽ����֡frame���д���ģ�ÿ��frame����һ�����ͣ�ÿ��frame����һ�����ȣ�ÿ��frame����һ�����ݡ�
 */
public class TextWSHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("����client(" + ctx.channel().remoteAddress()+"):" + msg.text());

        // �����ȷ�װ��֡�ķ�ʽ����
//        ctx.channel().writeAndFlush(new TextWebSocketFrame("������ʱ�䣺" + System.currentTimeMillis()));
        //
        System.out.println(channelGroup.toString());
        channelGroup.writeAndFlush(new TextWebSocketFrame(msg.text()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded: " + ctx.channel().id().asLongText());
        Channel channel = ctx.channel();

        // �㲥������channel
        // ����Ӧ�ñ���channelGroup������channel,����write�����Ѿ��������Ƿ�װ����,����write�������Զ�����channel
        channelGroup.writeAndFlush("[������] - " + channel.remoteAddress() + "����\n");

        // ���浱ǰchannel
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved: " + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
