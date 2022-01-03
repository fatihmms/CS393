package com.group1.termproject.DTO;

import java.util.List;

public class QuestionPostDTO {

    private String title;
    private String text;
    private List<String> tags;
    private String usernameOfWriter;


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

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

    public String getUsernameOfWriter() {
        return usernameOfWriter;
    }

    public void setUsernameOfWriter(String usernameOfWriter) {
        this.usernameOfWriter = usernameOfWriter;
    }
}


