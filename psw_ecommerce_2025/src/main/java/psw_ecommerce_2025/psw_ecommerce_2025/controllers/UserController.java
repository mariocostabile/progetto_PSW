package psw_ecommerce_2025.psw_ecommerce_2025.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


import psw_ecommerce_2025.psw_ecommerce_2025.entities.User;//importo da entities
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/users")
public class UserController {
    
    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/add")
    public String saveUser(@RequestBody User pippo) { //converto il file json in arrivo in un oggetto User java
        if(pippo.getEmail()!=null){
            return "ricevuto l'utente con email: "+pippo.getEmail();
        }else{
            return "non ho ricevuto un utente valido.";
        }
    }   

    @RequestMapping("/addParam")
    public String addUser(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome, 
    @RequestParam("email") String email) {
        User u = new User(nome, cognome, email);
        return "utente registrato: "+u.getEmail();
    }

}
