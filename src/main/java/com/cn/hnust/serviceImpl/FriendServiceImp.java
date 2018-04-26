package com.cn.hnust.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.FriendMapper;
import com.cn.hnust.dao.UserDao;
import com.cn.hnust.pojo.Friend;
import com.cn.hnust.service.IFriendService;

@Service("friendService")
public class FriendServiceImp implements IFriendService {

	@Resource
	private FriendMapper friendMapper;

	@Override
	public int insertFriend(Friend friend) {
		return friendMapper.insert(friend);
	}

	@Override
	public Friend selectFriendByID(int userID, int friendUserID) {
		return friendMapper.selectFriendByID(userID, friendUserID);
	}
	
	@Override
	public int delete(int userID, int friendUserID) {
		return friendMapper.delete(userID, friendUserID);
	}
}
