package com.rec.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @PostMapping("")
    public ResponseEntity<?> authenticateUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("logincontroller activo!");
        try {
            // Validar si se proporcionaron valores nulos o vacíos
            System.out.println("logincontroller activo!");

            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {

                return new ResponseEntity<>("Nombre de usuario y contraseña requeridos", HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok("Autenticación exitosa");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @GetMapping("")
    public String login() {
        return "login.html";
    }
}
