/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gettyio.gim.message;


/**
 * MessageContentType.java
 *
 * @description:
 * @author:gogym
 * @date:2020/4/10
 * @copyright: Copyright by gettyio.com
 */
public enum MessageContentType {

    /**
     * 文字，图片，音频，视频
     */
    text(1), image(2), audio(3), video(4);

    private int value;

    private MessageContentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


    /**
     * 根据value返回枚举类型
     *
     * @param value
     * @return
     */
    public static MessageContentType getByValue(int value) {
        for (MessageContentType messageContentType : values()) {
            if (messageContentType.getValue() == value) {
                return messageContentType;
            }
        }
        return null;
    }

}
