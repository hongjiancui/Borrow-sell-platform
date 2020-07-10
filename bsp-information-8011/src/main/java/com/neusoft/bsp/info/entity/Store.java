package com.neusoft.bsp.info.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private String strId;
    private String dsrId;
    private String platformType;
    private String storeName;
    private String storeStsCd;
    private String stsDc;
    private String imageUrl;
}
