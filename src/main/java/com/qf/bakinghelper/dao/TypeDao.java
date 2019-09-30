package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Type;
import java.util.List;

public interface TypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    Type selectByPrimaryKey(Integer typeId);

    List<Type> selectAll();

    int updateByPrimaryKey(Type record);

}