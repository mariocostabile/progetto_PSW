package psw.psw_ecommerce_2025_ij.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import psw.psw_ecommerce_2025_ij.entities.Address;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long>{

    List<Address> findAddressByLocalUser_Id(Long id);


}
