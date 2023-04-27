package com.ar.repositorios;

import com.ar.entidades.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u from User u WHERE u.name = :name")
    public Usuario findByname(@Param("name") String name);

    @Query("SELECT u from User u WHERE u.email = :email")
    public Usuario findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Paciente p WHERE p.id = :id")
    public Usuario findById(@Param("id") Long id);
}
