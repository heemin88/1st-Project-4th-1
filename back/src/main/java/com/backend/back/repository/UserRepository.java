package com.backend.back.repository;

import com.backend.back.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(User user){
        em.persist(user);
        return user.getUid();
    }
    public User find(Long uid){
        return em.find(User.class,uid);
    }
}
