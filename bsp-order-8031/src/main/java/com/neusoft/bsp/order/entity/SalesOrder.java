package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String saoId;
    private String paymentDate;
    private String pushDate;
    private String trackNoDate;
    private String fulfillmentDate;
    private String brdId;
    private String proId;
    private String dsrId;
    private String productAmount;
    private String orderNo;
    private String orderSts;
    private String refundSts;
    private String deliverySts;
    private String trackingNo;
    private String wspName;
    private String cancelTime;
    private String price;
    private String createDate;
}
