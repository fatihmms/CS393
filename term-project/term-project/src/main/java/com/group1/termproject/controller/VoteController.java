package com.group1.termproject.controller;

import com.group1.termproject.model.Answer;
import com.group1.termproject.model.Comment;
import com.group1.termproject.model.Question;
import com.group1.termproject.repository.AnswerRepository;
import com.group1.termproject.repository.CommentRepository;
import com.group1.termproject.repository.QuestionRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting")
@Api
public class VoteController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/likeQuestion/{id}")
    public int likeQuestion(@PathVariable("id") int id){
        Question question = questionRepository.getById(id);
        question.setVote(question.getVote() + 1);
        questionRepository.save(question);
        return question.getVote();
    }

    @GetMapping("/dislikeQuestion/{id}")
    public int dislikeQuestion(@PathVariable("id") int id){
        Question question = questionRepository.getById(id);
        question.setVote(question.getVote() - 1);
        questionRepository.save(question);
        return question.getVote();
    }

    @GetMapping("/likeAnswer/{id}")
    public int likeAnswer(@PathVariable("id") int id){
        Answer answer = answerRepository.getById(id);
        answer.setVote(answer.getVote() + 1);
        answerRepository.save(answer);
        return answer.getVote();
    }

    @GetMapping("/dislikeAnswer/{id}")
    public int dislikeAnswer(@PathVariable("id") int id){
        Answer answer = answerRepository.getById(id);
        answer.setVote(answer.getVote() - 1);
        answerRepository.save(answer);
        return answer.getVote();
    }

    @GetMapping("/likeComment/{id}")
    public int likeComment(@PathVariable("id") int id){
        Comment comment = commentRepository.getById(id);
        comment.setVote(comment.getVote() + 1);
        commentRepository.save(comment);
        return comment.getVote();
    }
    @GetMapping("/dislikeComment/{id}")
    public int dislikeComment(@PathVariable("id") int id){
        Comment comment = commentRepository.getById(id);
        comment.setVote(comment.getVote() - 1);
        commentRepository.save(comment);
        return comment.getVote();
    }

}
