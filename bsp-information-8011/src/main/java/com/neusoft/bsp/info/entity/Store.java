package com.neusoft.bsp.info.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    private String strId;
    private String dsrId;
    private String platformType;
    private String storeName;
    private String storeStsCd;
    private String stsDc;
    private String imageUrl;
}
