package com.coupongo.dataAccess.abstracts;

import com.coupongo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}