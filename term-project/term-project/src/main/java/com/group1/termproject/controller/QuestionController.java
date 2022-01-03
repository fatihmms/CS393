package com.group1.termproject.controller;

import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionDetailedDTO;
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


    @Autowired
    QuestionRepository questionRepository;

    @ApiOperation(
            value = "Saves a new question",
            notes = "Write the necessary properties for a question")
    @ApiResponse(code = 200, message = "Question is saved")
    @PostMapping("/ask")
    public QuestionPostDTO saveQuestion(@RequestBody QuestionPostDTO q){
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
    @GetMapping("/tagged/{tags}")
    @ResponseBody
    public List<QuestionDTO> getByTag(@PathVariable("tags")  List<String> tags){
        return questionService.findByTag(tags);
    }

    @ApiOperation(
            value = "Display questions by their IDs",
            notes = "Determine the needed question ID")
    @ApiResponse(code = 200, message = "Questions displayed")
    @GetMapping("/id/{questionId}")
    public QuestionDetailedDTO getById(@PathVariable("questionId") int id){
        return questionService.singleQuestionToDto(id);
    }

    @ApiOperation(
            value = "Delete questions by their IDs",
            notes = "Specify the question ID will be deleted")
    @ApiResponse(code = 200, message = "Questions are deleted")
    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") int id){
        questionService.delete(id);
    }

    @ApiOperation(
            value = "Update the target question",
            notes = "Specify the question ID to be updated")
    @ApiResponse(code = 200, message = "Questions are updated")
    @PutMapping("/{questionId}")
    public QuestionPostDTO updateQuestion(@PathVariable("questionId") int id, @RequestBody QuestionPostDTO questionPostDTO){
        return questionService.update(id, questionPostDTO);
    }

    @ApiOperation(
            value = "Like the specified question",
            notes = "Specify the question ID to be liked")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Question is disliked"),
            @ApiResponse(code = 400, message = "Question cannot be found, change the question ID")
    })
    @PutMapping("/{questionId}/votes/like")
    public int like(@PathVariable("questionId") int id){
        return questionService.like(id);
    }

    @ApiOperation(
            value = "Dislike the specified question",
            notes = "Specify the question ID to be disliked")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Question is disliked"),
            @ApiResponse(code = 400, message = "Question cannot be found, change the question ID")
    })
    @PutMapping("/{questionId}/votes/dislike")
    public int dislike(@PathVariable("questionId") int id){
        return questionService.dislike(id);
    }
}
