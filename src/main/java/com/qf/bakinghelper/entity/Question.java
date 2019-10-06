package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Integer qId;
    private String qContent;
    private Integer uId;
    private Integer rId;
    private Date qTime;
    private String qImg;
    private Integer answerNum;

    private Recipe recipe;

    private List<Answer> answers;

}
