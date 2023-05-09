package com.rec.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rec.demo.entity.Usuario;
import com.rec.demo.repository.UserRepository;

@RestController
@RequestMapping("/")
public class PortalController {
  
  private UserRepository userRepository;
  
  @Autowired
  public void userRepository(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<Usuario> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

  @GetMapping("/error")
  public String error(){
      return "error404.html";
  }

  @GetMapping("/blog")
  public String blog(){
      return "blog.html";
  }

  @GetMapping("/{id}")
  public Optional<Usuario> getUserById(@PathVariable int id) {
    return userRepository.findById(id);
  }
}