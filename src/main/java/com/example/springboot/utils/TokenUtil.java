package com.example.springboot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springboot.model.User;

import java.util.Objects;

public class TokenUtil {
    private static final String TOKEN_SECRET = "zxcvbnm";

    private static String adminName;

    public static String sign(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create()
                    .withClaim("adminName",user.getUsername())
                    .sign(algorithm);
            adminName = user.getUsername();
            return token;
        }
        catch (JWTCreationException exception){
            return "fail";
        }
    }

    public static boolean verify(String token){
        if(token == null){
            return false;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            String username = decodedJWT.getClaim("adminName").asString();
            return Objects.equals(username, adminName);
        }
        catch (JWTVerificationException exception){
            return false;
        }
    }

}
