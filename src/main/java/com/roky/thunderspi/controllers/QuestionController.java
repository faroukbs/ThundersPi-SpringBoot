package com.roky.thunderspi.controllers;


import com.roky.thunderspi.entities.Question;
import com.roky.thunderspi.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/qst")
@RequiredArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;

    @GetMapping
    public Set<Question> getAll()
    {
        return questionService.findAll();
    }
    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id)
    {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public Question addQuestion(@RequestParam Question q)
    {
        return questionService.addQuestion(q);
    }

    @PutMapping
    public Question updateQuestion(@RequestParam Question q)
    {
        return questionService.updateQuestion(q);
    }
    @DeleteMapping("/del{id}")
    public void deleteQuestion(@PathVariable Long id)
    {
        questionService.deleteQuestion(id);
    }
}
