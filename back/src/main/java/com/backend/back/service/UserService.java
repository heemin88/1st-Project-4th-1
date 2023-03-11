package com.backend.back.service;

import com.backend.back.Domain.user.User;
import com.backend.back.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {

        validateDuplicateMember(user);
        userRepository.save(user);

        return user.getUid();
    }

    private void validateDuplicateMember(User user) {
        // Exception 발생
        List<User> findMembers = userRepository.findByMail(user.getMail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public User findOne(Long id) {
        return userRepository.findByUid(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


}
