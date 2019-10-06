package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private Integer aId;
    private Integer uId;
    private String aContent;
    private Integer qId;
    private Integer aPraise;
    private Date aDate;

    private User user;

}
