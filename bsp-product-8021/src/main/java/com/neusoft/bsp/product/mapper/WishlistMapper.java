package com.neusoft.bsp.product.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.product.entity.Wishlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WishlistMapper extends BaseMapper<String, Wishlist> {
    List<Map<String, String>> getWishlistByDsrId(@Param("dsrId") String dsrId);
}
