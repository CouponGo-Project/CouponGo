package com.coupongo.business.ServiceImpl;


import com.coupongo.business.Services.CompanyService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.CompanyRepo;
import com.coupongo.dataAccess.CouponRepo;
import com.coupongo.dataAccess.ProductRepo;
import com.coupongo.entities.Company.Company;
import com.coupongo.requests.CompanyRelated.CreateCompanyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyManager implements CompanyService {

    private final CompanyRepo companyRepo;

    private final ProductRepo productRepo;

    private final CouponRepo couponRepo;


    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<>(this.companyRepo.findAll(),"company listed");
    }

    @Override
    public Result addCompany(CreateCompanyRequest createCompanyRequest) {
        Company company = new Company(
                createCompanyRequest.getCompanyName()
        );

        this.companyRepo.save(company);
        return new SuccessResult("Company Created!");
    }


    @Override
    public DataResult<Company> deleteCompany(int companyId) {
        this.companyRepo.deleteById(companyId);
        return new SuccessDataResult<>("The Product with number: " + companyId+ " is deleted.");
    }

    @Override
    public DataResult<Company> updateCompany(Company company) {
        return null;
    }
}