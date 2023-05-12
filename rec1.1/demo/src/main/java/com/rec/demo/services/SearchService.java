package com.rec.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rec.demo.entity.Cancha;
import com.rec.demo.entity.Club;
import com.rec.demo.exceptions.MiExcepcion;
import com.rec.demo.repository.SearchRepository;

import lombok.Data;

@Service
@Data
public class SearchService {

    public SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Transactional
    public List<Club> listarClubs() {
        List<Club> clubs = new ArrayList<>();
        clubs = (List<Club>) searchRepository.findAll();
        return clubs;
    }

    @Transactional
    public void createClub(String name, List<Cancha> canchas) throws MiExcepcion {

        System.out.print("\npersistiendo club desde servicio\n");

        Club club = new Club();

        club.setName(name);
        //club.setCanchas(canchas);
        
        searchRepository.save(club);
    }
}