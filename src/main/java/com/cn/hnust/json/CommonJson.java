package com.cn.hnust.json;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.Common;

public class CommonJson {
	public static JSONArray listToJSONArray(List<Common> datas) {
		JSONArray jaaa = new JSONArray();

		for (int i = 0; i < datas.size(); i++) {
			JSONObject joo = new JSONObject();
			Common common = datas.get(i);
			joo.put("commonID", common.getCommonid());
			joo.put("content", common.getContent());
			joo.put("praiseNum", common.getPraisenum());
			joo.put("userID", common.getUserid());
			joo.put("musicID", common.getMusicid());
			joo.put("username", common.getUsername());
			joo.put("musicName", common.getMusicname());
			joo.put("musicArtist", common.getMusicartist());
			joo.put("time", common.getTime());
			jaaa.add(joo);
		}

		return jaaa;
	}

	public static JSONObject commonToJSONObject(Common common) {
		JSONObject joo = new JSONObject();
		
		joo.put("commonID", common.getCommonid());
		joo.put("content", common.getContent());
		joo.put("praiseNum", common.getPraisenum());
		joo.put("userID", common.getUserid());
		joo.put("musicID", common.getMusicid());
		joo.put("username", common.getUsername());
		joo.put("musicName", common.getMusicname());
		joo.put("musicArtist", common.getMusicartist());
		joo.put("time", common.getTime());

		return joo;
	}

	public static Common jsonToCommon(JSONObject joo) {
		
		Common common = new Common();
		System.out.println(joo.getString("commonID"));
		common.setCommonid(joo.getString("commonID"));
		common.setContent(joo.getString("content"));
		common.setPraisenum(Integer.parseInt(joo.getString("praiseNum")));
		common.setUserid(Integer.parseInt(joo.getString("userID")));
		common.setMusicid(Integer.parseInt(joo.getString("musicID")));
		common.setUsername(joo.getString("username"));
		common.setMusicname(joo.getString("musicName"));
		common.setMusicartist(joo.getString("musicArtist"));
		common.setTime(joo.getString("time"));

		return common;
	}
}
