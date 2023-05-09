package com.rec.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rec.demo.exceptions.MiExcepcion;
import com.rec.demo.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    
    private UserService userService;
    
    @Autowired
    public void UserService(UserService userService){
        this.userService=userService;
    }  
    
    @GetMapping("/registrar")  //localhost:8080/user/registrar
    public String registrar() {
        return "registration.html";
    }

    @GetMapping("/error")
    public String error(){
        return "error404.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String username,
                            @RequestParam String password, 
                            ModelMap modelo) throws MiExcepcion{
        // try {
            System.out.print("\n datos de usuario enviados desde el controller\n");

            //  Usuario u = new Usuario();
            // u.setName(username);
            // u.setPassword(password);
            // System.out.print("\n CreateUser:"+u.getName()+ "//" + u.getPassword() +"\n");
            
            userService.createUser(username, password);
            modelo.put("exito", "fue registrad@ exitosamente");

        return "index.html";
    }
}
