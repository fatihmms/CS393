package com.group1.termproject.repository;

import com.group1.termproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select q from Question q where q.tag=?1")
    List<Question> findByTag(String tag);


}
