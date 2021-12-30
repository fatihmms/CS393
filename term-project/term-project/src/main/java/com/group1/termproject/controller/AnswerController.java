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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/answers")
@Api(value = "Answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerRepository answerRepository;

    @ApiOperation(
            value = "Saves a new answer for a question",
            notes = "Returns 404 if the Question ID is not valid")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Received answers displayed"),
            @ApiResponse(code = 404, message = "Question can not be found, " +
                    "change the question ID")})

    @PostMapping("/{questionId}")
    public Answer saveAnswer(@PathVariable("questionId") int id ,@RequestBody AnswerDTO answerDTO){
        return answerService.save(id, answerDTO);
    }

    @ApiOperation(
            value = "Deletes an answer",
            notes = "Returns 404 if the Question ID is not valid")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Answer is deleted"),
            @ApiResponse(code = 404, message = "Answer can not be found, " +
                    "change the answer ID")})
    @DeleteMapping("deleteById/{id}")
    public void deleteAnswer(@PathVariable("id") int id){
        Answer answer = answerRepository.getById(id);
        answer.setUser(null);
        answer.setQuestion(null);
        answer.setComments(null);
        answerRepository.deleteById(answer.getId());
    }
}
