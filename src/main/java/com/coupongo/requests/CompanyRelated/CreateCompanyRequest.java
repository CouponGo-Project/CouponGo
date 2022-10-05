package com.coupongo.requests.CompanyRelated;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateCompanyRequest {

    @NotBlank
    private String companyName;

}
