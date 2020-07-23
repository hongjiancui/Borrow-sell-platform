package com.neusoft.bsp.info.service;

import com.neusoft.bsp.info.entity.Brand;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrands(String manId);

    int addBrand(Brand brand);

    int updateBrand(Brand brand);

    int deleteBrand(String brdId);

    String uploadImage(MultipartFile file, String brdId);

    Brand getBrandByBrdId(String brdId);

    String getBrandUserId(String brdId);

    List<String> getAllByUserId(String userId);
}
