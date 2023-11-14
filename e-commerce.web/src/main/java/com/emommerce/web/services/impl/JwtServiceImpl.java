package com.emommerce.web.services.impl;

import java.security.Key;
import java.util.Date;

import org.apache.el.lang.FunctionMapperImpl.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl {
    
    private String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getSiginKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    private Key getSiginKey() {
        byte[] key = Decoders.BASE64.decode("")
        return Keys.hmacShaKeyFor(key);
    }
    
    private <T> T extractClaim(String token, Function<Claims,T> claimResolvers){
        final Claims claims = extractAllClaims(token);
        return claimResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSiginKey()).build().parseClaimsJws(token).getBody();
    }

    private String exactUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }
}
