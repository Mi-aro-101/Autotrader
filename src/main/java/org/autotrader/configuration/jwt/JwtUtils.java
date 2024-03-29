package org.autotrader.configuration.jwt;

import java.util.Date;
import java.security.Key;

//import org.apache.catalina.User;
import org.autotrader.service.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {
	
	 private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
//
//	  @Value("${autotrader.app.jwtSecret}")
//	  private String jwtSecret;
//
//	  @Value("${autotrader.app.jwtExpirationMs}")
//	  private int jwtExpirationMs;
//
//	  public String generateJwtToken(Authentication authentication) {
//		System.out.println(authentication.getPrincipal().getClass().getName());
//	    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
////		User userPrincipal = (User) authentication.getPrincipal();
//
//	    return Jwts.builder()
//	        .setSubject((userPrincipal.getEmail()))
//	        .setIssuedAt(new Date())
//	        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//	        .signWith(key(), SignatureAlgorithm.HS256)
//	        .compact();
//	  }
//	  
//
	  public String getUserNameFromJwtToken(String token) {
	    return Jwts.parserBuilder().setSigningKey(key()).build()
	               .parseClaimsJws(token).getBody().getSubject();
	  }
//	  
  public boolean validateJwtToken(String authToken) {
		    try {
		      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
		      return true;
		    } catch (MalformedJwtException e) {
		      logger.error("Invalid JWT token: {}", e.getMessage());
		    } catch (ExpiredJwtException e) {
		      logger.error("JWT token is expired: {}", e.getMessage());
		    } catch (UnsupportedJwtException e) {
		      logger.error("JWT token is unsupported: {}", e.getMessage());
		    } catch (IllegalArgumentException e) {
		      logger.error("JWT claims string is empty: {}", e.getMessage());
		    }

		    return false;
		  }
	
	 private static final String SECRET = "milavaninybeilayspringfamitakytsyambaratelolavabenefatsyhitakoizaysoratanadiaitoizanynosoratakoeto";
	 private static final long EXPIRATION_TIME = 864_000_000; // 10 days
	 
	    public  String generateJwtToken(String username) {
	        return Jwts.builder()
	            .setSubject(username)
	            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	            
	            .signWith(key(),SignatureAlgorithm.HS256)
	            .compact();
	    }
	    
//	    public static String extractUsername(String token) {
//	        return Jwts.parser()
//	            .setSigningKey(SECRET)
//	            .parseClaimsJws(token)
//	            .getBody()
//	            .getSubject();
//	    }
	    private static Key key() {
	    	return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
	    }
	  
}
