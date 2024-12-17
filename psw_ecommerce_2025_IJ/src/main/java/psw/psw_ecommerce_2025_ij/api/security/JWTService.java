//package psw.psw_ecommerce_2025_ij.services;
//
///*
//    JSON web token è una stringa criptata che viene passata per verificare le credenziali
//    Effettuato il login viene data all'utente una stringa criptata unica che servirà ad ogni chiamata REST
//    per verificare le credenziali dell'utente
// */
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import psw.psw_ecommerce_2025_ij.entities.LocalUser;
//
//import java.util.Date;
//
//@Service
//public class JWTService {
//
//    @Value("${jwt.algorithm.key}")
//    private String algorithmKey;
//    @Value("${jwt.issuer}")
//    private String issuer;
//    @Value("${jwt.expiryInSeconds}")
//    private int expiryInSeconds;
//
//    private Algorithm algorithm;
//
//    private static final String USERNAME_KEY = "USERNAME";
//
//    @PostConstruct
//    public void postConstruct() {
//        algorithm = Algorithm.HMAC256(algorithmKey);
//    }
//
//    public String generateJWT(LocalUser user) {
//        return JWT.create()
//                .withClaim(USERNAME_KEY, user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + (expiryInSeconds * 1000L)))
//                .withIssuer(issuer)
//                .sign(algorithm);
//    }
//
//    public String getUsername(String token){
//        DecodedJWT jwt = JWT.require(algorithm).build().verify(token); // è richiesta la signature con quell'algoritmo
//        return jwt.getClaim(USERNAME_KEY).asString();  //specifico che il claim deve essere string
//    }//ritorna l'eccezione se il token non è valido
//}
