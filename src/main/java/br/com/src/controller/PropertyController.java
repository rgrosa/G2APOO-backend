package br.com.src.controller;


import br.com.src.dto.PropertyDTO;
import br.com.src.resource.ResponseResource;
import br.com.src.service.PropertyService;
import br.com.src.util.auth.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/property")
    public ResponseEntity<ResponseResource> getPropertyList(
            @RequestParam(required = false) Long propertyId,
            @RequestParam List<Long> propertyIdList,
            @RequestParam(required = false) Double priceMin,
            @RequestParam(required = false) Double priceMax
    ) throws Exception {
        return ResponseEntity.ok().body(propertyService.getPropertyList(propertyId, propertyIdList, priceMin, priceMax));
    }

    @CrossOrigin
    @PostMapping("/property")
    public ResponseEntity<ResponseResource> postProperty(@RequestBody @Valid PropertyDTO propertyDTO, Principal user) throws Exception {
        return ResponseEntity.ok().body(propertyService.saveProperty(propertyDTO, JwtTokenUtil.getIdFromCurrentUser(user)));
    }
}
