package com.group1.termproject.model;

import javax.persistence.*;
import javax.websocket.OnError;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
public class Question {

    @Id@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "TAG")
    private String tag;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private Date askedDate;

    @Column(name = "COUNT_OF_DISLIKE")
    private int dislike;

    @Column(name = "COUNT_OF_LIKE")
    private int like;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User ownerUser;

    @OneToMany(mappedBy = "question")
    private List<Comment> comments;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;




}
