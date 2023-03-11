package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.comment.Comment;
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


    /**
     *
     *
     * User 회원가입 Service
     */
    @Transactional
    public Long join(User user) {

        validateDuplicateMember(user);
        userRepository.save(user);

        return user.getUid();
    }

    /**
     *
     * 회원가입시 중복검사
     */
    private void validateDuplicateMember(User user) {
        // Exception 발생
        List<User> findMembers = userRepository.findByMail(user.getMail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    /**
     *
     *
     * 회원탈퇴 Service
     */
    public void delete_User(User user) {
        List<Comment> comments = user.getComments();
        comments.clear();

        List<Board> posts = user.getPosts();
        posts.clear();;

        userRepository.delete(user);
    }

    /**
     *
     *
     * 공통 Service
     */


    public User findOne(Long id) {
        return userRepository.findByUid(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


}
