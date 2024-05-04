package com.severusnguyen.schoolmangagement.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

//package Util dùng để tái sử dụng
//Viết class này trước CustomJwtFilter
@Component
public class JwtUtilHelper {

    @Value("${jwt.primaryKey}")
    private String privateKey;

//    public void CreateSecretKey(){
//        //Tạo secret key
//        //Một project API luôn có một key này khi mình làm chuẩn JWT
//        SecretKey key = Jwts.SIG.HS256.key().build(); //or HS384.key() or HS512.key()
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println(secretString);
//    }

    public String generateToken(String data){

        //Đưa privateKey vào key
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        // Sinh ra token
        String jws = Jwts.builder().subject(data).signWith(key).compact();

        return jws;
    }

    public  boolean verifyToken(String token){
        try {
            //Sinh key
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

            //Giải mã token
//            Jwts.parser()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (Exception e){
            return false;
        }
    }
}
