package com.group1.termproject.service;

import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.mapper.QuestionMapper;
import com.group1.termproject.mapper.UserMapper;
import com.group1.termproject.model.Question;
import com.group1.termproject.model.User;
import com.group1.termproject.repository.QuestionRepository;
import com.group1.termproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    QuestionMapper questionMapper;
    UserMapper userMapper;
    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();}

    @Override
    public List<Question> findByTag(String tag) {
        return questionRepository.findByTag(tag);
    }

    @Override
    public Question getById(int id) {
        return questionRepository.getById(id);
    }

    @Override
    public Question save(QuestionPostDTO q) {
        Question question = questionMapper.INSTANCE.dtoToQuestion(q);
        User user = userRepository.findByUsername(q.getAskedBy());
        question.setOwnerUser(user);
        return questionRepository.save(question);
    }

    @Override
    public List<QuestionDTO> questionToDto(List<Question> questions) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question q: questions) {
            questionDTOS.add(questionMapper.INSTANCE.questionToDTO(q));
        }
        return questionDTOS;
    }

    @Override
    public QuestionDTO singleQuestionToDto(Question q) {
        return questionMapper.INSTANCE.questionToDTO(q);
    }
}
