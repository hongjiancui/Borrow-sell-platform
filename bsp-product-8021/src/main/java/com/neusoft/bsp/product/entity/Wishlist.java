package com.neusoft.bsp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1435515995226255188L;

    private String witId;
    private String dsrId;
    private String proId;
}
