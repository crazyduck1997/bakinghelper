package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.FootType;
import com.qf.bakinghelper.service.FootTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("具体食品")
@CrossOrigin
@RestController
public class FootTypeController {

    @Autowired
    FootTypeService footTypeService;

    @ApiOperation(value = "根据具体食品的分类查找所有的食品")
    @PostMapping("/footTypeList")
    public JsonBean<List<FootType>> footTypeList(){
        List<FootType> footTypes = footTypeService.footTypeList();
            return new JsonBean(1,footTypes);
    }
}
