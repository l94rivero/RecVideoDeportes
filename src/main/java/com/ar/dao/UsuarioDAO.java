/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.dao;

import com.ar.entidades.Usuario;
import com.ar.repositorios.UserRepository;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO implements UserDetailsService{

    private final UserRepository userRepository;

    public UsuarioDAO() {
        this.userRepository = null;
    }

    public UsuarioDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    public Usuario findById(Long id) {
        return userRepository.findById(id);
    }

    public Usuario findByName(String name) {
        return userRepository.findByname(name);
    }


    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    public void delete(Usuario user) {
        userRepository.delete(user);
    }
    
    public List<Usuario> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

