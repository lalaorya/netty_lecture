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
 * @description：c处理文本类型的handler
 * websocket共有六种类型：
 * 1.文本类型：Text
 * 2.二进制类型：Binary
 * 3.关闭类型：Close
 * 4.ping类型：Ping
 * 5.pong类型：Pong
 * 6.心跳类型：Continuation
 * 传输形式是以帧frame进行传输的，每个frame都有一个类型，每个frame都有一个长度，每个frame都有一个内容。
 */
public class TextWSHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("来自client(" + ctx.channel().remoteAddress()+"):" + msg.text());

        // 必须先封装成帧的方式发送
//        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间：" + System.currentTimeMillis()));
        //
        System.out.println(channelGroup.toString());
        channelGroup.writeAndFlush(new TextWebSocketFrame(msg.text()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded: " + ctx.channel().id().asLongText());
        Channel channel = ctx.channel();

        // 广播给其他channel
        // 正常应该遍历channelGroup的所有channel,但是write方法已经帮助我们封装好了,它的write方法会自动遍历channel
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "加入\n");

        // 保存当前channel
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
