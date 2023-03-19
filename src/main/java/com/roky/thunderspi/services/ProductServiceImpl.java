package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.CategoryProduct;
import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.entities.User;
import com.roky.thunderspi.repositories.ProductRepo;
import com.roky.thunderspi.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepo productRepo;


    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product findProdById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
