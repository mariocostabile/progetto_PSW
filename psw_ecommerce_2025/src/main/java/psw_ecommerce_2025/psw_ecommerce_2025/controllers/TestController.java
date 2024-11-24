package psw_ecommerce_2025.psw_ecommerce_2025.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;






@RestController  //gli dico che è un controller
@RequestMapping("/test") //con questo posso fare il mapping tramite l'url su localhost
public class TestController {

    @GetMapping("/hello")   //con get si fanno metodi che ritornano roba dal db 
    public String hello() {
        return "hello word";
    }
    
    @PostMapping("/helloPost") //con post si fanno metodi che mettono roba nuova nel db
    public String helloPost() {
        return "hello word from post";
    }

    @DeleteMapping("/helloDelete")//con delete si fanno metodi che eliminano roba dal db
    public String helloDelete(){
        return "hello word from delete";
    }

    @PutMapping("/helloPut")//con put si fanno metodi che aggiornano roba esistente nel db 
    public String helloPut(){
        return "hello word from put";
    }
    //a livello meccanico fanno tutti e 4 la stessa cosa però per convenzione si differenziano così

    //se volessi passare dei parametri da utilizzare dentro il metodo ?
    @GetMapping("/echo")
    public String echo(@RequestParam("value") String value1) {  //request param serve per far capire che richiedo i parametri con 
        return value1;                                           //chiave "value" da fuori e la uso nel metodo sempre con lo 
    }                                                            //stesso nome 
}
