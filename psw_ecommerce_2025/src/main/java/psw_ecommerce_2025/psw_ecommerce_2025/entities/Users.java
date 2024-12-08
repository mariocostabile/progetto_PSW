package psw_ecommerce_2025.psw_ecommerce_2025.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * le entities sono gli oggetti che metto nelle tabelle sulle quali faccio operazioni
 * tramite i services
 */

@Data //lombok fa automaticamente i getter e setter
@NoArgsConstructor //lombok fa il costruttore vuoto
@AllArgsConstructor //lombok fa il costruttore pieno
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="nome")
    private String nome;
    @Column(name="cognome")
    private String cognome;
    @Column(name="email", nullable = false, unique = true)
    private String email;

}
