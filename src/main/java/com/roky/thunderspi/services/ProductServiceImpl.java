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
    private final UserRepo userRepo;


    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product findProdById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public long addProduct(Product product) {
        return productRepo.save(product).getId();
    }

    @Override
    public long editProduct(Product product) {
        return productRepo.save(product).getId();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
    public List<Product> getAllProductByCategory(CategoryProduct category) {
        return productRepo.findByCategory(category);
    }

    public Product updateProduit(Product u) {
        return productRepo.save(u);
    }

    public void calculeEtoile(Double rev, Long idP, Long idC) throws Exception {

        Product p = findProdById(idP);
        Double rectif = null;
        User c = userRepo.findById(idC).orElse(null);
        Map<Long, Double> temp = p.getClientEtoile();
        Double sum = 0.0;
        if (((p != null)) && (rev >= 0 && rev <= 5)) {
            temp.put(idC, rev);
            for (Double value : temp.values()) {
                sum += value;

            }
            rectif = sum / temp.size();
            if (rectif >= 0 && rectif < 0.5) {
                p.setEtoile(0.0);
                p.setClientEtoile(temp);
            } else if (rectif >= 0.5 && rectif < 1) {
                p.setEtoile(0.5);
                p.setClientEtoile(temp);
            } else if (rectif >= 1 && rectif < 1.5) {
                p.setEtoile(1.0);
                p.setClientEtoile(temp);
            } else if (rectif >= 1.5 && rectif < 2) {
                p.setEtoile(1.5);
                p.setClientEtoile(temp);
            } else if (rectif >= 2 && rectif < 2.5) {
                p.setEtoile(2.0);
                p.setClientEtoile(temp);
            } else if (rectif >= 2.5 && rectif < 3) {
                p.setEtoile(2.5);
                p.setClientEtoile(temp);
            } else if (rectif >= 3 && rectif < 3.5) {
                p.setEtoile(3.0);
                p.setClientEtoile(temp);
            } else if (rectif >= 3.5 && rectif < 4) {
                p.setEtoile(3.5);
                p.setClientEtoile(temp);
            } else if (rectif >= 4 && rectif < 4.5) {
                p.setEtoile(4.0);
                p.setClientEtoile(temp);
            } else if (rectif >= 4.5 && rectif < 4.75) {
                p.setEtoile(4.5);
                p.setClientEtoile(temp);
            } else if (rectif >= 4.75 && rectif <= 5) {
                p.setEtoile(5.0);
                p.setClientEtoile(temp);
            }
            updateProduit(p);
        }
    }



}
