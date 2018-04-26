package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Praise;

public interface PraiseMapper {
	int deleteByPrimaryKey(Integer praiseid);

	int insert(Praise record);

	int insertSelective(Praise record);

	Praise selectByPrimaryKey(Integer praiseid);

	List<Praise> select(Integer musicid);

	List<Praise> selectNum(Integer musicid);

	int updateByPrimaryKeySelective(Praise record);

	int updateByPrimaryKey(Praise record);
}