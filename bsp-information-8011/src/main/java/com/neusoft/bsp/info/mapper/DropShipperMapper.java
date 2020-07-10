package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.info.entity.DropShipper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DropShipperMapper extends BaseMapper<String, DropShipper> {
    DropShipper getDropShipperByUserId(@Param("userId") String userId);
}
