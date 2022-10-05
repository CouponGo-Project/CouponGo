package com.coupongo.business.Services;

import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Coupon.Coupon;

import java.util.List;

public interface CouponService {

    DataResult<List<Coupon>> getAll();
    Result addCoupon(Coupon coupon);
    DataResult<Coupon> deleteCoupon(int couponId);
    DataResult<Coupon> updateCoupon(Coupon coupon);
}