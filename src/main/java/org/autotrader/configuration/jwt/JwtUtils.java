package org.autotrader.configuration.jwt;

import java.util.Base64;
import java.util.Date;
import java.security.Key;

import org.autotrader.model.Utilisateur;
import org.autotrader.repository.UtilisateurRepository;
//import org.apache.catalina.User;
import org.autotrader.service.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;


@Component
public class JwtUtils {
	
	 private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	  public String getUserNameFromJwtToken(String token) {
	    return Jwts.parserBuilder().setSigningKey(key()).build()
	               .parseClaimsJws(token).getBody().getSubject();
	  }
	  
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
	    
	    public Utilisateur getActualUser(HttpServletRequest request, UtilisateurRepository utilisateurRepository)throws Exception{
	    	Utilisateur user = null;
	    	String username = "";
	    	
	    	String jwt = this.parseJwt(request);
		      if (jwt != null && validateJwtToken(jwt)) {
		        username = getUserNameFromJwtToken(jwt);
		      }
		      
		     user = utilisateurRepository.findByEmail(username);
	    	
	    	return user;
	    }
		      
      private String parseJwt(HttpServletRequest request) {
		    String headerAuth = request.getHeader("Authorization");

		    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
		      return headerAuth.substring(7);
		    }

		    return null;
		  }
}
