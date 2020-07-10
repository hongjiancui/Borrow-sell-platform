package com.neusoft.bsp.order.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.order.entity.SalesOrder;
import com.neusoft.bsp.order.service.SalesOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/order")
@RestController
public class SalesOrderController {

    @Resource
    private SalesOrderService salesOrderService;

    @RequestMapping(value = "/info/get", method = RequestMethod.GET)
    public R getOrders(@RequestParam("operation") String operation,
                       @RequestParam("id") String id) {

        return R.isSuccess().data(salesOrderService.getOrders(operation, id));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public R getOrderDetail(@RequestParam("saoId") String saoId) {
        return R.isSuccess().data(salesOrderService.getOrderDetail(saoId));
    }


    @RequestMapping(value = "/ship", method = RequestMethod.POST)
    public R ship(@RequestBody SalesOrder salesOrder) {
        int result = salesOrderService.ship(salesOrder.getSaoId());

        if (result == 0) {
            return R.isFail().msg("fail to ship");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/ship/cancel", method = RequestMethod.POST)
    public R cancel(@RequestBody SalesOrder salesOrder) {
        salesOrderService.cancel(salesOrder.getSaoId());

        return R.isSuccess();
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public R pay(@RequestBody Map<String, String> params) {
        salesOrderService.pay(params);

        return R.isSuccess();
    }

    @RequestMapping(value = "/product/buy", method = RequestMethod.POST)
    public R buy(@RequestBody SalesOrder salesOrder) {
        int result = salesOrderService.buy(salesOrder);

        if (result == 0) {
            return R.isFail().msg("fail to buy");
        }

        return R.isSuccess();
    }
}
