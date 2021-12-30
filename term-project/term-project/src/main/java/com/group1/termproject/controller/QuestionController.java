package com.group1.termproject.controller;

import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.mapper.QuestionMapper;
import com.group1.termproject.model.Question;
import com.group1.termproject.repository.QuestionRepository;
import com.group1.termproject.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Api(value = "Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    QuestionMapper questionMapper;

    @Autowired
    QuestionRepository questionRepository;

    @ApiOperation(
            value = "Saves a new question",
            notes = "Write the necessary properties for a question")
    @ApiResponse(code = 200, message = "Question is saved")
    @PostMapping
    public Question saveQuestion(@RequestBody QuestionPostDTO q){
        Question question = questionMapper.INSTANCE.dtoToQuestion(q);
        return questionService.save(q);
    }

    @ApiOperation(
            value = "Display all questions",
            notes = "All submitted questions are showed")
    @ApiResponse(code = 200, message = "All questions are displayed")
    @GetMapping
    public List<QuestionDTO> getAll(){
        List<Question> questions = questionService.findAll();
        return questionService.questionToDto(questions);
    }

    @ApiOperation(
            value = "Display questions by their tags",
            notes = "All submitted questions are showed by their tags")
    @ApiResponse(code = 200, message = "Questions by tags displayed")
    @GetMapping("/{tag}")
    public List<QuestionDTO> getByTag(@PathVariable("tag") String tag){
        List<Question> questions = questionService.findByTag(tag);
        return questionService.questionToDto(questions);
    }

    @ApiOperation(
            value = "Display questions by their IDs",
            notes = "Determine the needed question ID")
    @ApiResponse(code = 200, message = "Questions displayed")
    @GetMapping("/getById/{id}")
    public QuestionDTO getById(@PathVariable("id") int id){
        Question q = questionService.getById(id);
        return questionService.singleQuestionToDto(q);
    }

    @ApiOperation(
            value = "Delete questions by their IDs",
            notes = "Specify the question ID will be deleted")
    @ApiResponse(code = 200, message = "Questions are deleted")
    @DeleteMapping("deleteById/{id}")
    public void deleteAnswer(@PathVariable("id") int id){
        Question question = questionRepository.getById(id);
        question.setAnswers(null);
        question.setOwnerUser(null);
        question.setComments(null);
        questionRepository.deleteById(question.getId());
    }

    @ApiOperation(
            value = "Update the target question",
            notes = "Specify the question ID to be updated")
    @ApiResponse(code = 200, message = "Questions are updated")
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable("id") int id, @RequestBody QuestionPostDTO questionPostDTO){
        return questionService.update(id, questionPostDTO);
    }
}
