package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private String brdId;
    private String manId;
    private String nameEn;
    private String nameCn;
    private String createDate;
    private String lastUpdateDate;
    private String imageUrl;
    private String description;
}
