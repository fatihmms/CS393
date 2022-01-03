package com.group1.termproject.mapper;

import com.group1.termproject.DTO.CommentToAnswerDTO;
import com.group1.termproject.DTO.CommentToAnswerDetailedDTO;
import com.group1.termproject.DTO.CommentToQuestionDTO;
import com.group1.termproject.DTO.CommentToQuestionDetailedDTO;
import com.group1.termproject.model.Comment;
import com.group1.termproject.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = UserMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper( CommentMapper.class);

    Comment dtoToCommentForQuestion(CommentToQuestionDTO commentToQuestionDTO);

    Comment dtoToCommentForAnswer(CommentToAnswerDTO commentToAnswerDTO);

    @Mapping(target = "text", source = "context")
    CommentToAnswerDetailedDTO commentToADetailedDTO(Comment comment);

    @Mapping(target = "text", source = "context")
    CommentToQuestionDetailedDTO commentToQDetailedDTO(Comment comment);
}
