package com.group1.termproject.service;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.mapper.CommentMapper;
import com.group1.termproject.mapper.UserMapper;
import com.group1.termproject.model.Comment;
import com.group1.termproject.repository.AnswerRepository;
import com.group1.termproject.repository.CommentRepository;
import com.group1.termproject.repository.QuestionRepository;
import com.group1.termproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
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
    public CommentToQuestionDTO saveForQuestion(int questionId, CommentToQuestionDTO commentToQuestionDTO) {
        Comment comment = commentMapper.INSTANCE.dtoToCommentForQuestion(commentToQuestionDTO);
        comment.setQuestion(questionRepository.getById(questionId));
        comment.setUser(userRepository.findByUsername(commentToQuestionDTO.getUsernameOfWriter()));
        commentRepository.save(comment);

        return commentToQuestionDTO;
    }

    @Override
    public CommentToAnswerDTO saveForAnswer(int answerId, CommentToAnswerDTO commentToAnswerDTO){
        Comment comment = commentMapper.INSTANCE.dtoToCommentForAnswer(commentToAnswerDTO);
        comment.setAnswer(answerRepository.getById(answerId));
        comment.setUser(userRepository.findByUsername(commentToAnswerDTO.getUsernameOfWriter()));
        commentRepository.save(comment);
        return commentToAnswerDTO;
    }

    @Override
    public CommentToQuestionDTO updateCommentForQuestion(int commentId, CommentToQuestionDTO commentToQuestionDTO) {
        Comment comment = commentRepository.getById(commentId);
        comment.setContext(commentToQuestionDTO.getContext());
        commentRepository.save(comment);
        return commentToQuestionDTO;
    }

    @Override
    public CommentToAnswerDTO updateCommentForAnswer(int commentId, CommentToAnswerDTO commentToAnswerDTO) {
        Comment comment = commentRepository.getById(commentId);
        comment.setContext(commentToAnswerDTO.getContext());
        commentRepository.save(comment);
        return commentToAnswerDTO;
    }





    @Override
    public int like(int id) {
        Comment comment = commentRepository.getById(id);
        comment.setVote(comment.getVote() + 1);
        commentRepository.save(comment);
        return comment.getVote();
    }

    @Override
    public int dislike(int id) {
        Comment comment = commentRepository.getById(id);
        comment.setVote(comment.getVote() - 1);
        commentRepository.save(comment);
        return comment.getVote();
    }

    @Override
    public void delete(int id) {
        Comment comment = commentRepository.getById(id);
        comment.setAnswer(null);
        comment.setUser(null);
        comment.setQuestion(null);
        commentRepository.delete(comment);
    }


}
