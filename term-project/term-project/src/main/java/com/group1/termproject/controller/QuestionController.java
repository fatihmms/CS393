package com.group1.termproject.controller;

import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.mapper.QuestionMapper;
import com.group1.termproject.model.Question;
import com.group1.termproject.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Api
public class QuestionController {

    @Autowired
    QuestionService questionService;

    QuestionMapper questionMapper;

    @PostMapping
    public Question saveQuestion(@RequestBody QuestionPostDTO q){
        Question question = questionMapper.INSTANCE.dtoToQuestion(q);
        return questionService.save(q);
    }

    @ApiOperation(value = "Getting all questions")
    @GetMapping
    public List<QuestionDTO> getAll(){
        List<Question> questions = questionService.findAll();
        return questionService.questionToDto(questions);
    }

    @ApiOperation(value = "Get all questions with a tag")
    @GetMapping("/{tag}")
    public List<QuestionDTO> getByTag(@PathVariable("tag") String tag){
        List<Question> questions = questionService.findByTag(tag);
        return questionService.questionToDto(questions);
    }

    @ApiOperation(value = "Get question by specified ID")
    @GetMapping("/getById/{id}")
    public QuestionDTO getById(@PathVariable("id") int id){
        Question q = questionService.getById(id);
        return questionService.singleQuestionToDto(q);
    }
}
