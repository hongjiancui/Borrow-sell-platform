package com.neusoft.bsp.info.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.info.entity.Store;
import com.neusoft.bsp.info.mapper.StoreMapper;
import com.neusoft.bsp.info.service.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreMapper storeMapper;

    @Resource
    private OSSClient ossClient;

    @Override
    public List<Store> getStores(String dsrId) {
        return storeMapper.getStoreByDsrId(dsrId);
    }

    @Override
    public int addStore(Store store) {
        return storeMapper.insert(store) == 0 ? -1 : storeMapper.getLastId();
    }

    @Override
    public int deleteStore(String strId) {
        return storeMapper.delete(strId);
    }

    @Override
    public String uploadImage(MultipartFile file, String strId){
        String key = "store/" + IdUtil.randomUUID() + ".jpg";
        String imagePath = "https://pic-cui-0622.oss-cn-beijing.aliyuncs.com/" + key;
        String bucketName = "pic-cui-0622";

        try {
            ossClient.putObject(bucketName, key, file.getInputStream());
            storeMapper.updateImageUrl(strId, imagePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return imagePath;
    }
}
