/**
 * 
 */
package org.autotrader.controller;

import java.util.Collections;

import org.autotrader.dto.LoginDto;
import org.autotrader.dto.SignupDto;
import org.autotrader.model.Role;
import org.autotrader.model.Utilisateur;
import org.autotrader.repository.RoleRepository;
import org.autotrader.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping(path="/api/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
		
		try {
			
			Authentication authentication = authenticationManager.
					authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Connection avec succes", HttpStatus.OK);
		
	}
	@PostMapping("/signup")
	public ResponseEntity<String> inscription(@RequestBody SignupDto signupDto){
		try {
			if(utilisateurRepository.findByEmail(signupDto.getEmail()) != null) {
				return new ResponseEntity<>("L'utilisateur existe deja", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			Utilisateur user = new Utilisateur();
			
			user.setEmail(signupDto.getEmail());
			String pass = passwordEncoder.encode(signupDto.getPassword());
			user.setPassword(pass);
			
			Role role = roleRepository.findByDesignation("Client");
			user.setRoles(Collections.singleton(role));
			
			utilisateurRepository.save(user);
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Inscription avec succes", HttpStatus.OK);
	}
	
}
