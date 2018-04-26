package com.cn.hnust.dao;

import com.cn.hnust.pojo.Friend;

public interface FriendMapper {
	int deleteByPrimaryKey(Integer friendid);

	int delete(Integer userid, Integer frienduserid);

	int insert(Friend record);

	int insertSelective(Friend record);

	Friend selectByPrimaryKey(Integer friendid);

	Friend selectFriendByID(int userid, int frienduserid);

	int updateByPrimaryKeySelective(Friend record);

	int updateByPrimaryKey(Friend record);
}