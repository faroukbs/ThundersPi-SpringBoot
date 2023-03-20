package com.roky.thunderspi.controllers;

import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private IProductService iProductService;


    @GetMapping("/getAll")
    public List<Product> findAllProducts() {
        return iProductService.findAllProducts();
    }

    @GetMapping("getAll/{id}")
    public Product findProdById(@PathVariable Long id) {
        return iProductService.findProdById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return iProductService.addProduct(product);
    }

    @PutMapping("update")
    public Product editProduct(@RequestBody Product product) {
        return iProductService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        iProductService.deleteProduct(id);
    }

}
