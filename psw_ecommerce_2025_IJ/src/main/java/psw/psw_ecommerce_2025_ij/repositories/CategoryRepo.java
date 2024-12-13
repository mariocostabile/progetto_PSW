package psw.psw_ecommerce_2025_ij.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psw.psw_ecommerce_2025_ij.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
