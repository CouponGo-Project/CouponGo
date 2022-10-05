package com.coupongo.business.ServiceImpl;

import com.coupongo.business.Services.CouponService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.CouponRepo;
import com.coupongo.entities.Coupon.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponManager implements CouponService {

    private final CouponRepo couponRepo;

    @Override
    public DataResult<List<Coupon>> getAll() {
        return new SuccessDataResult(this.couponRepo.findAll(),"coupons listed");
    }

    @Override
    public Result addCoupon(Coupon coupon) {
        this.couponRepo.save(coupon);
        return new SuccessResult("Coupon added");
    }

    @Override
    public DataResult<Coupon> deleteCoupon(int couponId) {
        this.couponRepo.deleteById(couponId);
        return new SuccessDataResult("The Coupon with number: " + couponId + " is deleted.");
    }

    @Override
    public DataResult<Coupon> updateCoupon(Coupon coupon) {
        return null;
    }
}