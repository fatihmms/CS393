package com.group1.termproject.DTO;

import java.util.Date;

public class CommentToQuestionDetailedDTO {

    private String text;
    private UserDTO writer;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getWriter() {
        return writer;
    }

    public void setWriter(UserDTO writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
