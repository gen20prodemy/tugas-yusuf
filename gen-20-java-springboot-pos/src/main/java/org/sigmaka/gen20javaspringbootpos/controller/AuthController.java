package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.LoginDTO;
import org.sigmaka.gen20javaspringbootpos.dto.LoginReponseDTO;
import org.sigmaka.gen20javaspringbootpos.dto.RefreshTokenRequestDTO;
import org.sigmaka.gen20javaspringbootpos.dto.SignupDTO;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<GlobalHttpResponse<LoginReponseDTO>> signup(@RequestBody SignupDTO signupDTO){
        GlobalHttpResponse<LoginReponseDTO> res = authService.signUp(signupDTO);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }
    @PostMapping("/login")
    public ResponseEntity<GlobalHttpResponse<LoginReponseDTO>> login(@RequestBody LoginDTO loginDTO){
        GlobalHttpResponse<LoginReponseDTO> res = authService.login(loginDTO);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<GlobalHttpResponse<LoginReponseDTO>> refresh(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO){
        GlobalHttpResponse<LoginReponseDTO> res = authService.refreshToken(refreshTokenRequestDTO);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }
}
