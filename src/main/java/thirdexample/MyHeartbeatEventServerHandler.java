package thirdexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

import static io.netty.handler.timeout.IdleState.READER_IDLE;
import static io.netty.handler.timeout.IdleState.WRITER_IDLE;

/**
 * @Author virtual
 * @Date 2022/4/25 17:37
 * @description��
 */
public class MyHeartbeatEventServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * �¼�����
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            if(event.state().equals(READER_IDLE)){
                System.out.println("������");
            }else if(event.state().equals(WRITER_IDLE)){
                System.out.println("д����");
            }else{
                System.out.println("��д����");
            }
        }

    }
}
