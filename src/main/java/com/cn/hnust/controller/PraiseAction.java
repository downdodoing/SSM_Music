package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.json.PraiseJson;
import com.cn.hnust.pojo.Praise;
import com.cn.hnust.service.IPraiseService;

@Controller
@RequestMapping("/praise")
public class PraiseAction {
	@Resource
	private IPraiseService praiseService;

	@RequestMapping("/select")
	@ResponseBody
	public JSONArray select(HttpServletRequest req) {

		String musicID = req.getParameter("musicID");

		List<Praise> praise = praiseService.select(Integer.parseInt(musicID));

		if (null != praise) {
			return PraiseJson.praiseToJsonArray(praise);
		}
		
		return null;
	}

	@RequestMapping("/insert")
	@ResponseBody
	public int insert(HttpServletRequest req) {

		String jsonPraise = req.getParameter("praise");
		JSONObject joo = JSON.parseObject(jsonPraise);
		System.out.println(joo);
		
		return praiseService.insert(PraiseJson.jsonToPraise(joo));
	}
}
