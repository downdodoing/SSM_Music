package com.cn.hnust.json;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.User;

public class UserJson {

	public static JSONObject userToJSON(User user) {
		JSONObject joo = new JSONObject();
		if (null != user) {
			joo.put("userID", user.getUserid());
			joo.put("userName", user.getUsername());
			joo.put("password", user.getPassword());
			joo.put("sex", user.getSex());
			joo.put("age", user.getAge());
			joo.put("phoneNum", user.getPhonenum());
			joo.put("birthday", user.getBirthday());
			joo.put("area", user.getArea());
			joo.put("signature", user.getSignature());
			joo.put("isOnLine", user.getIsonline());
		}

		return joo;
	}

	public static JSONArray usersToJSONArray(List<User> users) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < users.size(); i++) {
			jsonArray.add(userToJSON(users.get(i)));
		}

		return jsonArray;
	}

	public static User jsontoUser(JSONObject joo) {

		User user = new User();
		if (null != joo.getInteger("age")) {
			user.setAge(joo.getInteger("age"));
		} else {
			user.setAge(0);
		}

		if (null != joo.getString("sex")) {
			user.setSex(joo.getString("sex"));
		} else {
			user.setSex("");
		}

		if (null != joo.getString("area")) {
			user.setArea(joo.getString("area"));
		} else {
			user.setArea("");
		}

		if (null != joo.getString("password")) {
			user.setPassword(joo.getString("password"));
		} else {
			user.setPassword("12345678");
		}

		if (null != joo.getString("phoneNum")) {
			user.setPhonenum(joo.getString("phoneNum"));
		} else {
			user.setPhonenum("");
		}

		if (null != joo.getString("signature")) {
			user.setSignature(joo.getString("signature"));
		} else {
			user.setSignature("编辑个性签名");
		}
		if (null != joo.getString("isOnline")) {
			user.setIsonline(Integer.parseInt(joo.getString("isOnline")));
		} else {
			user.setIsonline(0);
		}
		if (null != joo.getString("birthday")) {
			user.setBirthday(joo.getString("birthday"));
		} else {
			user.setBirthday("");
		}
		if (null != joo.getString("userName")) {
			user.setUsername(joo.getString("userName"));
		} else {
			user.setUsername("");
		}
		return user;
	}

}
