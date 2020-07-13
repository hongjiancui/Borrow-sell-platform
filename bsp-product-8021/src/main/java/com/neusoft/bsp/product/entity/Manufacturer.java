package com.neusoft.bsp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer implements Serializable {
    private static final long serialVersionUID = 1435515992276255188L;

    private String manId;
    private String userId;
    private String nameEn;
    private String nameCn;
    private String gmcType;
    private String gmcUrl;
    private String description;
    private String imageUrl;
}
