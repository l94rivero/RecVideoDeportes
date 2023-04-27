package com.ar.repositorios;

import com.ar.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepositoryImpl implements JpaRepository<Usuario, Integer>, UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Usuario findByname(String name) {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u from User u WHERE u.name = :name", Usuario.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public Usuario findByEmail(String email) {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u from User u WHERE u.email = :email", Usuario.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }
}
