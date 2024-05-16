package com.har.journey.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${app.secret}")
	private String secret;
	
	//#01. Generate Token
	public String generateToken(String subject) {
		return Jwts.builder()
		    .setId("AB256")       //clientId
		    .setSubject(subject)  //client Name
		    .setIssuer("Harish")  // provider Name
		    .setIssuedAt(new Date(System.currentTimeMillis())) //token generation date
		    .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))//token expire date
		    .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret.getBytes())) //signature generating
		    .compact(); //build or generate token
	}
	
	//#02 .Read Claim
	public Claims getClaim(String token) {
		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secret.getBytes())) //set secret key
				.parseClaimsJws(token)                                 //parse the token
				.getBody();
	}
	
	//#03. Read userName
	public String getUserName(String token) {
		return getClaim(token).getSubject();
	}
	
	//#04. Read Expire Date
	public Date getExpDate(String token) {
		return getClaim(token).getExpiration();
	}
	
	//#05. Is Token is valid
	public boolean isTokenValid(String token) {
		return getExpDate(token).before(new Date(System.currentTimeMillis()));
	}
	
	//#06. Validate User and token
	public boolean isValid(String token,String dbUsername) {
		return getUserName(token).equals(dbUsername) && !isTokenValid(token);
	}
	
	
}
