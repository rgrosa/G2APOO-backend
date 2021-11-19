package br.com.src.controller;


import br.com.src.dto.UserDTO;
import br.com.src.resource.ResponseResource;
import br.com.src.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
