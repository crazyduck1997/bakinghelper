package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.BakeCircle;
import com.qf.bakinghelper.service.BakeCircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Api(value = "烘焙圈")
@RestController
@RequestMapping("/bakecircle")
public class BakeCircleController {

    @Autowired
    BakeCircleService bakeCircleService;

    @ApiOperation(value = "",notes = "列出烘焙圈动态信息")
    @PostMapping("/list.do")
    public JsonBean list(){
        List<BakeCircle> bakeCircles = bakeCircleService.selectAll();
        return new JsonBean(1,bakeCircles);
    }
    @ApiOperation(value = "烘焙圈对象",notes = "发表烘焙圈信息")
    @PostMapping("/add.do")
    public JsonBean add(BakeCircle bakeCircle, MultipartFile file,String token){
        if (file.isEmpty()) {
            return new JsonBean(0,"请选择文件");
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D://test/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            bakeCircle.setResources(fileName);
            bakeCircleService.insert(bakeCircle,token);
            return new JsonBean(1,"上传成功");
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new JsonBean(0,"上传失败");
    }
}
