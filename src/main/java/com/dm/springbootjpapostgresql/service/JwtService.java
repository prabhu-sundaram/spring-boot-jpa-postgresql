package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.model.User4;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    private String secretKey=null;

    public String getSecretKey(){
        return secretKey="be2ee8bb2cb0daf15ec91fe76b6dd176f1cbfbea4f73f2a13ff2c50088520cacbdf7a198df5c97c1c41d186b16733116cf228c4866a074e44a4a6546adacec8f83eb34baa59dc7e3f3735e80b4c23ca96343320e5df8ba123c220cb4f3da46295e35a89375b6e8af8d1b4e6f59ed06569c4ce10ea6396f4efa24748426de90fce425b1b1c66d5e230c93c05b66a2392ead9fb7ee77d5714d8d8197213b5c5ad470de73b6d79230b23a565d6f7a30ca851d3a11f2be45143e39ac8eed5607e5236bd3cdad2cbbee7217a98b28d814f4af1223441dd87cea838ed3a44c629be0171ff387b54b0f03a9a3234d043b2b8bd35fbf5fff0e78ce0928d2f19808887197";

    }
    public String generateToken(User4 user) {
        Map<String,Object> claims = new HashMap<>();


        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(user.getUserName())
                .issuer("prabhu")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*10*1000))    //1 minute=60millisecs*1000
                .and()
                .signWith(generateKey())
                .compact();
    }

    private SecretKey generateKey() {
        byte[] decode = Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decode);
    }

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
        Claims claims=extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName=extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }
}
