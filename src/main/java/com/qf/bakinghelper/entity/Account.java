package com.qf.bakinghelper.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "账户表")
@Data
public class Account {
    @ApiModelProperty(value = "账户id")
    private Integer accountId;
    @ApiModelProperty(value = "手机号")
    private Integer phone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "qq")
    private Integer qq;
    @ApiModelProperty(value = "微信")
    private String wechat;



}
