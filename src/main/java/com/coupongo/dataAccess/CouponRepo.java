package com.coupongo.dataAccess;

import com.coupongo.entities.Coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Integer> {
}
