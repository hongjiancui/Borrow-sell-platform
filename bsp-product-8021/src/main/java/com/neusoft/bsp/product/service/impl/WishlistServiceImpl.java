package com.neusoft.bsp.product.service.impl;

import com.neusoft.bsp.product.entity.Wishlist;
import com.neusoft.bsp.product.mapper.WishlistMapper;
import com.neusoft.bsp.product.service.WishlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WishlistServiceImpl implements WishlistService {
    @Resource
    private WishlistMapper wishlistMapper;

    @Override
    public int addWishlist(Wishlist wishlist) {
        return wishlistMapper.insert(wishlist);
    }

    @Override
    public int deleteWishlist(String witId) {
        return wishlistMapper.delete(witId);
    }

    @Override
    public List<Map<String, String>> getDsrWishlist(String dsrId) {
        return wishlistMapper.getWishlistByDsrId(dsrId);
    }

}
