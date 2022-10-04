package com.coupongo.api.controller;

import com.coupongo.business.abstracts.CouponService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coupon")
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("getall")
    public DataResult<List<Coupon>> getAll() {
        return  this.couponService.getAll();
    }

    @PostMapping("add")
    public Result addCoupon(@RequestBody Coupon coupon) {
        return this.couponService.addCoupon(coupon);
    }

    @DeleteMapping("delete")
    public DataResult<Coupon> deleteCoupon(int couponId) {
        return this.couponService.deleteCoupon(couponId);
    }

    public DataResult<Coupon> updateCoupon(Coupon coupon) {
        return null;
    }
}
