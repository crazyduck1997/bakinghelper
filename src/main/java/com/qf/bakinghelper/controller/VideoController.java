package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("视频")
@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @ApiOperation(value = "获取推荐视频集合")
    @PostMapping("/findHotVideo.do")
    public JsonBean findAllHotVideo(){
        List<Video> hotVideoList = videoService.findAllHotVideo();
        return new JsonBean(1,hotVideoList);
    }

    @ApiOperation(value = "查询所有的专栏的种类")
    @PostMapping("/findAllFeature.do")
    public JsonBean findAllFeature(){
        List<Feature> featureList = videoService.findAllFeature();
        return new JsonBean(1,featureList);
    }


}
