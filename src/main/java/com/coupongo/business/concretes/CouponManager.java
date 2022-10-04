package com.coupongo.business.concretes;

import com.coupongo.business.abstracts.CouponService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.abstracts.CouponDao;
import com.coupongo.entities.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponManager implements CouponService {

    private CouponDao couponDao;

    @Autowired
    public CouponManager(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    @Override
    public DataResult<List<Coupon>> getAll() {
        return new SuccessDataResult<>(this.couponDao.findAll(),"coupons listed");
    }

    @Override
    public Result addCoupon(Coupon coupon) {
        this.couponDao.save(coupon);
        return new SuccessResult("Coupon added");
    }

    @Override
    public DataResult<Coupon> deleteCoupon(int couponId) {
        this.couponDao.deleteById(couponId);
        return new SuccessDataResult<>("The Coupon with number: " + couponId + " is deleted.");
    }

    @Override
    public DataResult<Coupon> updateCoupon(Coupon coupon) {
        return null;
    }
}