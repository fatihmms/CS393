package com.group1.termproject.controller;

import com.group1.termproject.DTO.AnswerDTO;
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
@RequestMapping("/questions")
@Api(value = "Answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @ApiOperation(
            value = "Saves a new answer for a question",
            notes = "Returns 404 if the Question ID is not valid")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Received answers displayed"),
            @ApiResponse(code = 404, message = "Question can not be found, " +
                    "change the question ID")})
    @PostMapping("/{questionId}/answer")
    public AnswerDTO saveAnswer(@PathVariable("questionId") int questionId ,@RequestBody AnswerDTO answerDTO){
        return answerService.save(questionId, answerDTO);
    }

    @ApiOperation(
            value = "Deletes an answer",
            notes = "Returns 404 if the Question ID is not valid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Answer is deleted"),
            @ApiResponse(code = 404, message = "Answer can not be found, " +
                    "change the answer ID")})
    @DeleteMapping("/answer/{answerId}")
    public void deleteAnswer(@PathVariable("answerId") int id){
       answerService.delete(id);
    }

    @ApiOperation(
            value = "Likes the specified answer",
            notes = "Specify the answer ID to be liked"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Answer is liked"),
            @ApiResponse(code = 404, message = "Answer cannot be found, change the answer ID")
    })
    @PutMapping("/answer/{answerId}/votes/like")
    public int like(@PathVariable("answerIid") int id){
        return answerService.like(id);
    }

    @ApiOperation(
            value = "Dislikes the specified answer",
            notes = "Specify the answer ID to be disliked"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Answer is disliked"),
            @ApiResponse(code = 404, message = "Answer cannot be found, change the answer ID")
    })
    @PutMapping("/answer/{answerId}/votes/dislike")
    public int dislike(@PathVariable("answerId") int id){
        return answerService.dislike(id);
    }

    @ApiOperation(
            value = "Updates the specified answer",
            notes = "Specify the answer ID to be updated"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Answer is updated"),
            @ApiResponse(code = 404, message = "Answer cannot be found, change the answer ID")
    })
    @PutMapping("/answer/{answerId}")
    public AnswerDTO updateAnswer(@PathVariable("answerId") int id, @RequestBody AnswerDTO answerDTO){
        return answerService.update(id, answerDTO);
    }
}
