package br.com.src.controller;


import br.com.src.dto.UpdateUserDTO;
import br.com.src.dto.UserDTO;
import br.com.src.resource.ResponseResource;
import br.com.src.service.UserService;
import br.com.src.util.auth.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseResource> postUser(
            @RequestBody UserDTO userDto) throws Exception {
        return ResponseEntity.ok().
                body(userService.postUser(userDto));
    }

    @PostMapping("/user-update")
    public ResponseEntity<ResponseResource> putUser(
            @RequestBody UpdateUserDTO updateUserDTO) throws Exception {
        return ResponseEntity.ok().
                body(userService.putUser(updateUserDTO));
    }

    @GetMapping("/user")
    public ResponseEntity<ResponseResource> getUser(
            Principal user) throws Exception {
        return ResponseEntity.ok().
                body(userService.getUser(JwtTokenUtil.getIdFromCurrentUser(user)));
    }
}
