package com.rec.demo.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// private AuthenticationManager authenticationManager;

// @Autowired
// public void authenticationManager(AuthenticationManager authenticationManager) {
//     this.authenticationManager = authenticationManager;
// }

@Controller
public class LoginController {

    @PostMapping("/login")
        public ResponseEntity<?> authenticateUser(@RequestParam String username, @RequestParam String password) {
    try{
        // Validar si se proporcionaron valores nulos o vacíos
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return new ResponseEntity<>("Nombre de usuario y contraseña requeridos", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Autenticación exitosa");
    }catch(IllegalArgumentException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }catch(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    }
}
