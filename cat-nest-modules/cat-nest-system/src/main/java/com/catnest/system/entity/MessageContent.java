package com.catnest.system.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 消息内容实体
 */
@Data
public class MessageContent implements Serializable {
    private static final long serialVersionUID = 8330620555274884217L;

    //发送人
    private String fromUser;
    //接收人
    private String toUser;
    //内容
    private String content;
    //发送时间
    private String sendTime;


    public MessageContent(String fromUser, String toUser, String content) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
    }
}
