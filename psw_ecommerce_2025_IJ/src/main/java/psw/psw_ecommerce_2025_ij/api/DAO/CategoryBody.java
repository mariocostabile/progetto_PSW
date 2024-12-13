package psw.psw_ecommerce_2025_ij.api.DAO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import psw.psw_ecommerce_2025_ij.entities.Product;

import java.util.List;

@Getter
@Setter
public class CategoryBody {

    @NotBlank
    @NotNull
    private String name;

    private List<Product> products;
}
