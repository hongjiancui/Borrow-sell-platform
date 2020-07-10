package com.neusoft.bsp.info.service;


import com.neusoft.bsp.info.entity.Manufacturer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CompanyService {
    List<Manufacturer> getAllCompanies(String userId);

    int addCompany(Manufacturer manufacturer);

    int updateCompany(Manufacturer manufacturer);

    int deleteCompany(String manId);

    String uploadImage(MultipartFile file, String manId);
}
