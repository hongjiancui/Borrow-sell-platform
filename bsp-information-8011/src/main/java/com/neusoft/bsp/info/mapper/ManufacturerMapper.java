package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.info.entity.Manufacturer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManufacturerMapper extends BaseMapper<String, Manufacturer> {
    List<Manufacturer> getManufacturersByUserId(@Param("userId") String userId);

    int updateImageUrl(@Param("manId") String manId, @Param("imageUrl") String imageUrl);

    int getLastId();
}
