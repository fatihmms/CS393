package com.group1.termproject.mapper;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper( CommentMapper.class);

    Comment dtoToCommentForQuestion(CommentToQuestionDTO commentToQuestionDTO);

    Comment dtoToCommentForAnswer(CommentToAnswerDTO commentToAnswerDTO);
}
