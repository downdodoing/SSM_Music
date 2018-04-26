package com.cn.hnust.dao;

import com.cn.hnust.pojo.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}