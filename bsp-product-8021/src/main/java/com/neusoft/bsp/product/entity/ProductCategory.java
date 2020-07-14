package com.neusoft.bsp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    private String prcId;
    private String proId;
    private String categoryName;
}
