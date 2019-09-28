package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "账户id")
    private Integer accountId;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "头像链接")
    private String headImg;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "介绍")
    private String introduce;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "收货地址")
    private String address;
    @ApiModelProperty(value = "帮贡")
    private Integer banggong;
    @ApiModelProperty(value = "关注人数")
    private Integer watchNum;
    @ApiModelProperty(value = "粉丝数")
    private Integer fansNum;
    @ApiModelProperty(value = "勋章")
    private Integer medal;
    @ApiModelProperty(value = "等级")
    private String grade;


    }