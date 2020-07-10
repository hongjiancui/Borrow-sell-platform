package com.neusoft.bsp.product.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper extends BaseMapper<String, Product> {
    List<Map<String, String>> getProductsByBrandId(@Param("brdId") String brdId);

    int addProduct(Map<String, String> params);

    String getLastProductId();

    int updateStatus(Product product);

    List<Map<String, String>> getProductCategoryByBrandId(@Param("brdId") String brdId);

    List<Map<String, String>> getProductDetail(@Param("proId") String proId);

    int updateDetail(Map<String, String> params);

    int updateImageUrl(@Param("proId") String proId, @Param("imageUrl") String imageUrl);

    List<Map<String, String>> getProductsBS();

    List<Product> getProductsByManId(@Param("manId") String manId);
}
