package psw.psw_ecommerce_2025_ij.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    @Value("${encryption.salt.round}") //ignetto dal file di application.properties il valore del saltRound
    private int saltRounds; //contiene il numero di iterazioni con cui generare il salt
    private String salt;

    @PostConstruct //eseguo il metodo solo dopo che la classe è stata inizializzata
    public void postConstruct() { //
        salt = BCrypt.gensalt(saltRounds); //genera una Stringa salt da usare per l'hash della password
    }

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt); //esegue l'hash della password
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword); //verifica se la password passata in chiaro corrisponde ad una salvata precedentemente
    }

}
