package com.coupongo.api;

import com.coupongo.business.Services.CompanyService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Company.Company;
import com.coupongo.requests.CompanyRelated.CreateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("getall")
    public DataResult<List<Company>> getAll() {
        return this.companyService.getAll();
    }

    @PostMapping("add")
    public Result addCompany(@RequestBody CreateCompanyRequest createCompanyRequest) {
        return  this.companyService.addCompany(createCompanyRequest);
    }

    @DeleteMapping("delete")
    public DataResult<Company> deleteCompany(int companyId) {
        return this.companyService.deleteCompany(companyId);
    }


    public DataResult<Company> updateCompany(Company company) {
        return null;
    }

}
