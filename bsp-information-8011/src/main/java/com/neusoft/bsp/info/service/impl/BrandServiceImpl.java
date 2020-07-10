package com.neusoft.bsp.info.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.info.entity.Brand;
import com.neusoft.bsp.info.mapper.BrandMapper;
import com.neusoft.bsp.info.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Resource
    private OSSClient ossClient;

    @Override
    public List<Brand> getAllBrands(String manId) {
        return brandMapper.getBrandsByManId(manId);
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.update(brand);
    }

    @Override
    public int deleteBrand(String brdId) {
        return brandMapper.delete(brdId);
    }

    @Override
    public String uploadImage(MultipartFile file, String manId){
        String key = "brand/" + IdUtil.randomUUID() + ".jpg";
        String imagePath = "https://pic-cui-0622.oss-cn-beijing.aliyuncs.com/" + key;
        String bucketName = "pic-cui-0622";

        try {
            ossClient.putObject(bucketName, key, file.getInputStream());
            brandMapper.updateImageUrl(manId, imagePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return imagePath;
    }

    @Override
    public Brand getBrandByBrdId(String brdId) {
        return brandMapper.getById(brdId);
    }

    @Override
    public String getBrandUserId(String brdId) {
        return brandMapper.getBrandUserId(brdId);
    }

}
