package com.cn.hnust.json;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.Message;

public class MessageJson {
	public static JSONArray messagesToJSONArray(List<Message> messages) {
		JSONArray jaa = new JSONArray();

		for (int i = 0; i < messages.size(); i++) {
			JSONObject joo = new JSONObject();
			Message message = messages.get(i);

			joo.put("messageID", message.getMessageid());
			joo.put("userID", message.getUserid());
			joo.put("toUserID", message.getTouserid());
			joo.put("message", message.getMessage());
			joo.put("time", message.getTime());

			jaa.add(joo);
		}

		return jaa;
	}

	public static Message jsonToMessage(JSONObject joo) {

		Message message = new Message();
		
		message.setMessage(joo.getString("message"));
		message.setTime(joo.getString("time"));
		message.setTouserid(joo.getInteger("toUserID"));
		message.setUserid(joo.getInteger("userID"));

		return message;
	}
}
