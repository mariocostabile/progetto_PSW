package psw.psw_ecommerce_2025_ij.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psw.psw_ecommerce_2025_ij.api.entitiesDTO.LoginBody;
import psw.psw_ecommerce_2025_ij.api.entitiesDTO.RegistrationBody;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;
import psw.psw_ecommerce_2025_ij.entities.Role;
import psw.psw_ecommerce_2025_ij.exception.UserAlreadyExistsException;
import psw.psw_ecommerce_2025_ij.repositories.UserRepo;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private JWTService jwtService;

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(userRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                ||userRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        LocalUser localUser = new LocalUser();
        localUser.setFirstname(registrationBody.getFirstname());
        localUser.setLastname(registrationBody.getLastname());
        localUser.setEmail(registrationBody.getEmail());
        localUser.setUsername(registrationBody.getUsername());
        localUser.setPhoneNumber(registrationBody.getPhoneNumber());
        localUser.setRole(Role.USER);
        localUser.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return userRepo.save(localUser);
    }

    public String loginUser(LoginBody loginBody) {
        Optional<LocalUser> opUser = userRepo.findByUsernameIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()){
            LocalUser user = opUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}
