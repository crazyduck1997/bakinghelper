package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AnswerDao;
import com.qf.bakinghelper.dao.QuestionDao;
import com.qf.bakinghelper.entity.Answer;
import com.qf.bakinghelper.entity.Question;
import com.qf.bakinghelper.service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    AnswerDao answerDao;


    /**
     * 查看所有的问题
     * @return
     */
    @Override
    public List<Question> findAllQuestions() {
        List<Question> list = questionDao.findAllQuestions();
        return list;
    }

    /**
     * 查看当前问题所有的回答
     * @param qId
     * @return
     */
    @Override
    public List<Answer> findAnswersByQuestionId(Integer qId) {
        List<Answer> list = answerDao.findAnswersByQuestionId(qId);
        return list;
    }
}
