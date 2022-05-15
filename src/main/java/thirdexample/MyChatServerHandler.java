package thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author virtual
 * @Date 2022/4/25 12:41
 * @description：
 * 背景:a b c三台客户端进行群聊 -- 消息广播机制
 * 需求:
 * 1 通知问题
 *   - a上线,服务器打印并且通知bc
 *   - a下线,服务器打印并且通知bc
 * 2 聊天问题
 *   - a发送信息,服务器打印并且通知bc
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 使用channelGroup保存当前服务器的所有连接
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        // 过滤本身
        // 广播信息给其他服务器
        channelGroup.stream().filter(ch -> ch != channel)
                .forEach(ch -> ch.writeAndFlush("[服务器] - " + channel.remoteAddress() + "说:" + msg + "\n"));
    }

    /**
     * tcp连接建立调用该方法 - 实现客户端上线通知
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        // 广播给其他channel
        // 正常应该遍历channelGroup的所有channel,但是write方法已经帮助我们封装好了,它的write方法会自动遍历channel
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "加入\n");

        // 保存当前channel
        channelGroup.add(channel);

    }

    /**
     * 连接断开调用 -- 实现下线通知
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "离开\n");
        // 不需要从channelGroup中移除channel,因为channelGroup会自动移除
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "下线\n");
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "上线\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
