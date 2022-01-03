package com.group1.termproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.websocket.OnError;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
public class Question {

    @Id@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @Column(name = "TAG")
    private List<String> tags;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date = new Date();

    @Column(name = "VOTE", columnDefinition = "integer default 0 ")
    private int vote;

    @Column(name = "TEXT")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User ownerUser;

    @OneToMany(mappedBy = "question")
    private List<Comment> comments;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date askedDate) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }


}
