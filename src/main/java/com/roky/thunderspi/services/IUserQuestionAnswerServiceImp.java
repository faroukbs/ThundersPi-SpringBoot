package com.roky.thunderspi.services;


import com.roky.thunderspi.entities.QuestionAnswer;

import java.util.Set;

public class IUserQuestionAnswerServiceImp implements IUserQuestionAnswerService {
    @Override
    public QuestionAnswer addQuestionAnswer(QuestionAnswer q) {
        return null;
    }

    @Override
    public QuestionAnswer updateQuestion(QuestionAnswer q) {
        return null;
    }

    @Override
    public Set<QuestionAnswer> findAll() {
        return null;
    }

    @Override
    public Set<QuestionAnswer> findAllbyQuestion(Long questionId) {
        return null;
    }

    @Override
    public Set<QuestionAnswer> findAllbyQuiz(Long quizId) {
        return null;
    }

    @Override
    public Set<QuestionAnswer> findAllbyNumberOfTakes() {
        return null;
    }
}
