package psw.psw_ecommerce_2025_ij.api.controllers.category;


import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psw.psw_ecommerce_2025_ij.api.DAO.CategoryBody;
import psw.psw_ecommerce_2025_ij.entities.Category;
import psw.psw_ecommerce_2025_ij.services.CategoryService;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryBody categoryBody) {
        return ResponseEntity.ok(categoryService.addCategory(categoryBody));
    }
}
