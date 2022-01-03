package com.group1.termproject.service;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.model.Answer;

public interface AnswerService {
    AnswerDTO save(int questionId, AnswerDTO answerDTO);
    int like(int id);
    int dislike(int id);
    void delete(int id);
    AnswerDTO update(int id, AnswerDTO answerDTO);
}
