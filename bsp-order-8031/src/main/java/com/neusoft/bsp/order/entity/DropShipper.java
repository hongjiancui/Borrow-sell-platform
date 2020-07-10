package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropShipper {
    private String dsrId;
    private String name;
    private String userId;
}
