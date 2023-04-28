package com.ar.controladores;

import com.ar.dao.UsuarioDao;
import com.ar.entidades.Usuario;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UsuarioController {
    
    @Autowired
    private UsuarioDao usuarioDao;



    @GetMapping("/agregar")
    public String agregar(Usuario persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        usuarioDao.save(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Usuario persona, Model model) {
        persona = usuarioDao.findByName(persona.getNombre());
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Usuario persona) {
        usuarioDao.delete(persona);
        return "redirect:/";
    }
    /*
    
    public UsuarioController() {
        this.userDao = null;
    }

    @GetMapping("/listar")
    public String listUsers(Model model) throws MiException{
        List<Usuario> usuarios = userDao.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listado_usuarios"; // Nombre de la vista JSP o Thymeleaf
    }
    
    @GetMapping("/registrar")
    public String registrar() {
        System.out.println("registrando con exito");
        return "registro_usuario";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String dni, 
           @RequestParam String email, @RequestParam String telefono,
           @RequestParam String password, @RequestParam String password2, @RequestParam Integer saldo, ModelMap modelo) throws MiException {
        
        Usuario user = new Usuario();
        
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setDni(dni);
        user.setEmail(email);
        user.setTelefono(telefono);
        user.setContrasenia(password);
        user.setContrasenia2(password2);
        
        userDao.save(user);
        System.out.println("Persistiendo usuario desde /registro");
        modelo.put("exito", "Usuario registrado correctamente!");
        
        return "index.html";

    }
     */
}
