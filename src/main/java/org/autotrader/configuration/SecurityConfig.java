/**
 * 
 */
package org.autotrader.configuration;

import org.autotrader.configuration.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.DispatcherType;


/**
 * @author miaro
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	@Autowired
	AuthTokenFilter authTokenFilter;
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
			.requestMatchers("/**").permitAll()
//			.requestMatchers("/api/auth/**", "/api/public/**").permitAll()
//			.requestMatchers("/api/private/**").hasAnyRole("Administrateur")
			.anyRequest().authenticated()
		).csrf(AbstractHttpConfigurer::disable);
		
		http.addFilterAfter(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

}
