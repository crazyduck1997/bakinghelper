package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.Utils.JsonUtils;
import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Detail;
import com.qf.bakinghelper.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api("面包种类")
@CrossOrigin
@RestController
public class DetailController {


    @Autowired
    DetailService detailService;


    @ApiOperation(value = "在食谱分类中根据食品的类型查询具体的分类")
    @PostMapping("/detailList")
    public JsonBean<List<Detail>>  detailList(){
        List<Detail> details = detailService.detailList();
//        return JsonUtils.createJsonBean(1,details);
        return new JsonBean(1,details);
    }
}
