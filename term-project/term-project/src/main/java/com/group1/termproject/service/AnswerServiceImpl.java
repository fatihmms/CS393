package com.group1.termproject.service;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.mapper.AnswerMapper;
import com.group1.termproject.mapper.UserMapper;
import com.group1.termproject.model.Answer;
import com.group1.termproject.model.Comment;
import com.group1.termproject.model.Question;
import com.group1.termproject.model.User;
import com.group1.termproject.repository.AnswerRepository;
import com.group1.termproject.repository.CommentRepository;
import com.group1.termproject.repository.QuestionRepository;
import com.group1.termproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentServiceImpl commentService;

    AnswerMapper answerMapper;
    UserMapper userMapper;
    @Override
    public AnswerDTO save(int questionId, AnswerDTO answerDTO) {
        Answer answer = answerMapper.INSTANCE.dtoToAnswer(answerDTO);
        Question question = questionRepository.getById(questionId);
        User user = userRepository.findByUsername(answerDTO.getUsernameOfWriter());
        answer.setQuestion(question);
        answer.setUser(user);
        answerRepository.save(answer);
        return answerDTO;
    }

    @Override
    public int like(int id) {
        Answer answer = answerRepository.getById(id);
        answer.setVote(answer.getVote() + 1);
        answerRepository.save(answer);
        return answer.getVote();
    }

    @Override
    public int dislike(int id) {
        Answer answer = answerRepository.getById(id);
        answer.setVote(answer.getVote() - 1);
        answerRepository.save(answer);
        return answer.getVote();
    }

    @Override
    public void delete(int id) {
        Answer answer = answerRepository.getById(id);
        answer.setQuestion(null);
        answer.setUser(null);
        for (Comment comment: answer.getComments()) {
            commentService.delete(comment.getId());
        }
        answerRepository.delete(answer);
    }

    @Override
    public AnswerDTO update(int id, AnswerDTO answerDTO) {
        Answer answer = answerRepository.getById(id);
        answer.setContent(answerDTO.getText());
        answerRepository.save(answer);
        return answerDTO;
    }
}
