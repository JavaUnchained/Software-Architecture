package com.example.foodeliver.service.JWT;

import com.sun.istack.NotNull;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public final class JwtUtilService {
    private static final String KEY = "secret";

    @NotNull
    public static String extractUsername(@NotNull final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @NotNull
    public static Date extractExpiration(@NotNull final String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    @NotNull
    public static <T> T extractClaim(@NotNull final String token,
                                     @NotNull final Function<? super Claims, T> claimsResolver) {
        return claimsResolver.apply(extractAllClaims(token));
    }


    @NotNull
    private static Claims extractAllClaims(@NotNull final String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    @NotNull
    private static Boolean isTokenExpired(@NotNull final String token) {
        return extractExpiration(token).before(new Date());
    }

    @NotNull
    public static String generateToken(@NotNull final UserDetails userDetails) {
        return createToken(new HashMap<>(), userDetails.getUsername());
    }

    @NotNull
    private static String createToken(@NotNull final Map<String, Object> claims,@NotNull final String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public static boolean validateToken(@NotNull final String token,@NotNull final UserDetails userDetails) {
        return (extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
