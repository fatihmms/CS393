package com.group1.termproject.service;

import com.group1.termproject.DTO.*;
import com.group1.termproject.mapper.AnswerMapper;
import com.group1.termproject.mapper.CommentMapper;
import com.group1.termproject.mapper.QuestionMapper;
import com.group1.termproject.mapper.UserMapper;
import com.group1.termproject.model.Answer;
import com.group1.termproject.model.Comment;
import com.group1.termproject.model.Question;
import com.group1.termproject.model.User;
import com.group1.termproject.repository.QuestionRepository;
import com.group1.termproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AnswerService answerService;

    @Autowired
    CommentService commentService;


    QuestionMapper questionMapper;
    CommentMapper commentMapper;
    AnswerMapper answerMapper;
    UserMapper userMapper;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();}

    @Override
    public List<QuestionDTO> findByTag(List<String> tags) {
        List<Question> questions = questionRepository.findAll();
        questions.removeIf(q -> !q.getTags().containsAll(tags));
        return questionToDto(questions);
    }

    @Override
    public Question getById(int id) {
        return questionRepository.getById(id);
    }

    @Override
    public QuestionPostDTO save(QuestionPostDTO questionPostDTO) {
        Question question = questionMapper.INSTANCE.dtoToQuestion(questionPostDTO);
        User user = userRepository.findByUsername(questionPostDTO.getUsernameOfWriter());
        question.setOwnerUser(user);
        questionRepository.save(question);
        return questionPostDTO;
    }

    @Override
    public List<QuestionDTO> questionToDto(List<Question> questions) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question q: questions) {
            questionDTOS.add(questionMapper.INSTANCE.questionToDTO(q));
        }
        return questionDTOS;
    }

    @Override
    public QuestionDetailedDTO singleQuestionToDto(int id) {
        Question question = questionRepository.getById(id);
        QuestionDetailedDTO questionDetailedDTO = questionMapper.INSTANCE.questionToDetailedDTO(question);
        questionDetailedDTO.setAskedBy(userMapper.INSTANCE.userToDto(question.getOwnerUser()));
        List<CommentToQuestionDetailedDTO> comments = new ArrayList<>();
        for (Comment comment: question.getComments()) {
            assert false;
            CommentToQuestionDetailedDTO commentToQuestionDetailedDTO = commentMapper.INSTANCE.commentToQDetailedDTO(comment);
            commentToQuestionDetailedDTO.setWriter(userMapper.INSTANCE.userToDto(comment.getUser()));
            comments.add(commentToQuestionDetailedDTO);
        }
        questionDetailedDTO.setComments(comments);
        List<AnswerDetailedDTO> answers = new ArrayList<>();

        for (Answer answer: question.getAnswers()) {
            List<CommentToAnswerDetailedDTO> answerComments = new ArrayList<>();
            AnswerDetailedDTO answerDetailedDTO = answerMapper.INSTANCE.answerToDetailedDTO(answer);
            answerDetailedDTO.setWriter(userMapper.INSTANCE.userToDto(answer.getUser()));
            for (Comment comment: answer.getComments()) {
                CommentToAnswerDetailedDTO commentToAnswerDetailedDTO = commentMapper.INSTANCE.commentToADetailedDTO(comment);
                commentToAnswerDetailedDTO.setWriter(userMapper.INSTANCE.userToDto(comment.getUser()));
                answerComments.add(commentToAnswerDetailedDTO);
            }
            answerDetailedDTO.setComments(answerComments);
            answers.add(answerDetailedDTO);
        }
        questionDetailedDTO.setAnswers(answers);
        return questionDetailedDTO;
    }

    @Override
    public QuestionPostDTO update(int id, QuestionPostDTO questionPostDTO) {
        Question question = questionRepository.getById(id);
        question.setTitle(questionPostDTO.getTitle());
        question.setDescription(questionPostDTO.getText());
        question.setTags(questionPostDTO.getTags());
        questionRepository.save(question);
        return questionPostDTO;
    }

    @Override
    public int like(int id) {
        Question question = questionRepository.getById(id);
        question.setVote(question.getVote() + 1);
        questionRepository.save(question);
        return question.getVote();
    }

    @Override
    public int dislike(int id) {
        Question question = questionRepository.getById(id);
        question.setVote(question.getVote() - 1);
        questionRepository.save(question);
        return question.getVote();
    }

    @Override
    public void delete(int id) {
        Question question = questionRepository.getById(id);
        question.setOwnerUser(null);
        for (Answer answer: question.getAnswers()) {
            answerService.delete(answer.getId());
        }
        for (Comment comment:question.getComments()) {
            commentService.delete(comment.getId());
        }
        questionRepository.delete(question);

    }


}
