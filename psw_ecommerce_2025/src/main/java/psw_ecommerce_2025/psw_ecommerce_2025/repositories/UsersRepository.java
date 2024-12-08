package psw_ecommerce_2025.psw_ecommerce_2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psw_ecommerce_2025.psw_ecommerce_2025.entities.Users;


/*
 * le repositories si occupano di fornire un interfaccia tra le entities 
 * e le operazioni che si effettuano in una tabella (trasforma le richieste in QUERY)
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    boolean existsByEmail(String email);
}
