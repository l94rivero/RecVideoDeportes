package com.rec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.rec.demo.entity.Usuario;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public abstract interface UserRepository extends JpaRepository<Usuario, Integer> {
    
    
    public Usuario findByUsername(@Param("username")String username);

    // @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario findByEmail(@Param("email")String email);}