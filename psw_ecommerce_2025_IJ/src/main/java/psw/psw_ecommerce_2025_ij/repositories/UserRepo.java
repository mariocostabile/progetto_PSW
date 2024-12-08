package psw.psw_ecommerce_2025_ij.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<LocalUser, Long> {
    Optional<LocalUser> findByUsernameIgnoreCase(String username);
    Optional<LocalUser> findByEmailIgnoreCase(String email);

}
