package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bsoId;
    private String strId;
    private String proId;
    private String name;
    private String createTime;
    private String price;
}
