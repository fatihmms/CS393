package com.group1.termproject.service;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.mapper.AnswerMapper;
import com.group1.termproject.model.Answer;
import com.group1.termproject.model.Question;
import com.group1.termproject.model.User;
import com.group1.termproject.repository.AnswerRepository;
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

    AnswerMapper answerMapper;

    @Override
    public Answer save(int id, AnswerDTO answerDTO) {
        Answer answer = answerMapper.INSTANCE.dtoToAnswer(answerDTO);
        Question question = questionRepository.getById(id);
        User user = userRepository.findByUsername(answerDTO.getAnsweredBy());
        answer.setQuestion(question);
        answer.setUser(user);
        return answerRepository.save(answer);
    }
}
