package com.coupongo.entities.Users;

import com.coupongo.entities.BaseEntity.BaseEntity;
import com.coupongo.entities.Role.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Entity
@Getter
@Table(name = "users")
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class User extends BaseEntity {

    @Email
    @NotBlank
    @Column( unique = true)
    private String email;

    @NotBlank
    @Column( unique = true)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private boolean isActive= true; //DEFAULT VALUE

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String email, String username, String password, String firstName, String lastName, Set<Role> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public void updateStatusToTrue(){
        this.isActive=true;
    }

    public void updateStatusToFalse(){
        this.isActive=false;
    }

    public void updateRole(Set<Role> roles){
        this.roles=roles;
    }
}

