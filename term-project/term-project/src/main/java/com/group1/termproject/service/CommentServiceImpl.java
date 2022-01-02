package com.group1.termproject.service;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.mapper.CommentMapper;
import com.group1.termproject.model.Comment;
import com.group1.termproject.repository.AnswerRepository;
import com.group1.termproject.repository.CommentRepository;
import com.group1.termproject.repository.QuestionRepository;
import com.group1.termproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    CommentMapper commentMapper;

    @Override
    public CommentToQuestionDTO saveForQuestion(int id, CommentToQuestionDTO commentToQuestionDTO) {
        Comment comment = commentMapper.INSTANCE.dtoToCommentForQuestion(commentToQuestionDTO);
        comment.setQuestion(questionRepository.getById(id));
        comment.setUser(userRepository.getById(id));
        commentRepository.save(comment);
        return commentToQuestionDTO;
    }

    @Override
    public CommentToAnswerDTO saveForAnswer(int id, CommentToAnswerDTO commentToAnswerDTO){
        Comment comment = commentMapper.INSTANCE.dtoToCommentForAnswer(commentToAnswerDTO);
        comment.setAnswer(answerRepository.getById(id));
        comment.setUser(userRepository.getById(id));
        comment.setQuestion(answerRepository.getById(id).getQuestion());
        commentRepository.save(comment);
        return commentToAnswerDTO;
    }
}
