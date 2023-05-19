package com.rec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.rec.demo.entity.Club;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public abstract interface CompraRepository extends JpaRepository<Club, String> {
    
    public Club findByName(@Param("nombre")String nombre);

}