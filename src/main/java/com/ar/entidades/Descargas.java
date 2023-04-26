/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Descargas implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User usuario;

    @Temporal(TemporalType.DATE)
    private Date alta;

    @ManyToOne
    private Video video;
}
