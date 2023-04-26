package com.ar.servicios;

import javax.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ar.Exception.MiException;
import com.ar.entidades.User;
import com.ar.entidades.Video;
import com.ar.repositorios.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

    // Inject an instance of a class
    @Autowired
    private UserRepository userRepository;
    
    private User usuario;

    // Method to create a new User
    @Transactional
    public User createUser(String nombre, String apellido, Integer dni, String email, Integer telefono,
            String contrasenia, String contrasenia2, Integer saldo) throws MiException {

        validarDatos(nombre, apellido, dni, email, telefono, contrasenia, contrasenia2, saldo);

        User user = new User();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setDni(contrasenia2);
        user.setEmail(email);
        user.setContrasenia(new BCryptPasswordEncoder().encode(contrasenia));
        // modificar desde acreditacion del dinero
        user.setSaldo(saldo);

        userRepository.save(user);
        return user;
    }

    // Method to list All Users
    public List<User> findAllUsers() throws MiException {
        if (usuario.getRol().equals("ADMIN")) {
            return userRepository.findAll();
        } else {
            throw new MiException("No posee permisos para listar todos los usuarios");
        }
    }

    // Method to fetch a user by their ID
    public User findUserById(Long id) throws MiException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new MiException("el id fallo");
        } else {
            return user;
        }
    }

    // Method to fetch by username
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByname(name);
        if (user == null) {
            throw new UsernameNotFoundException("el nombre ha fallado");
        } else {

            return (UserDetails) user;
        }
    }

    // Method to Refresh Users
    public User updateUserById(Long id, User userUpdated) {

        User user = userRepository.findById(id);

        // Actualizar las propiedades del User con los valores del User Updated
        user.setNombre(userUpdated.getNombre());
        user.setApellido(userUpdated.getApellido());
        user.setEmail(userUpdated.getEmail());
        user.setTelefono(userUpdated.getTelefono());
        user.setContrasenia(userUpdated.getContrasenia());
        user.setSaldo(userUpdated.getSaldo());
        user.setVideos(userUpdated.getVideos());
        user.setDescargas(userUpdated.getDescargas());

        // Guardar los cambios en la base de datos
        return userRepository.save(user);
    }

    // Method to delete Users by id
    public void deleteUser(Long id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
    }

    // Method to fetch user by their mail
    /*
     * public User login(String email, String password) {
     * // Buscar al User por email
     * User user = userRepository.findByEmail(email);
     * 
     * if (user == null) {
     * // User no encontrado
     * return null;
     * }
     * 
     * // Verificar la contraseña
     * if (email.equals(user.getEmail()) && password.equals(user.getContrasenia()))
     * {
     * // Contraseña correcta
     * return user;
     * } else {
     * // Contraseña incorrecta
     * return null;
     * }
     * }
     */
    // Acción: Actualizar saldo
    /*
     * public User updateSaldoById(Long id, Integer saldo) {
     * User user = userRepository.findById(id);
     * user.setSaldo(saldo);
     * return userRepository.save(user);
     * }
    
     // LogOut ?
     */
 /*
     * public void logout() {
     * // Obtener la autenticación actual
     * Authentication authentication =
     * SecurityContextHolder.getContext().getAuthentication();
     * 
     * // Invalidar la sesión actual
     * SecurityContextHolder.getContext().setAuthentication(null);
     * SecurityContextHolder.clearContext();
     * 
     * // Opcionalmente, puedes invalidar la sesión HTTP
     * HttpSession session = request.getSession(false);
     * if (session != null) {
     * session.invalidate();
     * }
     * }
     * 
     */
    // Acción: Elegir horario de descarga
    /*
     * public void elegirHorarioDescarga(String horario) {
     * horarioDescarga = horario;
     * // Código to actualizar el horario de descarga en la base de datos u otra
     * fuente
     * // de datos
     * }
     */
    // Acción: Descargar video
    /*
     * 
     * 
     * public void descargarVideo(Video video) {
     * // Lógica to verificar si el User tiene suficiente saldo disponible y el
     * horario
     * // de descarga es válido
     * if (saldoDisponible.compareTo(video.getPrecio()) >= 0 &&
     * horarioDescargaValido()) {
     * // Código to descargar el video
     * // Por ejemplo, puedes actualizar la lista de videos descargados y descontar
     * el
     * // saldo del User
     * } else {
     * // Código to manejar casos en los que el User no cumple con los requisitos to
     * // descargar el video
     * }
     * }
     */
    // Acción: Ver lista de videos descargados
    public List<Video> verListaVideosDescargados() {
        // Código to list la lista de videos descargados del User
        // Por ejemplo, puedes listla de la base de datos u otra fuente de datos
        // y devolverla como una lista de objetos de la clase Video
        return null;
    }

    // Otros Methods auxiliares
    private boolean horarioDescargaValido() {
        // Lógica to verificar si el horario de descarga es válido
        // Por ejemplo, puedes comtor la hora actual con el horario de descarga
        // seleccionado
        return true;
    }

    private void validarDatos(String nombre, String apellido, Integer dni, String email, Integer telefono,
            String contrasenia, String contrasenia2, Integer saldo) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede estar vacio ni ser nulo");
        } else if (nombre.length() < 3) {
            throw new MiException("El nombre no puede tener menos de 3 letras");
        }

        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido no puede estar vacio ni ser nulo");
        } else if (apellido.length() < 3) {
            throw new MiException("El apellido no puede tener menos de 3 letras");
        }

        if (dni.toString().isEmpty() || dni == null || dni < 10000000 || dni > 100000000) {
            throw new MiException("Ingrese un número de dni válido");
        }

        if (email.isEmpty() || email == null) {
            throw new MiException("El email no puede estar vacio ni ser nulo");
        }

        if (telefono.toString().isEmpty() || telefono == null || telefono < 1000000000) {
            throw new MiException("Ingrese un número de teléfono válido");
        }

        if (contrasenia.isEmpty() || contrasenia == null || contrasenia.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!contrasenia.equals(contrasenia2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

        if (saldo.toString().isEmpty() || saldo == null) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

}
