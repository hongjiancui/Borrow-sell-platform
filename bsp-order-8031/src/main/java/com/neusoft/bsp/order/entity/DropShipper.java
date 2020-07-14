package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropShipper implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dsrId;
    private String name;
    private String userId;
}
