package br.com.src.service;


import br.com.src.dto.UserDTO;
import br.com.src.exception.PasswordException;
import br.com.src.resource.ResponseResource;

public interface UserService {

    ResponseResource postUser(UserDTO userDto) throws PasswordException;
}
