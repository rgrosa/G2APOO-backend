package br.com.src.service;


import br.com.src.dto.UpdateUserDTO;
import br.com.src.dto.UserDTO;
import br.com.src.exception.PasswordException;
import br.com.src.resource.ResponseResource;

public interface UserService {

    ResponseResource postUser(UserDTO userDto, Long userId) throws PasswordException;

    ResponseResource putUser(UpdateUserDTO updateUserDTO) throws PasswordException;

    ResponseResource getUser(Long userId) throws PasswordException;

    ResponseResource updateUserStatus(UpdateUserDTO updateUserDTO) throws PasswordException;
}
