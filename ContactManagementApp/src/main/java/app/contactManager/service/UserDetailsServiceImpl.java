package app.contactManager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.contactManager.entity.User;

//UserDetailsServiceImpl.java
@Service("userDetailsServiceImpl")
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
 
	 private final UserService userService;
	 private final PasswordEncoder passwordEncoder;
	 
	 @Autowired
	    public UserDetailsServiceImpl(@Qualifier("userService")UserService userService, PasswordEncoder passwordEncoder) {
	        this.userService = userService;
	        this.passwordEncoder = passwordEncoder;
	    }



 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user = userService.getUserByUsername(username);
     if (user == null) {
         throw new UsernameNotFoundException("User not found with username: " + username);
     }

     return new org.springframework.security.core.userdetails.User(
         user.getUsername(),
         user.getPassword(),
         getAuthorities(user)
     );
 }

 private Collection<? extends GrantedAuthority> getAuthorities(User user) {
	 // Extract roles and convert them to a list of authorities
     List<GrantedAuthority> authorities = new ArrayList<>();
     String[] rolesArray = user.getRoles().split(",");
     for (String role : rolesArray) {
         authorities.add(new SimpleGrantedAuthority(role));
     }
     return authorities;
 }
}
