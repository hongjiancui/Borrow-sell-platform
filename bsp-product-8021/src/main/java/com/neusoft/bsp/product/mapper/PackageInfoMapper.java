package com.neusoft.bsp.product.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.product.entity.PackageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PackageInfoMapper extends BaseMapper<String, PackageInfo> {
    int addPackageInfo(Map<String, String> params);

    int updatePackage(Map<String, String> params);
}
