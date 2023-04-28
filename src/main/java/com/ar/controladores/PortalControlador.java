package com.ar.controladores;

import com.ar.dao.UsuarioDao;
import com.ar.entidades.Usuario;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class PortalControlador {

    @Autowired
    private UsuarioDao usuarioDao;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = usuarioDao.findAll();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        return "index";
    }

    /*
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/error")
    public String error() {
        return "/error";
    }

    @GetMapping("/login")
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        modelo.addAttribute(new Usuario());
        return "login";
    }
*/
}
