package psw.psw_ecommerce_2025_ij.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import psw.psw_ecommerce_2025_ij.entities.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {
}
