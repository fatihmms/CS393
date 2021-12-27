package com.group1.termproject.controller;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;
import com.group1.termproject.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@Api
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/toQuestion")
    public Comment saveCommentForQuestion(@RequestBody CommentToQuestionDTO commentToQuestionDTO){
        return commentService.saveForQuestion(commentToQuestionDTO);
    }

    @PostMapping("/toAnswer")
    public Comment saveCommentForAnswer(@RequestBody CommentToAnswerDTO commentToAnswerDTO){
        return commentService.saveForAnswer(commentToAnswerDTO);
    }

}
