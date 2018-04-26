package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Message;
import com.cn.hnust.pojo.MessageKey;

public interface MessageMapper {
    int deleteByPrimaryKey(MessageKey key);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(MessageKey key);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> select(int userid,int touserid);
}