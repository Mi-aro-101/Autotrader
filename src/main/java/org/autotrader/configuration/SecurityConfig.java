/**
 * 
 */
package org.autotrader.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author miaro
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/api/auth/**", "/api/public/**", "/api/**").permitAll()
			.requestMatchers("/api/private/**").hasAnyRole("Administrateur")
			.anyRequest().authenticated()
		).csrf(AbstractHttpConfigurer::disable);
		 		
		return http.build();
	}

}
