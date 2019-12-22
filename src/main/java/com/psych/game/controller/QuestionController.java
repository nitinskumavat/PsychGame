package com.psych.game.controller;

import com.psych.game.model.Question;
import com.psych.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable(value = "id") Long id) throws Exception{
        return questionRepository.findById(id).orElseThrow(()->new Exception("Question with this id not found"));
    }

    @PostMapping("/questions")
    public Question createQuestion(@Valid @RequestBody Question question){
        return questionRepository.save(question);
    }

}
