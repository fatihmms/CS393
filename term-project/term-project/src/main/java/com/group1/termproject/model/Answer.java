package com.group1.termproject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ANSWER")
public class Answer {

    @Id@Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date answeringDate;

    @Column(name = "COUNT_OF_LIKE")
    private int like;

    @Column(name = "COUNT_OF_DISLIKE")
    private int dislike;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @OneToMany(mappedBy = "answer")
    private List<Comment> comments;
}
