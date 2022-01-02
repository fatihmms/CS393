package com.group1.termproject.mapper;


import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = UserMapper.class)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class);


    QuestionDTO questionToDTO (Question question);

    @Mapping(target = "description", source = "text")
    Question dtoToQuestion (QuestionPostDTO questionPostDTO);
}
