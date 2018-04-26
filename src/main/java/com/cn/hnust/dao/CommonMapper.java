package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Common;

public interface CommonMapper {
    int deleteByPrimaryKey(Integer commonid);

    int insert(Common record);

    int insertSelective(Common record);
    
    List<Common> select(String musicname,String musicartise);
    
    Common selectByPrimaryKey(String commonid);

    int updateByPrimaryKeySelective(Common record);

    int updateByPrimaryKey(Common record);
}