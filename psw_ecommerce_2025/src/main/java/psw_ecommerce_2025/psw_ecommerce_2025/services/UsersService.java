package psw_ecommerce_2025.psw_ecommerce_2025.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psw_ecommerce_2025.psw_ecommerce_2025.UTILITY.exceptions.UsersAlreadyExistException;
import psw_ecommerce_2025.psw_ecommerce_2025.entities.Users;
import psw_ecommerce_2025.psw_ecommerce_2025.repositories.UsersRepository;


//service: ambiente isolato nel quale vengono svolte determinate operazioni 
//serve per separare i controller che prendono le richieste da quelli che eseguono effettivamente

@Service
public class UsersService {

    public ArrayList<Users> db = new ArrayList<>();

    @Autowired
    UsersRepository usersRepository;

    public Users saveUser( Users u ) throws UsersAlreadyExistException{
        /*
        //dovuti controlli
        db.add(u);
        return u;
        */
        return usersRepository.save(u);
    }

    public ArrayList<Users> getAll(){
        return db;
    }

    public Users getUser(String email){
        return usersRepository.findByEmail(email);
    }
}
