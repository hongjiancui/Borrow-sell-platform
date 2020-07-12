package com.neusoft.bsp.product.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.entity.Wishlist;
import com.neusoft.bsp.product.service.ProductService;
import com.neusoft.bsp.product.service.WishlistService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/pro")
@RestController
public class BvoProductController {
    @Resource
    private ProductService productService;

    @Resource
    private WishlistService wishlistService;

    @RequestMapping(value = "/bvo/product/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R getProductsBS() {
        return R.isSuccess().data(productService.getProductsBS());
    }

    @RequestMapping(value = "/bvo/product/detail", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R getProductDetail(@RequestParam("proId") String proId) {
        return R.isSuccess().data(productService.getProductDetail(proId));
    }

    @RequestMapping(value = "/bvo/wishlist/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R addWishlist(@RequestBody Wishlist wishlist) {
        int result = wishlistService.addWishlist(wishlist);

        if (result == 0) {
            return R.isFail().msg("fail to add");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/bvo/wishlist/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R deleteWishlist(@RequestBody Wishlist wishlist) {
        int result = wishlistService.deleteWishlist(wishlist.getWitId());

        if (result == 0) {
            return R.isFail().msg("fail to delete");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/bvo/wishlist/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R getWishlist(@RequestParam("dsrId") String dsrId) {
        return R.isSuccess().data(wishlistService.getDsrWishlist(dsrId));
    }
}
