package com.group1.termproject.controller;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;
import com.group1.termproject.repository.CommentRepository;
import com.group1.termproject.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/toQuestion")
    public Comment saveCommentForQuestion(@RequestBody CommentToQuestionDTO commentToQuestionDTO){
        return commentService.saveForQuestion(commentToQuestionDTO);
    }

    @PostMapping("/toAnswer")
    public Comment saveCommentForAnswer(@RequestBody CommentToAnswerDTO commentToAnswerDTO){
        return commentService.saveForAnswer(commentToAnswerDTO);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteAnswer(@PathVariable("id") int id){
        Comment comment = commentRepository.getById(id);
        comment.setQuestion(null);
        comment.setUser(null);
        comment.setAnswer(null);
        commentRepository.delete(comment);
    }
}
