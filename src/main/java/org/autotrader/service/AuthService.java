/**
 * 
 */
package org.autotrader.service;

import java.util.Collections;

import org.autotrader.dto.SignupDto;
import org.autotrader.model.InfoUtilisateur;
import org.autotrader.model.Role;
import org.autotrader.model.Utilisateur;
import org.autotrader.repository.InfoUtilisateurRepository;
import org.autotrader.repository.RoleRepository;
import org.autotrader.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * @author miaro
 *
 */
@Service
public class AuthService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private InfoUtilisateurRepository infoUtilisateurRepository;
	
	@Transactional
	public ResponseEntity<String> newUser(SignupDto signupDto)throws Exception{
		
		Utilisateur user = new Utilisateur();
		
		Integer userSeq = utilisateurRepository.getUtilisateurSeq();
		
		// Insertion utilisateur
		user.setIdUtilisateur(userSeq);
		user.setEmail(signupDto.getEmail());
		String pass = passwordEncoder.encode(signupDto.getPassword());
		user.setPassword(pass);
		
		Role role = roleRepository.findByDesignation("Client");
		user.setRoles(Collections.singleton(role));
		
		utilisateurRepository.save(user);
		
		// Insertion info utilisateur
		InfoUtilisateur infoUtilisateur = new InfoUtilisateur();
		infoUtilisateur.setAdresse(signupDto.getAdresse());
		infoUtilisateur.setContact(signupDto.getContact());
		infoUtilisateur.setNom(signupDto.getNom());
		infoUtilisateur.setPrenom(signupDto.getPrenom());
		infoUtilisateur.setUtilisateur(user);
		
		infoUtilisateurRepository.save(infoUtilisateur);
		
		return new ResponseEntity<String>("Inscription avec success", HttpStatus.OK);
	}
	
}
