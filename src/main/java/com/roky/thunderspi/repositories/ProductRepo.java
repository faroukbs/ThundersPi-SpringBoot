package com.roky.thunderspi.repositories;

import com.roky.thunderspi.entities.CategoryProduct;
import com.roky.thunderspi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    public List<Product> findByCategory(CategoryProduct category);


}
