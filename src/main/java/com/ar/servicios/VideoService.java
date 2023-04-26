
package com.ar.servicios;

import com.ar.entidades.User;
import com.ar.entidades.Video;
import com.ar.repositorios.UserRepository;
import com.ar.repositorios.VideoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;
        
    // Method to create a new video
    public Video createVideo (Video video) {
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
            User usuario = userRepository.findById(usuarioId); // Buscar el usuario por su ID
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
}
