package com.coupongo.entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyId")
    private int companyId;

    @Column(name = "companyName")
    private String companyName;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "couponId")
    private Coupon coupon;


    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;
}
