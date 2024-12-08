package psw.psw_ecommerce_2025_ij.api.controllers.auth;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import psw.psw_ecommerce_2025_ij.api.entitiesDTO.LoginBody;
import psw.psw_ecommerce_2025_ij.api.entitiesDTO.LoginResponse;
import psw.psw_ecommerce_2025_ij.api.entitiesDTO.RegistrationBody;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;
import psw.psw_ecommerce_2025_ij.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return new ResponseEntity("USER REGISTERED", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("ERROR_MAIL_USER_ALREADY_EXISTS", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return new ResponseEntity("ERROR_INVALID_JWT", HttpStatus.BAD_REQUEST);
        }else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }


    @GetMapping("/me")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser localUser) {
        return localUser;
    }

}
