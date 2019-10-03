package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Author;
import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.AuthorService;
import com.qf.bakinghelper.service.FeatureService;
import com.qf.bakinghelper.service.TypeService;
import com.qf.bakinghelper.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("视频")
@CrossOrigin
@RestController
public class VideoController {

    @Autowired
    VideoService videoService;
    @Autowired
    FeatureService featureService;
    @Autowired
    TypeService typeService;
    @Autowired
    AuthorService authorService;

    @ApiOperation(value = "获取推荐视频集合")
    @PostMapping("/findHotVideo.do")
    public JsonBean findAllHotVideo(){
        List<Video> hotVideoList = videoService.findAllHotVideo();
        return new JsonBean(1,hotVideoList);
    }

    @ApiOperation(value = "查询所有的专栏对应的视频")
    @PostMapping("/findAllFeature.do")
    public JsonBean findAllFeature(){
        List<Feature> featureList = featureService.findAllFeature();
        return new JsonBean(1,featureList);
    }
    @ApiOperation(value = "查询单个专栏对应的视频")
    @PostMapping("/oneFeatureVideoList.do")
    public JsonBean oneFeatureVideoList(Integer featureId){
        List<Video> oneFeatureList = featureService.findOneFeatureAllVideoByFeatureId(featureId);
        return new JsonBean(1,oneFeatureList);
    }
    @ApiOperation(value = "查询所有视频对应的食品的类别(蛋糕，甜点等)")
    @PostMapping("/findAllTypeList.do")
    public JsonBean findAllGoodsType(){
        List<Type> typeList = typeService.selectAll();
        return new JsonBean(1,typeList);
    }
    @ApiOperation(value = "查询单个食品的类别对应的视频")
    @PostMapping("/findOneTypeVideos.do")
    public JsonBean findOneType(Integer typeId){
        List<Video> oneTypeVideos = typeService.findOneTypeVideosByTypeId(typeId);
        return new JsonBean(1,oneTypeVideos);
    }
    @ApiOperation(value = "根据单个视频的id查询该视频的详细信息")
    @PostMapping("/findOneVideoMessageById")
    public JsonBean findOneVideoMessage(Integer videoId){

        Video oneVideoMessage = videoService.findOneVideoMessageByVideoId(videoId);
        return new JsonBean(1,oneVideoMessage);
    }
    @ApiOperation(value = "查询相关导师的其它视频")
    @PostMapping("/authorVideos.do")
    public JsonBean findOneAuthorVideos(Integer authorId){
        Author author = authorService.findAuthorById(authorId);
        return new JsonBean(1,author);
    }
}
