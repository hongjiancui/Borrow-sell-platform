package com.neusoft.bsp.order.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.order.entity.Order;
import com.neusoft.bsp.order.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/product/sell", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R sell(@RequestBody Order order) {
        int result = orderService.sell(order);

        if (result == 0) {
            return R.isFail().msg("fail to borrow and sell");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/product/sell/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R getSellOrder(@RequestParam("strId") String strId) {
        return R.isSuccess().data(orderService.getSellOrder(strId));
    }

    @RequestMapping(value = "/product/sell/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R deleteSellOrder(@RequestBody Order order) {
        int result = orderService.deleteSellOrder(order.getBsoId());

        if (result == 0) {
            return R.isFail().msg("fail to delete");
        }

        return R.isSuccess();
    }
}
