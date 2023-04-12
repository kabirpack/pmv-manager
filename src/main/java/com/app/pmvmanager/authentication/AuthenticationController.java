package com.app.pmvmanager.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws NoSuchAlgorithmException {
        return new ResponseEntity<>(authenticationService.authenticate(authenticationRequestDto), HttpStatus.OK);
    }

    @GetMapping("/getDriverIds")
        public int[] getDriverIds() {
            return authenticationService.getDriverIdList();
        }

}
