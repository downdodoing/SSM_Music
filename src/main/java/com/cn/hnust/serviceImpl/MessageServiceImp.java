package com.cn.hnust.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.MessageMapper;
import com.cn.hnust.pojo.Message;
import com.cn.hnust.service.IMessageService;

@Service("messageService")
public class MessageServiceImp implements IMessageService {
	@Resource
	private MessageMapper messageDao;

	@Override
	public List<Message> select(int userID, int toUserID) {
		return messageDao.select(userID, toUserID);
	}

	@Override
	public int insert(Message msg) {
		return messageDao.insert(msg);
	}
}
