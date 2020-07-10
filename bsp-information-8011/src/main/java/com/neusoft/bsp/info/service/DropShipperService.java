package com.neusoft.bsp.info.service;

import com.neusoft.bsp.info.entity.DropShipper;

public interface DropShipperService {
    DropShipper getDropShipper(String userId);

    int updateDropShipper(DropShipper dropShipper);

    int addDropShipper(DropShipper dropShipper);

    DropShipper getDropShipperByDsrId(String dsrId);
}
