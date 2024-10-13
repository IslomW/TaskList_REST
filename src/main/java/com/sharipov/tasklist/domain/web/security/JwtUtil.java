package com.sharipov.tasklist.domain.web.security;

import com.sharipov.tasklist.domain.web.dto.auth.AuthDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final int accessTokeLiveTime = 1000 * 3600;
    private static String secretKey = "dfjs23lkjdfalkjflkjsaldkjflk63457sdhjfklhgjkha568756dfasdfasfghdahertjytrikyt567974436sdfjdklsjaflk";


    public static String encode(String username, String password) {
        Map<String, String> extraClaims = new HashMap<>();
        extraClaims.put("username", username);
        extraClaims.put("password", password);


        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + accessTokeLiveTime))
                .signWith(getSignInKey())
                .compact();
    }


    public static AuthDTO decode(String token) {
        Claims claims = Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String username = claims.getSubject();
        String password = claims.getSubject();
        return new AuthDTO(username, password);
    }

    private static SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
