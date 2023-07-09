package com.kartik.securityjwtservice.controller;


import com.kartik.securityjwtservice.model.Authentication;
import com.kartik.securityjwtservice.model.AuthenticationResponse;
import com.kartik.securityjwtservice.model.Register;
import com.kartik.securityjwtservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Register register)
    {
    return ResponseEntity.ok(authenticationService.register(register));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Authentication authentication)
    {
        return ResponseEntity.ok(authenticationService.authenticate(authentication));

    }
}
