package com.cn.hnust.service;

import com.cn.hnust.pojo.Friend;

public interface IFriendService {
	public int insertFriend(Friend friend);

	public Friend selectFriendByID(int userID, int friendUserID);

	public int delete(int userID, int friendUserID);
}
