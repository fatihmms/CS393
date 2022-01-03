package com.group1.termproject.service;


import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionDetailedDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    List<QuestionDTO> findByTag(List<String> tags);
    Question getById(int id);
    QuestionPostDTO save(QuestionPostDTO q);
    List<QuestionDTO> questionToDto(List<Question> q);
    QuestionDetailedDTO singleQuestionToDto(int id);
    QuestionPostDTO update(int id, QuestionPostDTO q);
    int like(int id);
    int dislike(int id);
    void delete(int id);

}
