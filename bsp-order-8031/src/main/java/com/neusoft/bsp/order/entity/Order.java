package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String bsoId;
    private String strId;
    private String proId;
    private String name;
    private String createTime;
    private String price;
}
