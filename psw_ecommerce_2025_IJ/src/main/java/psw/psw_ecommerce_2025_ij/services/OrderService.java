package psw.psw_ecommerce_2025_ij.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;
import psw.psw_ecommerce_2025_ij.entities.WebOrder;
import psw.psw_ecommerce_2025_ij.repositories.WebOrderRepo;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private WebOrderRepo webOrderRepo;

    public List<WebOrder> getOrders(LocalUser localUser) {
        return webOrderRepo.findByLocalUser(localUser);
    }


}
