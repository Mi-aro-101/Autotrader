/**
 * 
 */
package org.autotrader.controller;


import org.autotrader.configuration.jwt.JwtUtils;
import org.autotrader.dto.JwtResponse;
import org.autotrader.dto.LoginDto;
import org.autotrader.dto.SignupDto;
import org.autotrader.repository.UtilisateurRepository;
import org.autotrader.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){
		
		try {
			
			Authentication authentication = authenticationManager.
					authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = jwtUtils.generateJwtToken(loginDto.getEmail());

			return ResponseEntity.ok(new JwtResponse(jwt,loginDto.getEmail()));
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
	@PostMapping("/signup")
	public ResponseEntity<String> inscription(@RequestBody SignupDto signupDto){
		try {
			if(utilisateurRepository.findByEmail(signupDto.getEmail()) != null) {
				return new ResponseEntity<>("L'utilisateur existe deja", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			authService.newUser(signupDto);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Inscription avec succes", HttpStatus.OK);
	}
	
}
