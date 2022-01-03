package com.group1.termproject.controller;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;
import com.group1.termproject.repository.CommentRepository;
import com.group1.termproject.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@Api(value = "Comment")
public class CommentController {

    @Autowired
    CommentService commentService;


    @ApiOperation(
            value = "Saves a new comment for a question",
            notes = "Returns 404 if the Question ID is not valid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Received comments for questions are displayed"),
            @ApiResponse(code = 404, message = "Question can not be found, " +
                    "change the question ID")})
    @PostMapping("/{questionId}/comment")
    public CommentToQuestionDTO saveCommentForQuestion(@PathVariable("questionId") int questionId,@RequestBody CommentToQuestionDTO commentToQuestionDTO){
        return commentService.saveForQuestion(questionId,commentToQuestionDTO);
    }

    @ApiOperation(
            value = "Saves a new comment for an answer",
            notes = "Returns 404 if the Answer ID is not valid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Received comments for answers are displayed"),
            @ApiResponse(code = 404, message = "Answer can not be found, " +
                    "change the answer ID")})
    @PostMapping("/answer/{answerId}/comment")
    public CommentToAnswerDTO saveCommentForAnswer(@RequestBody CommentToAnswerDTO commentToAnswerDTO,@PathVariable("answerId") int answerId){
        return commentService.saveForAnswer(answerId, commentToAnswerDTO);
    }

    @ApiOperation(
            value = "Deletes specified comment for an answer",
            notes = "Returns 404 if the Comment ID is not valid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment is deleted"),
            @ApiResponse(code = 404, message = "Comment can not be found, " +
                    "change the comment ID")})
    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable("commentId") int id){
        commentService.delete(id);
    }

    @ApiOperation(
            value = "Likes a comment",
            notes = "Specify the comment ID will be liked, returns the updated vote count"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment is liked"),
            @ApiResponse(code = 404, message = "Comment cannot be found, change the comment ID")
    })
    @PutMapping("/comment/{commentId}/votes/like")
    public int like(@PathVariable("commentId") int id){
        return commentService.like(id);
    }

    @ApiOperation(
            value = "Dislikes a comment",
            notes = "Specify the comment ID will be disliked, returns the updated vote count"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment is disliked"),
            @ApiResponse(code = 404, message = "Comment cannot be found, change the comment ID")
    })
    @PutMapping("/comment/{commentId}/votes/dislike")
    public int dislike(@PathVariable("commentId") int id){
        return commentService.dislike(id);
    }

    @ApiOperation(
            value = "Updates a comment for an answer",
            notes = "Specify the comment ID will be updated"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment is disliked"),
            @ApiResponse(code = 404, message = "Comment cannot be found, change the comment ID")
    })
    @PutMapping("/answers/comment/{commentId}/edit/")
    public CommentToAnswerDTO updateCommentForAnswer(@PathVariable("commentId") int id, CommentToAnswerDTO commentToAnswerDTO){
        return commentService.updateCommentForAnswer(id, commentToAnswerDTO);
    }

    @ApiOperation(
            value = "Updates a comment for a question",
            notes = "Specify the comment ID will be updated"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment is disliked"),
            @ApiResponse(code = 404, message = "Comment cannot be found, change the comment ID")
    })
    @PutMapping("/comment/{commentId}/edit")
    public CommentToQuestionDTO updateCommentForQuestion(@PathVariable("commentId") int id, CommentToQuestionDTO commentToQuestionDTO){
        return commentService.updateCommentForQuestion(id, commentToQuestionDTO);
    }
}
