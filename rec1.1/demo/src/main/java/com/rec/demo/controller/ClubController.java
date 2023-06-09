
package com.rec.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.demo.entity.Club;
import com.rec.demo.services.ClubService;

@RestController
@RequestMapping("/buscador")
public class ClubController {

    private ClubService searchService;

    @Autowired
    public void SearchService (ClubService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/clubes")
    public String mostrarClubes(Model model) {
        List<Club> clubes = searchService.listarClubs();
        model.addAttribute("clubes", clubes);
        return "clubes";
    }
}