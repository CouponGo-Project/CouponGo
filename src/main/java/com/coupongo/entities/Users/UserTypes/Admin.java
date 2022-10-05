package com.coupongo.entities.Users.UserTypes;


import com.coupongo.entities.Role.Role;
import com.coupongo.entities.Users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue(value = "ADMIN")
public class Admin extends User {

    public Admin(String email, String username, String password, String firstName, String lastName, Set<Role> roles) {
        super(email, username, password, firstName, lastName, roles);
    }
}
