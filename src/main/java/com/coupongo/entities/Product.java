package com.coupongo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","company"})

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;

    @Column(name = "productName")
    private String productName;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "couponId")
    private Coupon coupon;
}


