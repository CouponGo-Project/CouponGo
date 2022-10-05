package com.coupongo.requests.CouponRelated;

import com.coupongo.entities.Users.UserTypes.CompanyExecutive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateCouponRequest {

    @NotBlank
    @Max(500)
    private String description;
    @NotBlank
    @Min(1)
    private Integer discountRate;
    @NotBlank
    @Min(1)
    private Integer quantityOfCoupon;
    @NotBlank
    private Integer creatorID;

}
