package br.com.src.service.impl;

import br.com.src.dto.UserDTO;
import br.com.src.entity.UserEntity;
import br.com.src.exception.PasswordException;
import br.com.src.repository.UserRepository;
import br.com.src.resource.ResponseResource;
import br.com.src.service.UserService;
import br.com.src.util.auth.CryptPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    CryptPassword cryptPassword;

    @Override
    public ResponseResource postUser(UserDTO userDto) throws PasswordException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setUserRealName(userDto.getUserRealName());
        userEntity.setUserPassword(cryptPassword.encode(userDto.getUserPassword()));
        userEntity.setUserStatus(true);
        userEntity.setUserTypeId(userDto.getUserTypeId());
        userRepository.save(userEntity);
        return new ResponseResource(200,"Sucess", userEntity);
    }
}
