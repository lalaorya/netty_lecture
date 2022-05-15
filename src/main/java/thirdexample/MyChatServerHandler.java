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
 * @description��
 * ����:a b c��̨�ͻ��˽���Ⱥ�� -- ��Ϣ�㲥����
 * ����:
 * 1 ֪ͨ����
 *   - a����,��������ӡ����֪ͨbc
 *   - a����,��������ӡ����֪ͨbc
 * 2 ��������
 *   - a������Ϣ,��������ӡ����֪ͨbc
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * ʹ��channelGroup���浱ǰ����������������
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        // ���˱���
        // �㲥��Ϣ������������
        channelGroup.stream().filter(ch -> ch != channel)
                .forEach(ch -> ch.writeAndFlush("[������] - " + channel.remoteAddress() + "˵:" + msg + "\n"));
    }

    /**
     * tcp���ӽ������ø÷��� - ʵ�ֿͻ�������֪ͨ
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        // �㲥������channel
        // ����Ӧ�ñ���channelGroup������channel,����write�����Ѿ��������Ƿ�װ����,����write�������Զ�����channel
        channelGroup.writeAndFlush("[������] - " + channel.remoteAddress() + "����\n");

        // ���浱ǰchannel
        channelGroup.add(channel);

    }

    /**
     * ���ӶϿ����� -- ʵ������֪ͨ
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[������] - " + channel.remoteAddress() + "�뿪\n");
        // ����Ҫ��channelGroup���Ƴ�channel,��ΪchannelGroup���Զ��Ƴ�
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[������] - " + channel.remoteAddress() + "����\n");
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[������] - " + channel.remoteAddress() + "����\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
