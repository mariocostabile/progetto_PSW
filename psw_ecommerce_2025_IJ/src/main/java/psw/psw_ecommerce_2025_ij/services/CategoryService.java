package psw.psw_ecommerce_2025_ij.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psw.psw_ecommerce_2025_ij.api.DAO.CategoryBody;
import psw.psw_ecommerce_2025_ij.entities.Category;
import psw.psw_ecommerce_2025_ij.repositories.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category addCategory(CategoryBody categoryBody) {
        Category category = new Category();
        category.setName(categoryBody.getName());
        category.setProducts(categoryBody.getProducts());
        return categoryRepo.save(category);
    }
}
