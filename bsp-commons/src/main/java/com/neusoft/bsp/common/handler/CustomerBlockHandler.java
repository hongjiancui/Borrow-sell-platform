package com.neusoft.bsp.common.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.neusoft.bsp.common.base.R;

public class CustomerBlockHandler {
    public static R handlerException(BlockException blockException) {
        return R.isBlocked();
    }
}
