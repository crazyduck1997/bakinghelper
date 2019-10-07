package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.CollectVideos;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CollectVideosDao {

    public void insertCollectVideo(CollectVideos collectVideos);

    public void deleteCollectVideo(@Param(value = "uId") Integer uId,@Param(value = "list") List<Integer> vIds);

}
