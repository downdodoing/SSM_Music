package com.cn.hnust.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.Music;
import com.cn.hnust.service.IMusicService;

@Controller
@RequestMapping("/music")
public class MusicAction {
	@Resource
	private IMusicService musicService;

	@RequestMapping("/insert")
	@ResponseBody
	public int insertMusic() {
		return musicService.insert(null);
	}

	@RequestMapping("/selectMusic")
	@ResponseBody
	public Music selectMusic() {
		return this.musicService.selectMusic("", "");
	}
}
