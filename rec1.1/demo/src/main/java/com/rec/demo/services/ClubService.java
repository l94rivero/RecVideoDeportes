package com.rec.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rec.demo.entity.Cancha;
import com.rec.demo.entity.Club;
import com.rec.demo.exceptions.MiExcepcion;
import com.rec.demo.repository.ClubRepository;

import lombok.Data;

@Service
@Data
public class ClubService {

    public ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Transactional
    public List<Club> listarClubs() {
        List<Club> clubs = new ArrayList<>();
        clubs = (List<Club>) clubRepository.findAll();
        return clubs;
    }

    @Transactional
    public void createClub(String name, List<Cancha> canchas) throws MiExcepcion {

        System.out.print("\npersistiendo club desde servicio\n");

        Club club = new Club();

        club.setName(name);
        //club.setCanchas(canchas);
        
        clubRepository.save(club);
    }
}