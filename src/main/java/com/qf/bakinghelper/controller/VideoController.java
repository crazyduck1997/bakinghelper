package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

}