package psw.psw_ecommerce_2025_ij.api.DAO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class LoginBody {

    @NonNull
    @NotBlank
    private String username;

    @NonNull
    @NotBlank
    private String password;

}
