package com.coupongo.entities.Product;


import com.coupongo.entities.BaseEntity.BaseEntity;
import com.coupongo.entities.Coupon.Coupon;
import com.coupongo.entities.Users.UserTypes.CompanyExecutive;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "products")
public class Product extends BaseEntity {

    @NotBlank
    private String brand;

    @NotBlank
    private String productName;

    @NotBlank
    @Min(1)
    private Integer quantityInStock;

    @NotBlank
    @Min(1)
    private Integer pricePerUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatorID")
    private CompanyExecutive creator;

    //ADD CATEGORY TODO

    @OneToMany(fetch =  FetchType.LAZY)
    @JoinTable(
            name = "product_and_coupons",
            joinColumns = @JoinColumn(name ="product_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id")
    )
    private List<Coupon> coupon=new ArrayList<>();

    public Product(String brand, String productName, Integer quantityInStock, Integer pricePerUnit, CompanyExecutive creator) {
        this.brand = brand;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.pricePerUnit = pricePerUnit;
        this.creator = creator;
    }
}


