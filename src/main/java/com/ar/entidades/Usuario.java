package com.ar.entidades;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String contrasenia;
    private String contrasenia2;
    private Integer saldo;
    private String rol;
    
    @OneToMany(mappedBy = "usuario")
    private List<Video> videos;

    @OneToMany(mappedBy = "usuario")
    private List<Descargas> descargas;
    
    
    /*
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private final Set<String> roles = new HashSet<>();
    
     */
    
}
