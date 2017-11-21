package com.questionmarks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne // indicates to JPA/Hibernate that Many questions can exist To One exam.
    @JoinColumn(name = "exam_id")//indicates that there will be a column called exam_id, in the table that supports Question, to reference the exam that owns this question.
    private Exam exam;

    private long order;

    @NotNull
    private String description;
}