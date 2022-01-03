package com.group1.termproject.service;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;

public interface CommentService {

    CommentToQuestionDTO saveForQuestion(int questionId,CommentToQuestionDTO commentToQuestionDTO);
    CommentToAnswerDTO saveForAnswer(int answerId,CommentToAnswerDTO commentToQuestionDTO);
    CommentToQuestionDTO updateCommentForQuestion(int commentId, CommentToQuestionDTO commentToQuestionDTO);
    CommentToAnswerDTO updateCommentForAnswer(int commentId, CommentToAnswerDTO commentToAnswerDTO);
    int like(int id);
    int dislike(int id);
    void delete(int id);

}
