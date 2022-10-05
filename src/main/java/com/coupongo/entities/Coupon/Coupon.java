package com.coupongo.entities.Coupon;

import com.coupongo.entities.BaseEntity.BaseEntity;
import com.coupongo.entities.Users.UserTypes.CompanyExecutive;
import com.coupongo.entities.Users.UserTypes.Customer;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "coupons")
public class Coupon extends BaseEntity {

    @Max(500)
    private String description;

    @NotBlank
    private Integer discountRate;

    @NotBlank
    @Min(1)
    private Integer quantityOfCoupon;

    //TODO
//    @Column(name = "location")
//    private String CouponPickUpLocation;
//

    public Coupon(String description, Integer discountRate, Integer quantityOfCoupon, CompanyExecutive creator) {
        this.description = description;
        this.discountRate = discountRate;
        this.quantityOfCoupon = quantityOfCoupon;
        this.creator = creator;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id")
    private CompanyExecutive creator;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "coupons_of_customer",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    private List<Customer> customersCollectedThisCoupon= new ArrayList<>();

}