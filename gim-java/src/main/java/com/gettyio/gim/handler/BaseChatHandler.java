package com.gettyio.gim.handler;


import com.gettyio.core.channel.SocketChannel;
import com.gettyio.gim.common.Type;
import com.gettyio.gim.listener.ChatListener;
import com.gettyio.gim.message.MessageGenerate;
import com.gettyio.gim.packet.MessageClass;

import java.util.Map;

/**
 * 〈业务处理器基类〉
 *
 * @author gogym
 * @version 2019年6月11日
 * @see BaseChatHandler
 * @since
 */
public class BaseChatHandler implements ChatListener {

    Map<Integer, AbsChatHandler<?>> handlerMap;

    public BaseChatHandler(Map<Integer, AbsChatHandler<?>> handlerMap) {
        this.handlerMap = handlerMap;
    }


    @Override
    public void read(MessageClass.Message message, SocketChannel socketChannel) throws Exception {

        //自动返回ack给客户端
        if (message.getReqType() != Type.ACK_REQ && message.getReqType() != Type.HEART_BEAT_REQ) {
            if(socketChannel!=null){
                MessageClass.Message ack = MessageGenerate.createAck(message.getId());
                socketChannel.writeAndFlush(ack);
            }else{
                //集群过来的消息ack已经提前处理。无需在此处理
            }

        }
        //根据消息查找对应的处理器
        Integer type = message.getReqType();
        AbsChatHandler<?> absChatHandler = handlerMap.get(type);
        if (absChatHandler == null) {
            throw new Exception("找不到对应消息处理器");
        }
        absChatHandler.handler(message, socketChannel);
    }
}
