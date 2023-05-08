package com.rec.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rec.entity.Usuario;
import com.rec.repository.UserRepository;

@RestController
@RequestMapping("/")
public class PortalController {

  @Autowired(required = false) // This means to get the bean called userRepository   // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<Usuario> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Usuario> getUserById(@PathVariable int id) {
    return userRepository.findById(id);
  }
}