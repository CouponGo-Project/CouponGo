package com.coupongo.dataAccess.UserRepos;

import com.coupongo.entities.Users.UserTypes.CompanyExecutive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyExecutiveRepo extends JpaRepository<CompanyExecutive,Integer> {
}
