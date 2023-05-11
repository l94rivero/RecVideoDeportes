package com.rec.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rec.demo.entity.Compra;
import com.rec.demo.exceptions.MiExcepcion;

@Controller
public class PayController {

    /*
     * private UserService userService;
     * 
     * @Autowired
     * public void UserService(UserService userService){
     * this.userService=userService;
     * }
     */

    @GetMapping("/pago")
    public String paginaPago() {
        return "pago.html";
    }

    @PostMapping("/pago")
    public String procesarPago(@RequestParam Compra compra, ModelMap modelo) throws MiExcepcion {
        System.out.print("\n datos de usuario enviados desde el controller PAY\n");
        // userService.createCompra(compra);
        modelo.put("exito", "su compra@ fue un exito");
        return "redirect:/index.html";
    }
}
