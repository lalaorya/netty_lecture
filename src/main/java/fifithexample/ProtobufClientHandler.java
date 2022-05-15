package fifithexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import protobuf.StudentBook;

/**
 * @Author virtual
 * @Date 2022/4/26 22:27
 * @description：
 */
public class ProtobufClientHandler extends SimpleChannelInboundHandler<StudentBook.Book> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentBook.Book msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 构建book
        StudentBook.Book book = StudentBook.Book.newBuilder().addStudent(0, StudentBook.Student.newBuilder().setName("张三").setAge(18).setId(123).build())
                .addStudent(1, StudentBook.Student.newBuilder().setName("李四").setAge(19).setId(456).build())
                .addStudent(2, StudentBook.Student.newBuilder().setName("王五").setAge(20).setId(789).build())
                .build();
        System.out.println(book.getStudentList().get(0).toString());
        // 使用二进制的方式传输
        System.out.println(book.toString());
        ctx.channel().writeAndFlush(book);
    }
}
