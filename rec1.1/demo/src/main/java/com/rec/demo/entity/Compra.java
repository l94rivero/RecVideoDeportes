package com.rec.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
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

    private Integer monto;

    @Temporal(TemporalType.DATE)
    private Date fecha;

}
