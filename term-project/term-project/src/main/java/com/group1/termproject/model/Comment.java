package com.group1.termproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_COMMENT")
public class Comment {

    @Id@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CONTEXT")
    private String context;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_ID", referencedColumnName = "ID")
    private Answer answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
}
