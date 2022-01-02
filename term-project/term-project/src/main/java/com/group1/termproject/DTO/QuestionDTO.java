package com.group1.termproject.DTO;

import com.group1.termproject.model.User;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

@ApiModel(value = "QuestionDTO")
public class QuestionDTO {


    private String title;
    private String description;
    private String tag;

    private int vote;
    //private String askedBy;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    /*public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }*/
}
