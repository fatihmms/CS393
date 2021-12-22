package com.group1.termproject.service;


import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    List<Question> findByTag(String tag);
    Question save(Question q);
}
