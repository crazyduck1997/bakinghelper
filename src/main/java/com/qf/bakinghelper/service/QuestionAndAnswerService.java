package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Answer;
import com.qf.bakinghelper.entity.Question;

import java.util.List;

public interface QuestionAndAnswerService {

    public List<Question> findAllQuestions();

    public List<Answer> findAnswersByQuestionId(Integer qId);


}
