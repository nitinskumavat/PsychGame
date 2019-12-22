package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "questions")
public class Question extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long question_id;

    @Getter
    @Setter
    @NotBlank
    String question_text;

    @Getter
    @Setter
    @NotBlank
    String answer;

}
