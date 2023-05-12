package com.rec.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "idclub")
    private Long id;

    private String nombre;

    private Date fecha;

    private Date hora;

    //private Video video;
}
