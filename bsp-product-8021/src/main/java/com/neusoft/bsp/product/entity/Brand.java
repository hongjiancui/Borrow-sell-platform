package com.neusoft.bsp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable {
    private static final long serialVersionUID = 1435115995276255188L;

    private String brdId;
    private String manId;
    private String nameEn;
    private String nameCn;
    private String createDate;
    private String lastUpdateDate;
    private String imageUrl;
    private String description;
}
