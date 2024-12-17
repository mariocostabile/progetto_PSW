package psw.psw_ecommerce_2025_ij.api.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import psw.psw_ecommerce_2025_ij.entities.LocalUser;
import psw.psw_ecommerce_2025_ij.repositories.UserRepo;
//import psw.psw_ecommerce_2025_ij.services.JWTService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    //@Autowired
    //private JWTService jwtService;

    @Autowired
    private UserRepo userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7); //7 caratteri di Bearer+spazio
            try {
                String username = "user" /*jwtService.getUsername(token)*/; //prendo l'username dal token
                Optional<LocalUser> opUser = userRepo.findByUsernameIgnoreCase(username);
                if(opUser.isPresent()){ //se user è presente faccio l'autenticazione
                    LocalUser localUser = opUser.get();
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(localUser, null, new ArrayList<>()); //creo l'autenticazione
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //aggiungo dettagli extra così marco la request come autenticata
                    SecurityContextHolder.getContext().setAuthentication(authentication); //settiamo l'autenticazione appena creata
                }
            }catch (JWTDecodeException e){}

        }
        filterChain.doFilter(request, response); //ad ogni richiesta autenticata o meno passiamo alla prossima in ogni caso
    }
}
