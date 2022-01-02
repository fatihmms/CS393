package com.group1.termproject.mapper;

import com.group1.termproject.DTO.AnswerDTO;
import com.group1.termproject.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper( AnswerMapper.class);


    @Mapping(target = "text", source = "content")
    AnswerDTO answerToDTO(Answer answer);


    @Mapping(target = "content", source = "text")
    Answer dtoToAnswer(AnswerDTO answerDTO);
}
