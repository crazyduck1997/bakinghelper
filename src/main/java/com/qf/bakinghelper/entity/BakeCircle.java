package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
@ApiModel(value = "烘焙圈")
@Data
public class BakeCircle {
    private Integer circleId;

    private Integer userId;

    private Date time;

    private String description;

    private String resources;

    private String praise;

    private Integer foodId;

    private Integer commentId;

    private User user;

    private Comment comment;

    private FootType footType;



}