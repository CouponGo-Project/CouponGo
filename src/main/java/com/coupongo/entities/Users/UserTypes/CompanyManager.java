package com.coupongo.entities.Users.UserTypes;


import com.coupongo.entities.Company.Company;
import com.coupongo.entities.Role.Role;
import com.coupongo.entities.Users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue(value = "COMPANY_MANAGER")
public class CompanyManager extends User {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyID")
    private Company company;

    public CompanyManager(String email, String username, String password, String firstName, String lastName, Set<Role> roles,Company company) {
        super(email, username, password, firstName, lastName, roles);
        this.company=company;
    }
}
