package com.group1.termproject.service;


import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    List<Question> findByTag(String tag);
    Question getById(int id);
    Question save(QuestionPostDTO q);
    List<QuestionDTO> questionToDto(List<Question> q);
    QuestionDTO singleQuestionToDto(Question q);
    Question update(int id, QuestionPostDTO q);

}
