package com.coupongo.dataAccess.abstracts;

import com.coupongo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Integer> {
}
