package com.rec.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rec.entity.Usuario;
import com.rec.exceptions.MiExcepcion;
import com.rec.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
	@Transactional()    
    public List<Usuario> listarObrasSociales(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = (List<Usuario>) userRepository.findAll();
        return usuarios;
    }

    @Transactional
    public Usuario createUser(String username, String password) throws MiExcepcion {
        if (userRepository.existsByUsername(username)) {
            throw new MiExcepcion("Username already exists");
        }

        Usuario user = new Usuario();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }


        public Usuario saveUser(Usuario user) throws MiExcepcion {
            if (userRepository.existsByUsername(user.getPassword())) {
                throw new MiExcepcion("User with username '" + user.getName() + "' already exists");
            }
            return userRepository.save(user);
        }
    }

