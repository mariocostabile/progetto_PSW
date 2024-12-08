package psw.psw_ecommerce_2025_ij.api.controllers.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;
import psw.psw_ecommerce_2025_ij.entities.WebOrder;
import psw.psw_ecommerce_2025_ij.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<WebOrder> getOrders(@AuthenticationPrincipal LocalUser user){
        return orderService.getOrders(user);
    }

}
