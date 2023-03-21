package com.backend.back.api.Controller;

import com.backend.back.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class boardController {

    private final BoardService boardService;

    /**
     * 게시물 등록
     */





}
