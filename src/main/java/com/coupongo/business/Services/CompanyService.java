package com.coupongo.business.Services;

import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Company.Company;
import com.coupongo.requests.CompanyRelated.CreateCompanyRequest;

import java.util.List;

public interface CompanyService {

    DataResult<List<Company>> getAll();
    Result addCompany(CreateCompanyRequest createCompanyRequest);
    DataResult<Company> deleteCompany(int companyId);
    DataResult<Company> updateCompany(Company company);
}
