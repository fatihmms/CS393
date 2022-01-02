package com.group1.termproject.service;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;

public interface CommentService {

    CommentToQuestionDTO saveForQuestion(int id, CommentToQuestionDTO commentToQuestionDTO);
    CommentToAnswerDTO saveForAnswer(int id, CommentToAnswerDTO commentToQuestionDTO);
}
