package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.info.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper extends BaseMapper<String, Brand> {
    List<Brand> getBrandsByManId(@Param("manId") String manId);

    int updateImageUrl(@Param("brdId") String brdId, @Param("imageUrl") String imageUrl);

    String getBrandUserId(@Param("brdId") String brdId);

    int getLastId();

    List<String> getBrdIdByUserId(@Param("userId") String userId);
}
