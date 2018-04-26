package com.cn.hnust.service;

import com.cn.hnust.pojo.Music;

public interface IMusicService {
	public int insert(Music record);

	public Music selectMusic(String musicName, String musicArtist);
}
