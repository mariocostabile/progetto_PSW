package psw.psw_ecommerce_2025_ij.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psw.psw_ecommerce_2025_ij.entities.Product;
import psw.psw_ecommerce_2025_ij.repositories.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
