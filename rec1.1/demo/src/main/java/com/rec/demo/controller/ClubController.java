
package com.rec.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rec.demo.entity.Club;
import com.rec.demo.repository.ClubRepository;
import com.rec.demo.services.ClubService;

@Controller
@RequestMapping("/club")
public class ClubController {

    private ClubRepository searchRepository;

    @Autowired
    public void searchRepository (ClubRepository searchRepository){
      this.searchRepository = searchRepository;
    }

    @GetMapping("/seleccion")
    public String clubes (Model model){
      return "clubes.html";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Club> getAllClubes(Model model) {
        List<Club> clubes = searchRepository.findAll();
        model.addAttribute("clubes", clubes);
        return clubes;
    }
    

}