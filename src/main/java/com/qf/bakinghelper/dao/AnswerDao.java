package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Answer;

import java.util.List;

public interface AnswerDao {

    public Integer addAnswer(Answer answer);

    public Integer updatePraiseNum(Answer answer);

    public List<Answer> findAnswersByQuestionId(Integer qId);

    public Answer findAnswerByByPrimaryKey(Integer aId);


}
