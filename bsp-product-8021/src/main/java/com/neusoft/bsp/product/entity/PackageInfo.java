package com.neusoft.bsp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageInfo {
    private String pckId;
    private String warId;
    private String proId;
    private String typeCd;
    private String width;
    private String height;
    private String length;
    private String weight;
    private String heavyCargo;
    private String logisticsCompany;
}
