package org.sigmaka.gen20javaspringbootpos.service;

import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.sigmaka.gen20javaspringbootpos.dto.LoginDTO;
import org.sigmaka.gen20javaspringbootpos.dto.LoginReponseDTO;
import org.sigmaka.gen20javaspringbootpos.dto.RefreshTokenRequestDTO;
import org.sigmaka.gen20javaspringbootpos.dto.SignupDTO;
import org.sigmaka.gen20javaspringbootpos.entity.RolesEntity;
import org.sigmaka.gen20javaspringbootpos.entity.UsersEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.repository.RolesRepo;
import org.sigmaka.gen20javaspringbootpos.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthService {

    private UsersRepo usersRepo;
    private RolesRepo rolesRepo;
    private JWTUtils jwtUtils;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UsersRepo usersRepo, RolesRepo rolesRepo, JWTUtils jwtUtils, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usersRepo = usersRepo;
        this.rolesRepo = rolesRepo;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Transactional(rollbackOn = Exception.class)
    public GlobalHttpResponse<LoginReponseDTO> signUp(SignupDTO signupDTO){
        try{
            UsersEntity user = signupDTO.dtoToEntity();
            RolesEntity role = rolesRepo.findById(signupDTO.getRoleId()).orElse(null);

            if (role == null){
                return new GlobalHttpResponse<>(404, "Role not Found", new LoginReponseDTO());
            }

            Optional<UsersEntity> userDb = usersRepo.findByEmail(signupDTO.getEmail());
            if (userDb.isPresent()){
                return new GlobalHttpResponse<>(409, "User already exist", new LoginReponseDTO());
            }

            user.setRole(role);
            user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
            UsersEntity create = usersRepo.save(user);
            return new GlobalHttpResponse<>(201, "Successfully Create a User", new LoginReponseDTO());
        }   catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new GlobalHttpResponse<>(500, e.getMessage(), new LoginReponseDTO());
        }
    }

    public GlobalHttpResponse<LoginReponseDTO> login(LoginDTO loginDTO) {
        LoginReponseDTO response;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            UsersEntity user = usersRepo.findByEmail(loginDTO.getEmail()).orElse(null);
            System.out.println("User is: "+user);
            if (user == null){
                return new GlobalHttpResponse<>(404, "User not found", new LoginReponseDTO());
            }

            String token = jwtUtils.generateToken(user);
            String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response = new LoginReponseDTO();
            response.setToken(token);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("3H");
        } catch (Exception e) {
            return new GlobalHttpResponse<>(500, e.getMessage(), new LoginReponseDTO());
        }

        return new GlobalHttpResponse<>(200, "Login Success", response);
    }

    public GlobalHttpResponse<LoginReponseDTO> refreshToken(RefreshTokenRequestDTO refreshTokenRequestDTO){
        LoginReponseDTO response;
        String email = jwtUtils.extractUsername(refreshTokenRequestDTO.getToken());
        UsersEntity user = usersRepo.findByEmail(email).orElse(null);
        if (user == null){
            return new GlobalHttpResponse<>(404, "Users not found", new LoginReponseDTO());
        }

        if (jwtUtils.isTokenValid(refreshTokenRequestDTO.getToken(), user)){
            String token = jwtUtils.generateToken(user);
            response = new LoginReponseDTO();
            response.setToken(token);
            response.setRefreshToken(refreshTokenRequestDTO.getToken());
            response.setExpirationTime("3H");

            return new GlobalHttpResponse<>(200, "Successfully Refreshed Token", response);
        }

        return new GlobalHttpResponse<>(500, "Internal Server Error", new LoginReponseDTO());
    }
}
