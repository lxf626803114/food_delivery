package com.mall.food.pojo;

import lombok.Data;

@Data
public class ServiceMessage {
    private Integer serviceId;
    private String senderId;
    private String senderName;
    private String serviceContent;
    private String recipientId;

}
