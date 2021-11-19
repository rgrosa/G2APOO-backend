package br.com.src.config.security;

import br.com.src.exception.ResourceNotFoundException;
import br.com.src.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginService userLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;

        try {
            userDetails = userLoginService.loadUserByUsername(username);

        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }

        return userDetails;
    }
}
