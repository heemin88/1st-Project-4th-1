package com.backend.back.repository;

import com.backend.back.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByMail(String mail);
    User findByUid(Long id);
}
