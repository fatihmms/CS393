package com.group1.termproject.controller;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.mapper.AnswerMapper;
import com.group1.termproject.model.Answer;
import com.group1.termproject.model.Question;
import com.group1.termproject.service.AnswerService;
import com.group1.termproject.service.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/answers")
@Api
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;


    @PostMapping
    public Answer saveAnswer(@RequestBody AnswerDTO answerDTO){
        return answerService.save(answerDTO);
    }
}
