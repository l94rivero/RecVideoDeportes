package com.rec.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rec.demo.enums.Rol;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "idusuario")
  private Long id;

  private String username;

  private String email;

  private String password;

  @Enumerated(EnumType.STRING)
  private Rol rol;

  // @OneToMany
  // @Column(name = "idcompra")
  // private Compra compra;

  // @ManyToMany
  // @Column(name = "idvideo")
  // private Video video;

}
