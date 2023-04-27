package com.ar.controladores;

import com.ar.servicios.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ar.entidades.Video;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public String obtenerVideos(Model model) {
        List<Video> videos = videoService.findAllVideos();
        model.addAttribute("videos", videos);
        return "descarga.html";
    }
    
    /*@PostMapping("/descarga")
    public String procesarFormulario(Model model) {
        model.addAttribute("descarga", Descarga )
        descargaRepository.save(descarga);
        return "redirect:/";
    }*/
}