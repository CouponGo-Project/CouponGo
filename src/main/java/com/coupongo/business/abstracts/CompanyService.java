package com.coupongo.business.abstracts;

import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Company;
import com.coupongo.entities.CompanyRequest;

import java.util.List;

public interface CompanyService {

    DataResult<List<Company>> getAll();
    Result addCompany(CompanyRequest companyRequest);
    DataResult<Company> deleteCompany(int companyId);
    DataResult<Company> updateCompany(Company company);
}
