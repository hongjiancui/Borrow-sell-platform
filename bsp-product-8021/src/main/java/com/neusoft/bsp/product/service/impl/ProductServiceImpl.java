package com.neusoft.bsp.product.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.product.entity.Brand;
import com.neusoft.bsp.product.entity.Manufacturer;
import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.feign.InformationFeignService;
import com.neusoft.bsp.product.mapper.PackageInfoMapper;
import com.neusoft.bsp.product.mapper.ProductCategoryMapper;
import com.neusoft.bsp.product.mapper.ProductMapper;
import com.neusoft.bsp.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Resource
    private PackageInfoMapper packageInfoMapper;

    @Resource
    private OSSClient ossClient;

    @Resource
    private InformationFeignService informationFeignService;

    @Override
    public List<Map<String, String>> getProductsBasic(String brdId) {
        return productMapper.getProductsByBrandId(brdId);
    }

    @Override
    public int addProduct(Map<String, String> params) {
        int result_1 = productMapper.addProduct(params);

        //获取最新插入product的ID
        String proId = productMapper.getLastProductId();
        params.put("proId", proId);

        //添加该商品的类别信息
        int result_2 = productCategoryMapper.addProductCategory(params);

        //添加该商品的包裹信息
        int result_3 = packageInfoMapper.addPackageInfo(params);

        if (result_1 == 0 || result_2 == 0 || result_3 == 0) {
            return 0;
        }

        return 1;
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int updateProductStatus(Product product) {
        return productMapper.updateStatus(product);
    }

    @Override
    public int deleteProduct(String proId) {
        int result_1 = productMapper.delete(proId);
        int result_2 = productCategoryMapper.delete(proId);
        int result_3 = packageInfoMapper.delete(proId);

        if (result_1 == 0 || result_2 == 0 || result_3 == 0) {
            return 0;
        }

        return 1;
    }

    @Override
    public List<Map<String, String>> getProductDetail(String proId) {
        return productMapper.getProductDetail(proId);
    }

    @Override
    public int updateProductDetail(Map<String, String> params) {
        int result_1 = productMapper.updateDetail(params);
        int result_2 = packageInfoMapper.updatePackage(params);

        if (result_1 == 0 || result_2 == 0) {
            return 0;
        }

        return 1;
    }

    @Override
    public String uploadImage(MultipartFile file, String proId) {
        String key = "product/" + IdUtil.randomUUID() + ".jpg";
        String imagePath = "https://pic-cui-0622.oss-cn-beijing.aliyuncs.com/" + key;
        String bucketName = "pic-cui-0622";

        try {
            ossClient.putObject(bucketName, key, file.getInputStream());
            productMapper.updateImageUrl(proId, imagePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return imagePath;
    }

    @Override
    public List<Map<String, String>> getProductsBS() {
        return productMapper.getProductsBS();
    }

    @Override
    public Product getProduct(String proId) {
        return productMapper.getById(proId);
    }

    @Override
    public List<Map<String, String>> getAllProduct(String userId) {
        List<Map<String, String>> data = new ArrayList<>();

        //调用information服务获取该用户对应的公司
        List<Manufacturer> companies = informationFeignService.getCompanies(userId);

        for (Manufacturer manufacturer : companies) {
            String manId = manufacturer.getManId();
            String manName = manufacturer.getNameEn();

            List<Product> products = productMapper.getProductsByManId(manId);
            for (Product pro : products) {
                Map<String, String> map = new LinkedHashMap<>();

                //调用information服务获取该品牌信息
                Brand brand = informationFeignService.getBrandByBrandId(pro.getBrdId());

                map.put("manId", manId);
                map.put("manName", manName);
                map.put("brdId", brand.getBrdId());
                map.put("brdName", brand.getNameEn());
                map.put("proId", pro.getProId());
                map.put("name", pro.getName());
                map.put("skuCd", pro.getSkuCd());
                map.put("model", pro.getModel());
                map.put("description", pro.getDescription());
                map.put("stsCd", pro.getStsCd());
                data.add(map);
            }
        }

        return data;
    }
}
