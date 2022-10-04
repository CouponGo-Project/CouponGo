package com.coupongo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coupons")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","company,product"})

public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int couponId;

    @Column(name = "discountRate")
    private String discountRate;

    @Column(name = "adress")
    private String adress;




}