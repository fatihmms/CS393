package com.group1.termproject.DTO;

public class CommentToQuestionDTO {

    private String usernameOfWriter;
    private String context;




    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUsernameOfWriter() {
        return usernameOfWriter;
    }

    public void setUsernameOfWriter(String usernameOfWriter) {
        this.usernameOfWriter = usernameOfWriter;
    }
}
