package com.gettyio.gim.handler;


import com.gettyio.core.channel.SocketChannel;
import com.gettyio.gim.intf.ChatHandlerIntf;
import com.gettyio.gim.packet.MessageClass;
import com.google.protobuf.GeneratedMessageV3;

/**
 * 〈消息分发基类〉
 *
 * @author gogym
 * @version 2019年6月11日
 * @see AbsChatHandler
 * @since
 */
public abstract class AbsChatHandler<T extends GeneratedMessageV3> implements ChatHandlerIntf {


    // 获取泛型类，从子类中返回，这个很重要
    public abstract Class<T> bodyClass();

    @Override
    public void handler(MessageClass.Message message, SocketChannel socketChannel) throws Exception {
        // 根据类型转换消息
        T t = bodyClass().cast(message);
        handler(t, socketChannel);
    }

    // 把消息分发给指定的业务处理器
    public abstract void handler(T message, SocketChannel socketChannel) throws Exception;

}
