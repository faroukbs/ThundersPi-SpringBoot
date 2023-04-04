package com.roky.thunderspi.services;


import com.roky.thunderspi.entities.QuestionAnswer;

import java.util.Set;

public interface IUserQuestionAnswerService {
    public QuestionAnswer addQuestionAnswer(QuestionAnswer q);
    public QuestionAnswer updateQuestion(QuestionAnswer q);
    public Set<QuestionAnswer>  findAll();

    public Set<QuestionAnswer> findAllbyQuestion(Long questionId);
    public Set<QuestionAnswer> findAllbyQuiz(Long quizId);
    public Set<QuestionAnswer> findAllbyNumberOfTakes();
}
