package com.group1.termproject.service;

import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.mapper.QuestionMapper;
import com.group1.termproject.model.Question;
import com.group1.termproject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    QuestionMapper questionMapper;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();}

    @Override
    public List<Question> findByTag(String tag) {
        return questionRepository.findByTag(tag);
    }

    @Override
    public Question save(Question q) {
        return questionRepository.save(q);
    }

    @Override
    public List<QuestionDTO> questionToDto(List<Question> questions) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question q: questions) {
            questionDTOS.add(questionMapper.INSTANCE.questionToDTO(q));
        }
        return questionDTOS;
    }
}
