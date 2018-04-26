package com.cn.hnust.json;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.Praise;

public class PraiseJson {
	public static JSONArray praiseToJsonArray(List<Praise> praises) {
		JSONArray jaa = new JSONArray();

		for (int i = 0; i < praises.size(); i++) {

			Praise praise = praises.get(i);
			JSONObject joo = new JSONObject();

			joo.put("praiseID", praise.getPraiseid());
			joo.put("userID", praise.getUserid());
			joo.put("commonID", praise.getCommonid());
			joo.put("musicID", praise.getMusicid());

			jaa.add(joo);
		}

		return jaa;
	}

	public static Praise jsonToPraise(JSONObject joo) {
		Praise praise = new Praise();

		praise.setUserid(joo.getInteger("userID"));
		praise.setCommonid(joo.getString(("commonID")));
		praise.setMusicid(joo.getInteger("musicID"));

		return praise;
	}
}
