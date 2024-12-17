package psw.psw_ecommerce_2025_ij.api.controllers.test;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoControllerKey {


    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public String hello() {
        return "hello from gay keycloak";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public String hello2() {
        return "hello from gay keycloak ADMIN";
    }

    @GetMapping("/hello-3")
    //ha bisogno del token anche se non uso PreAuth per via di SpringSec
    public String hello3() {
        return "hello from gay keycloak GUEST";
    }
}
