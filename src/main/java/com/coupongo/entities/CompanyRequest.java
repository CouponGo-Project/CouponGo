package com.coupongo.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CompanyRequest {

    private int  couponId;
    private int productId;
    private String companyName;

}
