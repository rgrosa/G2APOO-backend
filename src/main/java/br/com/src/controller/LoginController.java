package br.com.src.controller;


import br.com.src.dto.UserLoginDTO;
import br.com.src.resource.ResponseResource;
import br.com.src.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseResource> postLogin(
            @RequestBody UserLoginDTO userLoginDto) throws Exception {
        return ResponseEntity.ok().
                body(loginService.postLogin(userLoginDto));
    }
}
