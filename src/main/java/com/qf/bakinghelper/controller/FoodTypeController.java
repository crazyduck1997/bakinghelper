package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Detail;
import com.qf.bakinghelper.entity.FoodType;
import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.FoodTypeService;
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
public class FoodTypeController {

    @Autowired
    FoodTypeService foodTypeService;

    @ApiOperation(value = "食谱分类中通过食品来查收具体的食品类型和具体的食品")
    @PostMapping("/foodTypeList.do")
    public JsonBean<Detail> foodTypeList(Integer typeId){
        List<Detail> detailsList = foodTypeService.foodTypeList(typeId);
        return new JsonBean(1, detailsList);
    }

    @ApiOperation(value = "食谱分类中根据类型查找名字中含有此类型的视频")
    @PostMapping("/findVideo.do")
    public JsonBean<List<Video>> findVideo(String typeName){
        List<Video> videos = foodTypeService.findFoodType(typeName);
        return new JsonBean<>(1,videos);
    }


    @ApiOperation(value = "查询食谱分类中热门分类中的查询")
    @PostMapping("/foodList.do")
    public JsonBean<List<FoodType>> foodList(){
        List<FoodType> foodTypes = foodTypeService.foodList();
        return new JsonBean<>(1, foodTypes);
    }
}
