package com.neusoft.bsp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    private String manId;
    private String userId;
    private String nameEn;
    private String nameCn;
    private String gmcType;
    private String gmcUrl;
    private String description;
    private String imageUrl;
}
