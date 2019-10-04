package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.FootType;
import com.qf.bakinghelper.entity.Video;
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

    @ApiOperation(value = "食谱分类中根据类型查找名字中含有此类型的视频")
    @PostMapping("/findVideo")
    public JsonBean<List<Video>> findVideo(String typeName){
        List<Video> videos = footTypeService.findFootType(typeName);
        return new JsonBean<>(1,videos);
    }


    @ApiOperation(value = "查询食谱分类中的推荐")
    @PostMapping("/footList")
    public JsonBean<List<FootType>> footList(){
        List<FootType> footTypes = footTypeService.footList();
        return new JsonBean<>(1,footTypes);
    }
}
