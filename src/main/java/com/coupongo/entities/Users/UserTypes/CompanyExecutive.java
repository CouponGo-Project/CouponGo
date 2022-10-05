package com.coupongo.entities.Users.UserTypes;

import com.coupongo.entities.Company.Company;
import com.coupongo.entities.Coupon.Coupon;
import com.coupongo.entities.Role.Role;
import com.coupongo.entities.Users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue(value = "COMPANY_EXECUTIVE")
public class CompanyExecutive extends User {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "coupons_created_by_executive",
            joinColumns = @JoinColumn(name = "executive_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    private List<Coupon> couponsCreated=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyID")
    private Company company;

    public CompanyExecutive(String email, String username, String password, String firstName, String lastName, Set<Role> roles, List<Coupon> couponsCreated,Company company) {
        super(email, username, password, firstName, lastName, roles);
        this.couponsCreated = couponsCreated;
        this.company=company;
    }
}
