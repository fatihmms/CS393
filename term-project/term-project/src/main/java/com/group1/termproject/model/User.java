package com.group1.termproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User {

    public User(String username, String first_name, String last_name) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Id@Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String first_name;

    @Column(name = "surname")
    private String last_name;

    @OneToMany(mappedBy = "ownerUser")
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User() {

    }
}
