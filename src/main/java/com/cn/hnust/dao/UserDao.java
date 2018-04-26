package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.User;

public interface UserDao {
	int deleteByPrimaryKey(Integer userid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userid);

	List<User> selectFriendByUserID(int userid);

	int updateByPrimaryKeySelectivsse(User record);

	int updateByPrimaryKey(User record);

	int updateByPrimaryKeySelective(User srecord);

	List<User> selectAll();

	User selectByPrimaryTelphone(String telphone);
}