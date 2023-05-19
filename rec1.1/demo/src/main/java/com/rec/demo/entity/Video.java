package com.rec.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "idclub")
    private Long id;

    private String nombre;

    // @ManyToMany
    // @Column(name = "idusuario")
    // private Usuario usuario;

    // @ManyToOne
    // @Column(name = "idcancha")
    // private Cancha cancha;
}
