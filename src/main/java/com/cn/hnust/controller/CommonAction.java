package com.cn.hnust.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.json.CommonJson;
import com.cn.hnust.pojo.Common;
import com.cn.hnust.pojo.Music;
import com.cn.hnust.pojo.Praise;
import com.cn.hnust.service.ICommonService;
import com.cn.hnust.service.IMusicService;
import com.cn.hnust.service.IPraiseService;

@Controller
@RequestMapping("/common")
public class CommonAction {

	@Resource
	private ICommonService commonService;
	@Resource
	private IMusicService musicService;
	@Resource
	private IPraiseService praiseService;

	@RequestMapping("/insertcommon")
	@ResponseBody
	public int insertCommon(HttpServletRequest req) {

		return commonService.insertCommon(null);
	}

	@RequestMapping("/select")
	@ResponseBody
	public JSONArray select(HttpServletRequest req) {
		String musicName = req.getParameter("musicName");
		try {
			musicName = new String(musicName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String musicArtise = req.getParameter("musicArtist");
		try {
			musicArtise = new String(musicArtise.getBytes("ISO-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println(musicName + " " + musicArtise);

		List<Common> datas = commonService.select(musicName, musicArtise);
		if (datas.size() > 0) {

			List<Praise> praiseNum = praiseService.selectNum(datas.get(0)
					.getMusicid());
			setPraiseNum(datas, praiseNum);
		}
		
		return CommonJson.listToJSONArray(datas);
	}

	private void setPraiseNum(List<Common> datas, List<Praise> praiseNum) {
		for (int i = 0; i < datas.size(); i++) {
			Common common = datas.get(i);
			common.setPraisenum(0);
			for (int j = 0; j < praiseNum.size(); j++) {
				Praise praise = praiseNum.get(j);
				if (common.getCommonid().equals(praise.getCommonid())) {
					common.setPraisenum(praise.getPraisenum());
				}
			}
		}
	}

	@RequestMapping("/insert")
	@ResponseBody
	public JSONObject insert(HttpServletRequest req) {

		String jsonCommon = req.getParameter("common");
		try {
			jsonCommon = new String(jsonCommon.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JSONObject joo = JSON.parseObject(jsonCommon);
		Common common = CommonJson.jsonToCommon(joo);
		int musicID = getMusicID(common.getMusicname(), common.getMusicartist());
		common.setMusicid(musicID);
		commonService.insertCommon(common);
		Common common1 = commonService.selectByPrimaryKey(common.getCommonid());
		
		return CommonJson.commonToJSONObject(common1);
	}

	public int getMusicID(String musicName, String musicArtist) {
		Music music = musicService.selectMusic(musicName, musicArtist);
		if (null == music) {
			Music music1 = new Music();
			music1.setMusicname(musicName);
			music1.setMusicartist(musicArtist);

			musicService.insert(music1);
		}

		return musicService.selectMusic(musicName, musicArtist).getMusicid();
	}

	@RequestMapping("/updateCommon")
	@ResponseBody
	public int updateCommon(HttpServletRequest req) {
		return 0;
	}

	@RequestMapping("/updateCommonPraise")
	@ResponseBody
	public int updateCommonPraise(HttpServletRequest req) {
		return 0;
	}

}
