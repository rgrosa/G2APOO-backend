package br.com.src.controller;


import br.com.src.dto.AlertDTO;
import br.com.src.resource.ResponseResource;
import br.com.src.service.AlertService;
import br.com.src.util.auth.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AlertController {

    @Autowired
    AlertService alertService;

    @PostMapping("/alert")
    public ResponseEntity<ResponseResource> postAlert(
            @RequestBody AlertDTO alertDTO,
            Principal user) throws Exception {
        return ResponseEntity.ok().
                body(alertService.postAlert(alertDTO, JwtTokenUtil.getIdFromCurrentUser(user)));
    }

    @PostMapping("/alert/hide")
    public ResponseEntity<ResponseResource> hideAlert(@RequestBody AlertDTO alertDTO) throws Exception {
        return ResponseEntity.ok().body(alertService.hideAlert(alertDTO));

    }

    @GetMapping("/alert")
    public ResponseEntity<ResponseResource> getAlerts(@RequestParam List<Long> alertTypeList) throws Exception {
        return ResponseEntity.ok().
                body(alertService.getAlerts(alertTypeList));
    }
}
