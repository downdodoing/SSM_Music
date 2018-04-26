package com.cn.hnust.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.MusicMapper;
import com.cn.hnust.pojo.Music;
import com.cn.hnust.service.IMusicService;

@Service("musicService")
public class MusicServiceImp implements IMusicService {
	@Resource
	private MusicMapper musicMapper;

	@Override
	public int insert(Music record) {
		return musicMapper.insert(record);
	}

	@Override
	public Music selectMusic(String musicName, String musicArtist) {
		return musicMapper.selectByNameAndArtist(musicName, musicArtist);
	}

}
