
package com.ar.servicios;

import com.ar.Exception.MiException;
import com.ar.entidades.*;
import com.ar.repositorios.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideoService {
    
    @Autowired(required=false)
    private VideoRepository videoRepository;

    @Autowired(required=false)
    private UserRepository userRepository;
        
    // Method to create a new video
    @Transactional
    public Video createVideo (String title, String description, Date hora, String url, Usuario usuario, Descargas descarga) throws MiException {
        Video video = new Video();
        validarDatos(title, description, hora, url, usuario, descarga) ;
        video.setTitle(title);
        video.setDescription(description);
        video.setHora(hora);
        video.setUrl(url);
        video.setUsuario(usuario);
        video.setDescarga(descarga);
        return videoRepository.save(video);
    }
    

    // Method to list All videos
    public List<Video> findAllVideos() {
            return videoRepository.findAll();
    }
    

    // Method to Update Videos
    public Video updateVideoByDate(String date, Video videoUpdated) {

        Video video = videoRepository.findByDate(date);

        // Actualizar las propiedades del video con los valores del video Updated
        video.setTitle(videoUpdated.getTitle());
        video.setDescription(videoUpdated.getDescription());

        // Guardar los cambios en la base de datos
        return videoRepository.save(video);
    }
    
    public Video buscarVideoEnHorario(String date, Long usuarioId) {
        Video video = videoRepository.findByDate(date); // Buscar el video en la base de datos por horario
        if (video != null) { 
            Usuario usuario = userRepository.findById(usuarioId); // Buscar el usuario por su ID
            if (usuario != null && usuario.getSaldo() > 0) { // Verificar si el saldo del usuario es positivo
                video.setDisponible(true); // Habilitar la opción de descarga
            } else {
                video.setDisponible(false); // Deshabilitar la opción de descarga
            }
            return video; // Devolver el video con la opción de descarga actualizada
        } else {
            return null; // Si no se encuentra el video, devolver nulo
        }
    }

    private void validarDatos(String title, String description, Date hora, String url, Usuario usuario, Descargas descarga) throws MiException{

        // Validación del título
        if (title == null || title.isEmpty()) {
            throw new MiException("El nombre no puede estar vacio ni ser nulo");
        } else if (title.length() > 100) {
            throw new MiException("El título no puede tener más de 100 caracteres");
        }

        // Validación de la descripción
        if (description == null || description.isEmpty()) {
             throw new MiException("La descripción no puede estar vacía");
        } else if (description.length() > 500) {
             throw new MiException("La descripción no puede tener más de 500 caracteres");
        }

        // Validación de la hora
        if (hora == null) {
             throw new MiException("La hora no puede estar vacía");
        }

        // Validación de la URL
        if (url == null || url.isEmpty() || !url.matches("^https?://.+\\..+$")) {
             throw new MiException("La URL debe tener un formato válido");
        }

        // Validación del usuario
        if (usuario == null ) {
             throw new MiException("El usuario no puede estar vacío");
        } else if (usuario.toString().length() > 50) {
             throw new MiException("El usuario no puede tener más de 50 caracteres");
        }

        // Validación de la descarga
        if (descarga == null || descarga.toString().isEmpty() || !descarga.toString().matches("^https?://.+\\..+$")) {
             throw new MiException("La descarga debe tener un formato válido");
        }
    }


}

