package com.example.backendbouchon.controller;

import com.example.backendbouchon.configuration.AuthentificationConfJWT.JwtUtils;
import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.domaine.dto.TokenTO;
import com.example.backendbouchon.domaine.dto.UserTO;
import com.example.backendbouchon.model.payload.request.LoginRequest;
import com.example.backendbouchon.service.exception.BusinessException;
import com.example.backendbouchon.service.repository.signature.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private IUserService userService;
    private JwtUtils jwtUtils;

    public AuthenticationController(AuthenticationManager authenticationManager, IUserService userService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenTO> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {

            Authentication authentication = authenticationManager
                    .authenticate(new
                            UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            TokenTO tokenVo = new TokenTO();
            tokenVo.setJwttoken(jwt);
            tokenVo.setUsername(loginRequest.getUsername());
            Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
            list.forEach(authorite -> tokenVo.getRoles().add(authorite.getAuthority()));
            return ResponseEntity.ok(tokenVo);
        } catch (Exception e) {
              throw new BusinessException("Login ou mot de passe incorrect");
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserTO userTO) {
        if (userService.isUserExistsByUserName(userTO.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        // par défaut, le client a le rôle CLIENT
        userTO.getRoles().add(new RoleTO("CLIENT"));
        userService.saveUser(userTO);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping( "/acces_denied")
    public ResponseEntity<String> acces_denied() {
        return ResponseEntity.badRequest().body("acces_denied");
    }

}
