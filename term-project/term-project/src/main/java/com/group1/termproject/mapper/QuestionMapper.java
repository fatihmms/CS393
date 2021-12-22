package com.group1.termproject.mapper;


import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = UserMapper.class)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class);

    @Mapping(target = "date", source = "askedDate")
    @Mapping(target = "vote", expression = "java(question.getLike() - question.getDislike())")
    @Mapping(target = "askedBy", expression = "java(question.getOwnerUser().getUsername())")
    QuestionDTO questionToDTO (Question question);

}
