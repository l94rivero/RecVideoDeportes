package com.rec.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity // This tells Hibernate to make a table out of this class
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "idcompra")
    private Long id;

    // @Getter
    // @Setter
    // @OneToMany
    // @Column(name = "idusuario")
    // private Usuario usuario;

    @Getter
    @Setter
    private Integer monto;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date fecha;

}
