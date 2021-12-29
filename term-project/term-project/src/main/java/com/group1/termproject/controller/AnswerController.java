package com.group1.termproject.controller;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.mapper.AnswerMapper;
import com.group1.termproject.model.Answer;
import com.group1.termproject.model.Question;
import com.group1.termproject.repository.AnswerRepository;
import com.group1.termproject.service.AnswerService;
import com.group1.termproject.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    AnswerRepository answerRepository;

    @ApiOperation()
    @PostMapping
    public Answer saveAnswer(@RequestBody AnswerDTO answerDTO){
        return answerService.save(answerDTO);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteAnswer(@PathVariable("id") int id){
        Answer answer = answerRepository.getById(id);
        answer.setUser(null);
        answer.setQuestion(null);
        answer.setComments(null);
        answerRepository.deleteById(answer.getId());
    }
}
