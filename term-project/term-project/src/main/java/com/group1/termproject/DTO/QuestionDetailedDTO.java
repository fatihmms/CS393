package com.group1.termproject.DTO;

import java.util.Date;
import java.util.List;

public class QuestionDetailedDTO {

    private String title;
    private String text;
    private List<String> tags;
    private UserDTO askedBy;
    private Date date;
    private int vote;
    private int answerCount;
    private List<AnswerDetailedDTO> answers;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<CommentToQuestionDetailedDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentToQuestionDetailedDTO> comments) {
        this.comments = comments;
    }

    private List<CommentToQuestionDetailedDTO> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public UserDTO getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(UserDTO askedBy) {
        this.askedBy = askedBy;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public List<AnswerDetailedDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDetailedDTO> answers) {
        this.answers = answers;
    }




}
