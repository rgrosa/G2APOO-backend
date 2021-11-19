package br.com.src.service;

import br.com.src.dto.UserLoginDTO;
import br.com.src.exception.PasswordException;
import br.com.src.exception.ResourceNotFoundException;
import br.com.src.resource.ResponseResource;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {


    ResponseResource postLogin(UserLoginDTO userLoginDto) throws PasswordException;

    UserDetails loadUserByUsername(String username) throws ResourceNotFoundException;
}
