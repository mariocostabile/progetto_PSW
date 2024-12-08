package psw.psw_ecommerce_2025_ij.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;
import psw.psw_ecommerce_2025_ij.entities.WebOrder;

import java.util.List;

public interface WebOrderRepo extends JpaRepository<WebOrder, Long> {
    List<WebOrder> findByLocalUser(LocalUser localUser);
}
