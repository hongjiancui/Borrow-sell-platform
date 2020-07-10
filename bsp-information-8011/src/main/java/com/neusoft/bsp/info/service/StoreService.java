package com.neusoft.bsp.info.service;

import com.neusoft.bsp.info.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StoreService {

    List<Store> getStores(@Param("dsrId") String dsrId);

    int addStore(Store store);

    int deleteStore(@Param("strId") String strId);

    String uploadImage(MultipartFile file, String strId);
}
