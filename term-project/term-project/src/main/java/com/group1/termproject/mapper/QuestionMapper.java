package com.group1.termproject.mapper;


import com.group1.termproject.DTO.QuestionDTO;
import com.group1.termproject.DTO.QuestionDetailedDTO;
import com.group1.termproject.DTO.QuestionPostDTO;
import com.group1.termproject.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



@Mapper(uses = {UserMapper.class, AnswerMapper.class, CommentMapper.class})
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class);

    @Mapping(target = "askedBy", expression = "java(question.getOwnerUser().getFirst_name() + ' '  + question.getOwnerUser().getLast_name())")
    @Mapping(target = "answerCount", expression = "java(question.getAnswers().size())")
    QuestionDTO questionToDTO (Question question);

    @Mapping(target = "description", source = "text")
    Question dtoToQuestion (QuestionPostDTO questionPostDTO);

    @Mapping(target = "text", source = "description")
    @Mapping(target = "answerCount", expression = "java(question.getAnswers().size())")
    QuestionDetailedDTO questionToDetailedDTO(Question question);
}
