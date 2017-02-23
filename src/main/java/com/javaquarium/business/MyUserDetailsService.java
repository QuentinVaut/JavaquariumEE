package com.javaquarium.business;

import com.javaquarium.beans.data.RoleDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.repository.RoleRepository;
import com.javaquarium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by quentin on 21/02/2017.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

 /*   public MyUserDetailsService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }*/

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDO user = userRepository.findByusername(s);
        if (user == null) {
            LOGGER.warn("user not found with the provided username");
            throw new UsernameNotFoundException("No user present with username: " + s);
        }
        LOGGER.warn(" user from username " + user.toString());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    public UserDO loadMyUserByUsername(String s) {
        UserDO user = userRepository.findByusername(s);
        if (user == null) {
            return null;
        }
        LOGGER.warn(" user from username " + user.toString());
        return user;
    }


    private Set<GrantedAuthority> getAuthorities(UserDO user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (RoleDO role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        LOGGER.warn("user authorities are " + authorities.toString());
        return authorities;
    }

    public void saveUser(UserDO user) {
        user.setPassword(user.getPassword());
        user.setActive(1);
        RoleDO userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<RoleDO>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
