package com.ar.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ar.Exception.MiException;
import com.ar.dao.UsuarioDAO;
import com.ar.entidades.Usuario;

@Controller
public class UsuarioController {
    
    private final UsuarioDAO userDao;

    public UsuarioController() {
        this.userDao = null;
    }

    @GetMapping("/usuarios")
    public String listUsers(Model model) throws MiException{
        List<Usuario> usuarios = userDao.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listado_usuarios"; // Nombre de la vista JSP o Thymeleaf
    }
}