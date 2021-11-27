package br.com.src.service.impl;

import br.com.src.dto.UpdateUserDTO;
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

import java.util.Objects;
import java.util.Optional;

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
        userEntity.setEmailContact(userDto.getEmailContact());
        userRepository.save(userEntity);
        return new ResponseResource(200,"Success", userEntity);
    }

    @Override
    public ResponseResource putUser(UpdateUserDTO updateUserDTO) throws PasswordException {
        Optional<UserEntity> OptionalUserEntity = userRepository.findOneByUserId(Long.parseLong(updateUserDTO.getUserId()));
        if(!OptionalUserEntity.isPresent()){
            return new ResponseResource(404,"Not found",null);
        }
        UserEntity userEntity = OptionalUserEntity.get();

        if(!Objects.equals(cryptPassword.encode(updateUserDTO.getCurrentUserPassword()), userEntity.getUserPassword())){
            return new ResponseResource(400,"Bad request",null);
        }

        userEntity.setUserPassword(cryptPassword.encode(updateUserDTO.getUserPassword()));
        userEntity.setUserRealName(updateUserDTO.getUserRealName());
        userEntity.setUsername(updateUserDTO.getUsername());
        userEntity.setEmailContact(updateUserDTO.getContactEmail());
        userRepository.save(userEntity);
        return new ResponseResource(200,"Success", userEntity);
    }

    @Override
    public ResponseResource getUser(Long userId) throws PasswordException {
        Optional<UserEntity> userEntity = userRepository.findOneByUserId(userId);
        if(!userEntity.isPresent()){
            new ResponseResource(404,"Not found",null);
        }
        return new ResponseResource(200,"Success", userEntity.get());
    }
}
