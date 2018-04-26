package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Message;

public interface IMessageService {
	public List<Message> select(int userID, int toUserID);
	
	public int insert(Message msg);
}
