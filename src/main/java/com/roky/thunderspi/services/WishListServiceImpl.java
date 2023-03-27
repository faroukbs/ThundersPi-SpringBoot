package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.entities.User;
import com.roky.thunderspi.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class WishListServiceImpl implements IWishListService{

    private UserServiceImpl userService;
    private ProductServiceImpl productService;
    private ProductRepo productRepo;
    @Override
    public User findClientById(Long id) {
        return userService.findById(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productService.findProdById(id);
    }

    @Override
    public Set<Product> findAll() {
        return null;
    }

    @Override
    public void markProductAsWished(Long productId) {

    }

    @Override
    public void delete(Long productId) {

    }

    @Override
    public void removeProductFromWishlistWhenIsSold(Long productId) {

    }
}
