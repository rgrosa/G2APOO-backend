package br.com.src.service.impl;

import br.com.src.dto.LoggedUserDTO;
import br.com.src.dto.LoggedUserDetailsDTO;
import br.com.src.dto.UserLoginDTO;
import br.com.src.entity.UserEntity;
import br.com.src.exception.PasswordException;
import br.com.src.exception.ResourceNotFoundException;
import br.com.src.repository.UserRepository;
import br.com.src.resource.ResponseResource;
import br.com.src.service.LoginService;
import br.com.src.util.auth.CryptPassword;
import br.com.src.util.auth.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    CryptPassword cryptPassword;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseResource postLogin(UserLoginDTO userLoginDto) throws PasswordException {
        log.info("postLogin - UserLoginDTO = {}", userLoginDto.toString());
        UserEntity userEntity;
        try {
            userEntity = userRepository.findOneByUsernameAndUserStatus(userLoginDto.getUserName(),true);
            if(!cryptPassword.matches(userLoginDto.getUserSecret(),userEntity.getUserPassword())){
                throw new PasswordException("Invalid credentials");
            }
        } catch (Exception ex) {
            throw new PasswordException(ex.getMessage());
        }
        log.info("postLogin - Success Login for UserLoginDTO = {}", userLoginDto);
        return new ResponseResource(200,"Request success, verify additionalInfo for result", makeResponseDto(userEntity));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException {
        log.info("loadUserByUsername - username = {}", username);
        UserEntity userEntity;
        try {
            userEntity = userRepository.findOneByUsernameAndUserStatus(username,true);
        } catch (Exception ex) {
            throw new ResourceNotFoundException(ex.getMessage());
        }
        log.info("loadUserByUsername - username", username);
        return new LoggedUserDetailsDTO(makeLoggedUser(userEntity));
    }

    private LoggedUserDTO makeResponseDto(UserEntity userEntity) {
        LoggedUserDetailsDTO userDetails = new LoggedUserDetailsDTO(makeLoggedUser(userEntity));
        userDetails.getLoggedUser().setJwtToken(jwtTokenUtil.generateToken(userDetails));
        userDetails.getLoggedUser().setPassword(null); //não vou retornar o password para frontend
        return userDetails.getLoggedUser();
    }

    private static LoggedUserDTO makeLoggedUser(UserEntity userEntity){
        return new LoggedUserDTO(
                userEntity.getUserId(),
                userEntity.getUsername(),
                userEntity.getUserPassword(),
                userEntity.getUserRealName(),
                null,
                userEntity.getUserId().intValue()
        );
    }
}
