package com.ar.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ar.Exception.MiException;
import com.ar.entidades.User;
import com.ar.servicios.UserService;

@Controller
public class UsuarioController {
    @Autowired
    private UserService userService;

    @GetMapping("/usuarios")
    public String listUsers(Model model) throws MiException{
        List<User> usuarios = userService.findAllUsers() ;
        model.addAttribute("usuarios", usuarios);
        return "usuarios"; // Nombre de la vista JSP o Thymeleaf
    }
}