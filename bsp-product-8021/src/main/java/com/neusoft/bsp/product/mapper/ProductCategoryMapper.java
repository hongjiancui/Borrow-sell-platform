package com.neusoft.bsp.product.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.product.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProductCategoryMapper extends BaseMapper<String, ProductCategory> {
    int addProductCategory(Map<String, String> params);
}
