package com.group1.termproject.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group1.termproject.model.User;

import java.util.Date;
import java.util.List;

public class QuestionPostDTO {

    private String title;
    private String text;
    private String tag;
    //private String askedBy;





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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    /*public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }*/
}
