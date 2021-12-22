package com.group1.termproject.controller;

import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.mapper.QuestionMapper;
import com.group1.termproject.model.Question;
import com.group1.termproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    QuestionMapper questionMapper;

    @PostMapping
    public Question saveQuestion(@RequestBody Question q){
        return questionService.save(q);
    }

    @GetMapping
    public List<QuestionDTO> getAll(){
        List<Question> questions = questionService.findAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question q: questions) {
            questionDTOS.add(questionMapper.INSTANCE.questionToDTO(q));
        }
        return questionDTOS;

    }

    @GetMapping("/{tag}")
    public List<QuestionDTO> getByTag(@PathVariable("tag") String tag){
        List<Question> questions = questionService.findByTag(tag);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question q: questions) {
            questionDTOS.add(questionMapper.INSTANCE.questionToDTO(q));
        }
        return questionDTOS;
    }
}
