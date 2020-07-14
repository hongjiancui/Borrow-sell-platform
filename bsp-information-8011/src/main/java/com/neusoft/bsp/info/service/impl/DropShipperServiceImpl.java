package com.neusoft.bsp.info.service.impl;

import com.neusoft.bsp.info.entity.DropShipper;
import com.neusoft.bsp.info.mapper.DropShipperMapper;
import com.neusoft.bsp.info.service.DropShipperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DropShipperServiceImpl implements DropShipperService {
    @Resource
    private DropShipperMapper dropShipperMapper;

    @Override
    public DropShipper getDropShipper(String userId) {
        return dropShipperMapper.getDropShipperByUserId(userId);
    }

    @Override
    public int updateDropShipper(DropShipper dropShipper) {
        return dropShipperMapper.update(dropShipper);
    }

    @Override
    public int addDropShipper(DropShipper dropShipper) {
        return dropShipperMapper.insert(dropShipper);
    }

    @Override
    public DropShipper getDropShipperByDsrId(String dsrId) {
        return dropShipperMapper.getById(dsrId);
    }
}
