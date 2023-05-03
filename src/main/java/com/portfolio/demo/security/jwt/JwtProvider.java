package com.portfolio.demo.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.portfolio.demo.security.entity.MainUser;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private int expiration;

	public String generateToken(Authentication authentication) {
		MainUser mainUser = (MainUser) authentication.getPrincipal();
		return Jwts.builder().setSubject(mainUser.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).
				getBody().getSubject();
	}
	
	public boolean ValidateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Malformed Token");
		} catch (UnsupportedJwtException e) {
			logger.error("Token not supported");
		} catch (ExpiredJwtException e) {
			logger.error("Expired Token");
		} catch (IllegalArgumentException e) {
			logger.error("Clear token");
		} catch (SignatureException e) {
			logger.error("Invalid Signature");
		}
		return false;
	}
	
}
