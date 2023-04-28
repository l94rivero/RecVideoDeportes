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
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
    
    @OneToMany(mappedBy = "id_video")
    private List<Video> videos;

    @OneToMany(mappedBy = "id_descarga")
    private List<Descargas> descargas;
    
    
    /*
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private final Set<String> roles = new HashSet<>();
    
     */

    public String getRol() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
