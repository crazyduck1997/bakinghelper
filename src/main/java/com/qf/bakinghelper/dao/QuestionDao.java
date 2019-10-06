package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Question;

import java.util.List;

public interface QuestionDao {

    public Integer addQuestion(Question question);

    public List<Question> findAllQuestions();

    public Integer deleteQuestion(Integer qId);

    public List<Question> findMyQuestions(Integer uId);

    public Integer updateAnswerNums(Question question);

    public Question findQuestionByprimaryKey(Integer qId);


}
