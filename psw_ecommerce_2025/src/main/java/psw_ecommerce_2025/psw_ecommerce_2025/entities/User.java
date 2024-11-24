package psw_ecommerce_2025.psw_ecommerce_2025.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok fa automaticamente i getter e setter
@NoArgsConstructor //lombok fa il costruttore vuoto
@AllArgsConstructor //lombok fa il costruttore pieno
public class User {
    private String nome;
    private String cognome;
    private String email;

}
