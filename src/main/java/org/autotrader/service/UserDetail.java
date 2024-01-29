/**
 * 
 */
package org.autotrader.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.autotrader.model.Utilisateur;
import org.autotrader.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author miaro
 *
 */
@Service
public class UserDetail implements UserDetailsService {
	
	@Autowired
	UtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
				
		Utilisateur user = utilisateurRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Cet utilisateur n'existe pas");
		}
				
		Set<GrantedAuthority> authorities = user.getRoles().stream().
				map((role) -> new SimpleGrantedAuthority(role.getDesignation())).collect(Collectors.toSet());
				
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}
