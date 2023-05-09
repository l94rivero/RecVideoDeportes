package com.rec.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rec.demo.entity.Usuario;
import com.rec.demo.exceptions.MiExcepcion;
import com.rec.demo.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Service
public class UserService {

    
    @Setter
    @Getter
    public UserRepository userRepository;    

    // @Getter
    // @Setter
    // public PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository/*, PasswordEncoder passwordEncoder*/) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
    }

    
    
	@Transactional
    public List<Usuario> listarObrasSociales(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = (List<Usuario>) userRepository.findAll();
        return usuarios;
    }

    @Transactional
    public void createUser(String username, String password) throws MiExcepcion {

        System.out.print("\npersistiendo usuario desde servicio\n");

        Usuario user = new Usuario();

        user.setName(username);
        //user.setPassword(passwordEncoder.encode(password));
        user.setPassword(password);

        System.out.print("\nUSUARIO:"+user.toString()+"\n");

        userRepository.save(user);
    }


        // public Usuario saveUser(Usuario user) throws MiExcepcion {
        //     if (userRepository.existsByUsername(user.getPassword())) {
        //         throw new MiExcepcion("User with username '" + user.getName() + "' already exists");
        //     }
        //     return userRepository.save(user);
        // }
    }

