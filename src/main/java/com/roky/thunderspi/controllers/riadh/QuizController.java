package com.roky.thunderspi.controllers.riadh;


import com.roky.thunderspi.entities.Quiz;
import com.roky.thunderspi.services.riadh.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final IQuizService quizService;

    //TODO getAll

    @GetMapping("/{id}")
    public Quiz getQuiz(Long id)
    {
        return quizService.getQuizById(id);
    }

    @PostMapping
    public Quiz addQuiz(@RequestParam Quiz q)
    {
        return quizService.addQuiz(q);
    }

    @PutMapping
    public Quiz updateQuiz(@RequestParam Quiz q)
    {
        return quizService.editQuiz(q);
    }

    @DeleteMapping("/del{id}")
    public void deleteQuiz(@PathVariable Long id)
    {
        quizService.deleteQuiz(id);
    }

}
