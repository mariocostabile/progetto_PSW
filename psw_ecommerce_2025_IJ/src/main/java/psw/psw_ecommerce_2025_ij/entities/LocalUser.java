package psw.psw_ecommerce_2025_ij.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "localUser"/*, schema = "orders"*/)
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name="username", nullable = false, unique = true, length = 70)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false, length = 90)
    private String email;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "phoneNumber", unique = true, length = 20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role; //ADMIN o USER

    @JsonIgnore
    @OneToMany(mappedBy = "localUser", cascade = CascadeType.REMOVE, orphanRemoval = true) //se elimino un utente devo eliminare anche tutti gli indirizzi associati dal db, se alcuni indirizzi vengono staccati (orfani) li elimino
    private List<Address> addresses = new ArrayList<>();

}