package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Praise;

public interface IPraiseService {
	public List<Praise> select(int musicID);

	public List<Praise> selectNum(int musicID);

	public int insert(Praise praise);
}
