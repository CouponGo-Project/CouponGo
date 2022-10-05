package com.coupongo.entities.Users.UserTypes;

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
@DiscriminatorValue(value = "CUSTOMER")
public class Customer extends User {

   @OneToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "coupons_of_customer",
           joinColumns = @JoinColumn(name = "customer_id"),
           inverseJoinColumns = @JoinColumn(name = "coupon_id"))
   private List<Coupon> listOfCouponsCollected=new ArrayList<>();

   public Customer(String email, String username, String password, String firstName, String lastName, Set<Role> roles, List<Coupon> listOfCouponsCollected) {
      super(email, username, password, firstName, lastName, roles);
      this.listOfCouponsCollected = listOfCouponsCollected;
   }
}
