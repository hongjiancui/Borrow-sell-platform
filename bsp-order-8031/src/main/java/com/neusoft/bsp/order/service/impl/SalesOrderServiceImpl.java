package com.neusoft.bsp.order.service.impl;

import com.neusoft.bsp.order.entity.Product;
import com.neusoft.bsp.order.entity.SalesOrder;
import com.neusoft.bsp.order.feign.InfoFeignService;
import com.neusoft.bsp.order.feign.ProductFeignService;
import com.neusoft.bsp.order.feign.WalletFeignService;
import com.neusoft.bsp.order.mapper.SalesOrderMapper;
import com.neusoft.bsp.order.service.SalesOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    @Resource
    private SalesOrderMapper salesOrderMapper;

    @Resource
    private ProductFeignService productFeignService;

    @Resource
    private InfoFeignService infoFeignService;

    @Resource
    private WalletFeignService walletFeignService;

    @Override
    public List<SalesOrder> getOrders(String operation, String id) {
        if (operation.equals("0")) {
            return salesOrderMapper.getOrdersByBrdId(id);
        }

        if (operation.equals("1")) {
            return salesOrderMapper.getOrdersByDsrId(id);
        }

        return null;
    }

    @Override
    public SalesOrder getOrderDetail(String saoId) {
        return salesOrderMapper.getDetail(saoId);
    }

    //系统没有对接物流信息，故进行发货操作后状态变更为已完成
    @Override
    public int ship(String saoId) {
        return salesOrderMapper.ship(saoId);
    }

    @Override
    public void cancel(String saoId) {
        //更改订单状态
        salesOrderMapper.cancel(saoId);

        //获取借卖方ID,品牌ID
        SalesOrder salesOrder = salesOrderMapper.getById(saoId);
        String dsrId = salesOrder.getDsrId();
        String brdId = salesOrder.getBrdId();

        //根据借卖方ID获取userId，根据品牌ID获取userId，计算该笔订单的的金额
        String userId_dsr = infoFeignService.getDropShipperByDsrId(dsrId).getUserId();
        String userId_brd = infoFeignService.getBrandUserId(brdId);
        double money = Double.parseDouble(salesOrder.getPrice()) * Double.parseDouble(salesOrder.getProductAmount());

        Map<String, String> params = new HashMap<>();
        params.put("userId_dsr", userId_dsr);
        params.put("userId_brd", userId_brd);
        params.put("money", String.valueOf(money));

        //公司账户退款,借卖方账户接收退款
        walletFeignService.refund(params);
    }

    @Override
    public void pay(Map<String, String> params) {
        String saoId = params.get("saoId");
        String walletId_dsr = params.get("walletId");

        //更改订单状态
        salesOrderMapper.pay(saoId);

        //获取该订单的金额
        SalesOrder salesOrder = salesOrderMapper.getById(saoId);
        double money = Double.parseDouble(salesOrder.getPrice()) * Double.parseDouble(salesOrder.getProductAmount());
        String userId_brd = infoFeignService.getBrandUserId(salesOrder.getBrdId());
        Map<String, String> feignParams = new HashMap<>();
        feignParams.put("walletId_dsr", walletId_dsr);
        feignParams.put("userId_brd", userId_brd);
        feignParams.put("money", String.valueOf(money));

        //更改钱包信息，需要调用wallet服务支付接口
        walletFeignService.pay(feignParams);
    }

    @Override
    public int buy(SalesOrder salesOrder) {
        //调用product服务获取产品信息
        Product product = productFeignService.getProduct(salesOrder.getProId());
        salesOrder.setBrdId(product.getBrdId());
        salesOrder.setPrice(product.getMinRetailPrice());

        int rand = (int) (Math.random() * 9000 + 1000);
        String orderNo = "S00000" + rand;
        salesOrder.setOrderNo(orderNo);

        return salesOrderMapper.insert(salesOrder);
    }
}
