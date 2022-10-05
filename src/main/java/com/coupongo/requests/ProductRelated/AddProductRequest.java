package com.coupongo.requests.ProductRelated;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddProductRequest {
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
    @NotBlank
    private Integer creatorID;
}
