/*
 * 文件名：ConcentHandler.java
 * 版权：Copyright by www.poly.com
 * 描述：
 * 修改人：gogym
 * 修改时间：2019年6月11日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.gettyio.gim.client.handler.bshandler;


import com.gettyio.core.channel.AioChannel;
import com.gettyio.gim.client.core.GimContext;
import com.gettyio.gim.client.handler.AbsChatHandler;
import com.gettyio.gim.client.packet.MessageClass;
import com.google.protobuf.util.JsonFormat;

/**
 * 连接结果处理器
 *
 * @author gogym
 * @version 2019年6月11日
 * @see ConnectHandler
 * @since
 */
public class ConnectHandler extends AbsChatHandler<MessageClass.Message> {

    private GimContext gimContext;

    public ConnectHandler(GimContext gimContext) {
        this.gimContext = gimContext;
    }


    @Override
    public Class<MessageClass.Message> bodyClass() {
        return MessageClass.Message.class;
    }

    @Override
    public void handler(MessageClass.Message message, AioChannel aioChannel) throws Exception {
        if (gimContext.channelBindListener != null) {
            String msgJson = JsonFormat.printer().print(message);
            gimContext.channelBindListener.bind(msgJson);
        }
    }

}
