package com.ar.controladores;

import com.ar.Exception.MiException;
import com.ar.dao.UsuarioDAO;
import com.ar.entidades.Usuario;
import com.ar.enums.Rol;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    private final UsuarioDAO userDao;

    public PortalControlador() {
        this.userDao = null;
        System.out.println("Portal COntrolador");
    }

    public PortalControlador(UsuarioDAO userDao) {
        this.userDao = userDao;
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/")
    public String inicio(HttpSession session) {
        System.out.println("Portal COntrolador");

        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        if (logueado.getRol().equals(Rol.ADMIN.toString())) {
            return "redirect:/admin/dashboard";
        }
        return "index.html";
    }
    
    @GetMapping("/error")
    public String error(){
        return "error.html";
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo ) {

        if (error != null) {
            modelo.put("error", "Usuario o Contraseña invalidos!");
        }

        return "login.html";
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

}
