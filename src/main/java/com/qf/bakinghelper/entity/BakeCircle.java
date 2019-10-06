package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel(value = "烘焙圈")
@Data
public class BakeCircle {
    private Integer circleId;

    private String circleName;

    private Integer userId;

    private Date time;

    private String description;

    private String resources;

    private String praise;

    private Integer topicId;

    private Integer commentNum;

    private User user;

    private List<Comment> comments;

    private Topic topic;




}