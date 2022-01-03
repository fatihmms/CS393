package com.group1.termproject.DTO;

import java.util.Date;

public class CommentToAnswerDetailedDTO {

    private String text;
    private Date date;
    private UserDTO writer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getWriter() {
        return writer;
    }

    public void setWriter(UserDTO writer) {
        this.writer = writer;
    }
}
