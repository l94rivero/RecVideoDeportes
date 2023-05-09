package com.rec.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity // This tells Hibernate to make a table out of this class
public class Usuario {

  @Id
  @Getter
  @Setter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idusuario")
  private Integer id;

  @Getter
  @Setter
  private String name;
  
  @Getter
  @Setter
  private String email;

  @Getter
  @Setter
  private String password;
}

