package com.neusoft.bsp.product.service;

import com.neusoft.bsp.product.entity.Wishlist;

import java.util.List;
import java.util.Map;

public interface WishlistService {
    int addWishlist(Wishlist wishlist);

    int deleteWishlist(String witId);

    List<Map<String, String>> getDsrWishlist(String dsrId);
}
