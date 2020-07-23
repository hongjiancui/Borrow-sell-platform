package com.neusoft.bsp.info.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.info.entity.Manufacturer;
import com.neusoft.bsp.info.mapper.ManufacturerMapper;
import com.neusoft.bsp.info.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private ManufacturerMapper manufacturerMapper;

    @Resource
    private OSSClient ossClient;

    @Override
    public List<Manufacturer> getAllCompanies(String userId) {
        return manufacturerMapper.getManufacturersByUserId(userId);
    }

    @Override
    public int addCompany(Manufacturer manufacturer) {
        return manufacturerMapper.insert(manufacturer) == 0 ? -1 : manufacturerMapper.getLastId();
    }

    @Override
    public int updateCompany(Manufacturer manufacturer) {
        return manufacturerMapper.update(manufacturer);
    }

    @Override
    public int deleteCompany(String manId) {
        return manufacturerMapper.delete(manId);
    }

    @Override
    public String uploadImage(MultipartFile file, String manId){
        String key = "company/" + IdUtil.randomUUID() + ".jpg";
        String imagePath = "https://pic-cui-0622.oss-cn-beijing.aliyuncs.com/" + key;
        String bucketName = "pic-cui-0622";

        try {
            ossClient.putObject(bucketName, key, file.getInputStream());
            manufacturerMapper.updateImageUrl(manId, imagePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return imagePath;
    }
}
