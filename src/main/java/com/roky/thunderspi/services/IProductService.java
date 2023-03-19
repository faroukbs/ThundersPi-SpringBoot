package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.CategoryProduct;
import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.repositories.ProductRepo;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();
    Product findProdById(Long id);
    Product addProduct(Product product);
    Product editProduct(Product product);
    void deleteProduct(Long id);
   // List<Product> getAllProductByCategory(CategoryProduct category);
   // void calculeEtoile(Double rev, Long idP, Long idC);

}
