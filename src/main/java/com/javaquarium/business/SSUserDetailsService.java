package com.javaquarium.business;

import com.javaquarium.beans.data.UtilisateurDO;
import com.javaquarium.beans.data.UtilisateurRoleDO;
import com.javaquarium.repository.UtilisateurRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by quentin on 20/02/2017.
 */
@Service

public class SSUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSUserDetailsService.class);

    private UtilisateurRepository userRepository;

    public SSUserDetailsService(UtilisateurRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UtilisateurDO user = userRepository.findOneByUsername(username);
            if (user == null) {
                LOGGER.warn("user not found with the provided username");
                throw new UsernameNotFoundException("No user present with username: "+username);
            }
            LOGGER.warn(" user from username " + user.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(UtilisateurDO user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(UtilisateurRoleDO role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        LOGGER.warn("user authorities are " + authorities.toString());
        return authorities;
    }
}
