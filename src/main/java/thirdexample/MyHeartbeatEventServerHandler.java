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
 * @description£º
 */
public class MyHeartbeatEventServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * ÊÂ¼þ²¶»ñ
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            if(event.state().equals(READER_IDLE)){
                System.out.println("¶Á¿ÕÏÐ");
            }else if(event.state().equals(WRITER_IDLE)){
                System.out.println("Ð´¿ÕÏÐ");
            }else{
                System.out.println("¶ÁÐ´¿ÕÏÐ");
            }
        }

    }
}
