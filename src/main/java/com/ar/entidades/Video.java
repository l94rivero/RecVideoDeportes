package com.ar.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
public class Video implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Date hora;
    private String description;
    private String url;
    private Integer num_descargas;
    private boolean disponible;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "video")
    private Descargas descarga;

}
