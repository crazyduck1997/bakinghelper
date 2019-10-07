package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.CollectVideos;

import java.util.ArrayList;

public interface CollectVideosDao {

    public void insertCollectVideo(CollectVideos collectVideos);

    public void deleteCollectVideo(Integer uId, ArrayList<Integer> vIds);

}
