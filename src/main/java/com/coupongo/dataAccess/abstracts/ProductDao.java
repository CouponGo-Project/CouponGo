package com.coupongo.dataAccess.abstracts;

import com.coupongo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}

