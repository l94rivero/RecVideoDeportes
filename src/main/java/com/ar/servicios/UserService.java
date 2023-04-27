package com.ar.servicios;

import com.ar.Exception.MiException;
import com.ar.dao.UsuarioDAO;
import com.ar.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Service
public class UserService implements UserDetailsService {


    private void validarDatos(String nombre, String apellido, Integer dni, String email, Integer telefono,
            String contrasenia, String contrasenia2, Integer saldo) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede estar vacio ni ser nulo");
        } else if (nombre.length() < 3) {
            throw new MiException("El nombre no puede tener menos de 3 letras");
        }

        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido no puede estar vacio ni ser nulo");
        } else if (apellido.length() < 3) {
            throw new MiException("El apellido no puede tener menos de 3 letras");
        }

        if (dni.toString().isEmpty() || dni == null || dni < 10000000 || dni > 100000000) {
            throw new MiException("Ingrese un número de dni válido");
        }

        if (email.isEmpty() || email == null) {
            throw new MiException("El email no puede estar vacio ni ser nulo");
        }

        if (telefono.toString().isEmpty() || telefono == null || telefono < 1000000000) {
            throw new MiException("Ingrese un número de teléfono válido");
        }

        if (contrasenia.isEmpty() || contrasenia == null || contrasenia.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!contrasenia.equals(contrasenia2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

        if (saldo.toString().isEmpty() || saldo == null) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

  
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        Usuario usuario = usuarioDao.findByName(email);
        
        if (usuario != null) {
            
            List<GrantedAuthority> permisos = new ArrayList();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+ usuario.getRol());
            
            permisos.add(p);
   
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
            
            return new User(usuario.getEmail(), usuario.getContrasenia(),permisos);
        }else{
            return null;
        }

    }
}
