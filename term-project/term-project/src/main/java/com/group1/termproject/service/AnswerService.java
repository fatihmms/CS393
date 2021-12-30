package com.group1.termproject.service;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.model.Answer;

public interface AnswerService {
    Answer save(int id, AnswerDTO answerDTO);
}
