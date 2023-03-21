package com.backend.back.controller;

import com.backend.back.Domain.problem.LevelProblemType;
import com.backend.back.Domain.user.User;
import com.backend.back.model.response.CommonResult;
import com.backend.back.model.response.ListResult;
import com.backend.back.model.response.SingleResult;
import com.backend.back.repository.UserRepository;
import com.backend.back.service.ResponseService;
import com.backend.back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // 결과값을 JSON으로 출력함
public class UserController {
    private final UserService userService;
    private final ResponseService responseService; // 결과를 처리할 서비스

    /**
     * 회원 리스트 조회
     */
    @GetMapping(value="/users")
    public ListResult<User> findAllUser(){
        return responseService.getListResult(userService.findAll());
    }
    /**
     * 회원 단건 조회
     */
    @GetMapping(value="/user/{msrl}")
    public SingleResult<User> findUserById(@PathVariable long msrl){
        return responseService.getSingleResult(userService.findOne(msrl).orElse(null));
    }
    /**
    * 유저 회원가입
    */
    @PostMapping(value="/user")
    public SingleResult<User> save(@RequestParam String mail, @RequestParam String password, @RequestParam LevelProblemType level){
        User user = User.builder()
                .mail(mail)
                .level(level)
                .password(password)
                .problem_count(0)
                .problem_current(0)
                .build();
        return responseService.getSingleResult(userService.join(user));
    }
    /**
     * 회원 삭제
     */
    @DeleteMapping (value= "/user/{msrl}")
    public CommonResult delete(@PathVariable long msrl){
        userService.delete_User(userService.findOne(msrl).orElse(null));
        return responseService.getSuccessResult(); //성공 결과 정보만 리턴
    }
}
