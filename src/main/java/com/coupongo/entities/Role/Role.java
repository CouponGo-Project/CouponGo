package com.coupongo.entities.Role;

import com.coupongo.entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="roles")
@NoArgsConstructor
@Getter
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole name;

    public Role(UserRole roleName) {
        super() ;
        this.name = roleName;
    }
}

