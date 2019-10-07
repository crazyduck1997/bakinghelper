package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Question;

import java.util.List;
import java.util.Map;

public interface QuestionAndAnswerService {

    public List<Question> findAllQuestions();

    public Map findOneQuestion(Integer qId);


}
