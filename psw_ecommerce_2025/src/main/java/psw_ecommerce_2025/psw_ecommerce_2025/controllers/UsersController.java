package psw_ecommerce_2025.psw_ecommerce_2025.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import psw_ecommerce_2025.psw_ecommerce_2025.entities.Users;//importo da entities
import psw_ecommerce_2025.psw_ecommerce_2025.services.UsersService;

/*
 * i controller raccolgono le richieste dal client e le elaborano tramite i services
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired //notazione che istanzia automaticamente una classe, così evito il costruttore nella classe 
    private UsersService us;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @PostMapping("/add")
    public Users saveUser(@RequestBody Users pippo) { //converto il file json in arrivo in un oggetto User java
        try{
            return us.saveUser(pippo);   //ho spostato tutta la logica nel service
        }
        catch(Exception e){
            return null;
        }
    }   

    @RequestMapping("/addParam")
    public String addUser(@RequestParam("id") int id, @RequestParam("nome") String nome, @RequestParam("cognome") String cognome, 
    @RequestParam("email") String email) {
        Users u = new Users(id, nome, cognome, email);
        return "utente registrato: "+u.getEmail();
    }

    @GetMapping("/getAll")
    public ArrayList<Users> getAll() {
        return us.getAll();
    }

    @GetMapping("/getUser")
    public Users getUsers(@RequestParam("email") String email) {
        return us.getUser(email);
    }

} 
