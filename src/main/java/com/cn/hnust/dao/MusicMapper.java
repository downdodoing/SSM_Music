package com.cn.hnust.dao;

import com.cn.hnust.pojo.Music;

public interface MusicMapper {
	int deleteByPrimaryKey(Integer musicid);

	int insert(Music record);

	int insertSelective(Music record);

	Music selectByNameAndArtist(String name, String artist);

	Music selectByPrimaryKey(Integer musicid);

	int updateByPrimaryKeySelective(Music record);

	int updateByPrimaryKey(Music record);
}