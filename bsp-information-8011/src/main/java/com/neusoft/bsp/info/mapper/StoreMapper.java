package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.info.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper extends BaseMapper<String, Store> {
    List<Store> getStoreByDsrId(@Param("dsrId") String dsrId);

    int updateImageUrl(@Param("strId") String strId, @Param("imageUrl") String imageUrl);
}
