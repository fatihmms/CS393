package com.group1.termproject.service;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;

public interface CommentService {

    Comment saveForQuestion(int id, CommentToQuestionDTO commentToQuestionDTO);
    Comment saveForAnswer(int id, CommentToAnswerDTO commentToQuestionDTO);
}
