package fifithexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import protobuf.StudentBook;

import java.util.Arrays;

/**
 * @Author virtual
 * @Date 2022/4/26 22:19
 * @description：
 */
public class ProtobufServerHandler extends SimpleChannelInboundHandler<StudentBook.Book> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentBook.Book msg) throws Exception {
        System.out.println("收到消息：" + msg.toString());
        System.out.println(msg.getStudentList().toString());
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }
}
