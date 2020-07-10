package com.neusoft.bsp.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String proId;
    private String skuCd;
    private String brdId;
    private String manId;
    private String name;
    private String model;
    private String description;
    private String warrantyDay;
    private String retailPrice;
    private String minRetailPrice;
    private String stsCd;
    private String replenishmentPeriod;
    private String warranty;
    private String imageUrl;
    private String categoryName;
}