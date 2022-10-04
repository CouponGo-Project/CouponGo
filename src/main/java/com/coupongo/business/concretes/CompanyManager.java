package com.coupongo.business.concretes;


import com.coupongo.business.abstracts.CompanyService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.abstracts.CompanyDao;
import com.coupongo.dataAccess.abstracts.CouponDao;
import com.coupongo.dataAccess.abstracts.ProductDao;
import com.coupongo.entities.Company;
import com.coupongo.entities.CompanyRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CompanyManager implements CompanyService {

    @Autowired
    private CompanyDao companyDao ;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CouponDao couponDao;


    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<>(this.companyDao.findAll(),"company listed");
    }

    @Override
    public Result addCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setProduct(productDao.getById(companyRequest.getProductId()));
        company.setCoupon(couponDao.getById(companyRequest.getCouponId()));
        System.out.println(company.toString());

        this.companyDao.save(company);
        return new SuccessResult("Company coupon and product added");

    }


    @Override
    public DataResult<Company> deleteCompany(int companyId) {
        this.companyDao.deleteById(companyId);
        return new SuccessDataResult<>("The Product with number: " + companyId+ " is deleted.");
    }

    @Override
    public DataResult<Company> updateCompany(Company company) {
        return null;
    }
}