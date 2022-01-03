package com.group1.termproject.DTO;

import java.util.Date;
import java.util.List;

public class AnswerDetailedDTO {

    private String text;
    private int vote;
    private UserDTO writer;
    private List<CommentToAnswerDetailedDTO> comments;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public UserDTO getWriter() {
        return writer;
    }

    public void setWriter(UserDTO writer) {
        this.writer = writer;
    }

    public List<CommentToAnswerDetailedDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentToAnswerDetailedDTO> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
