package com.rec.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.rec.demo.entity.Usuario;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Usuario, Integer> {
    // boolean existsByUsername(String username);
    // boolean existsByEmail(String email);
}