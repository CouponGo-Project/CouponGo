package com.coupongo.entities;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductRequest {
    private int  couponId;
    private String productName;
}
