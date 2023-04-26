package com.ar.repositorios;

import com.ar.entidades.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u WHERE u.name = :name")
    public User findByname(@Param("name") String name);

    @Query("SELECT u from User u WHERE u.email = :email")
    public User findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Paciente p WHERE p.id = :id")
    public User findById(@Param("id") Long id);
}
