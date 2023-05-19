package com.rec.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rec.demo.entity.Usuario;
import com.rec.demo.repository.UserRepository;

@Controller
@RequestMapping("/")
public class PortalController {

  private UserRepository userRepository;

  @Autowired
  public void userRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("all")
  public @ResponseBody Iterable<Usuario> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

  @GetMapping("error")
  public String error() {
    return "error404.html";
  }
  
  @GetMapping("contacto")
  public String contact() {
    return "contacto.html";
  }

  @GetMapping("ayuda")
    public String help(){
      return "ayuda.html";
    }


  
  @GetMapping("precios")
  public String pricing(){
    return "precios.html";
  }

  // @GetMapping("?club=parque")
  // public @ResponseBody Iterable<Club> clubes() {
  //   return clubRepository.findAll();
  // }

  // @GetMapping("{id}")
  // public Optional<Usuario> getUserById(@PathVariable int id) {
  // return userRepository.findById(id);
  // }

}