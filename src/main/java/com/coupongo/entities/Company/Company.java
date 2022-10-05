package com.coupongo.entities.Company;

import com.coupongo.entities.BaseEntity.BaseEntity;
import com.coupongo.entities.Product.Product;
import com.coupongo.entities.Users.UserTypes.CompanyExecutive;
import com.coupongo.entities.Users.UserTypes.CompanyManager;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "company")
public class Company extends BaseEntity {

    private String companyName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_and_workerExecutives",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "executiveID"))
    private List<CompanyExecutive> companyExecutiveList=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_and_managers",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id"))
    private List<CompanyManager> companyManagerList=new ArrayList<>();

    @OneToMany(fetch =  FetchType.LAZY)
    @JoinTable(
            name = "company_and_products",
            joinColumns = @JoinColumn(name ="company_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product=new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }
}
