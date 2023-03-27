package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.entities.User;

import java.util.Set;

public interface IWishListService {
     User findClientById(Long id);
     Product findProductById(Long id);
    public Set<Product> findAll();

    public void markProductAsWished(Long productId);
    public void delete(Long productId);
    public void removeProductFromWishlistWhenIsSold(Long productId);

}
