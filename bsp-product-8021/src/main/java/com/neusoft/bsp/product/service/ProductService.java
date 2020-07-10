package com.neusoft.bsp.product.service;

import com.neusoft.bsp.product.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Map<String, String>> getProductsBasic(String brdId);

    int addProduct(Map<String, String> params);

    int updateProduct(Product product);

    int updateProductStatus(Product product);

    int deleteProduct(String proId);

    List<Map<String, String>> getProductDetail(String proId);

    int updateProductDetail(Map<String, String> params);

    String uploadImage(MultipartFile file, String manId);

    List<Map<String, String>> getProductsBS();

    Product getProduct(String proId);

    List<Map<String, String>> getAllProduct(String userId);

}
