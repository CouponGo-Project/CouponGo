package com.coupongo.dataAccess.abstracts;

import com.coupongo.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponDao  extends JpaRepository<Coupon,Integer> {
}
