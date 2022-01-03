package com.group1.termproject.DTO;

import com.group1.termproject.model.User;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

@ApiModel(value = "QuestionDTO")
public class QuestionDTO {


    private String title;
    private String description;
    private List<String> tags;
    private Date date;
    private int vote;
    private int answerCount;
    private String askedBy;

    public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
