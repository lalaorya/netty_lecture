package firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @Author virtual
 * @Date 2022/4/24 18:26
 * @description：
 */
public class TestServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    /**
     * 该方法用于读取客户端的请求并向客户端作出响应
     */
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            ByteBuf resContent = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, resContent);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, resContent.readableBytes());
            // 把响应结果返回给客户端
            ctx.writeAndFlush(response);
        }

    }
}
