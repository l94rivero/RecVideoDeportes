package com.rec.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rec.demo.entity.Usuario;
import com.rec.demo.exceptions.MiExcepcion;
import com.rec.demo.repository.UserRepository;

import lombok.Data;

@Service
@Data
public class UserService  {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<Usuario> listarObrasSociales() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = (List<Usuario>) userRepository.findAll();
        return usuarios;
    }

    @Transactional
    public void createUser(String username, String password) throws MiExcepcion {

        System.out.print("\npersistiendo usuario desde servicio\n");

        Usuario user = new Usuario();

        user.setUsername(username);
        // user.setPassword(password);
        user.setPassword(new BCryptPasswordEncoder().encode(password));

        userRepository.save(user);
    }
/*
 
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("\n String loadUserByUsername ="+username+"\n");

    Usuario usuario = userRepository.findByUsername(username);
    System.out.println("\n Usuario findByUsername = "+usuario+"\n");
    

    if (usuario != null) {
        
        List<GrantedAuthority> permisos = new ArrayList<>();
        
        GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+ "ADMIN"); //todo: ENUM 
        
        permisos.add(p);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        
        HttpSession session = attr.getRequest().getSession(true);
        
        session.setAttribute("usuariosession", usuario);
        
        return new User(usuario.getUsername(), usuario.getPassword(),permisos);
    
    // Usuario usuario = new Usuario();
    // System.out.println("\n"+username+"\n");
    // if (userRepository.existsByUsername(username)) {
    //     return User.builder()
    //             .username(usuario.getUsername())
    //             .password(usuario.getPassword())
    //             .roles(usuario.getRol())
    //             .build();
    } else throw new UsernameNotFoundException("Usuario no encontrado");
}

 */
}
