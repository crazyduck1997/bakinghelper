package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Answer;
import com.qf.bakinghelper.entity.Question;
import com.qf.bakinghelper.service.QuestionAndAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "问答", tags = "问答")
@CrossOrigin
@RestController
public class QuestionAndAnswerController {


    @Autowired
    QuestionAndAnswerService questionAndAnswerService;


    @ApiOperation(value = "查看所有的问题")
    @PostMapping("/findAllQuestions.do")
    public JsonBean findAllQuestions(){
        List<Question> list = questionAndAnswerService.findAllQuestions();
        return new JsonBean(1,list);
    }
    @ApiOperation(value = "查看当前问题以及当前问题的所有回答",notes = "返回map集合，map中question对应当前问题，answers对应当前问题的所有回答")
    @PostMapping("/findOneQuestion.do")
    public JsonBean findOneQuestion(Integer qId){
        Map map = questionAndAnswerService.findOneQuestion(qId);
        return new JsonBean(1,map);
    }


}
