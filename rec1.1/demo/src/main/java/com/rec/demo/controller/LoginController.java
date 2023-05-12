package com.rec.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
