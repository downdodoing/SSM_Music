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
import com.cn.hnust.json.UserJson;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private IUserService userService;

	/**
	 * @param req
	 * @return 2表示账号已经存在
	 */
	@RequestMapping("/register")
	@ResponseBody
	public int register(HttpServletRequest req) {

		String jsonUser = req.getParameter("user");
		try {
			jsonUser = new String(jsonUser.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JSONObject joo = JSON.parseObject(jsonUser);
		User user = UserJson.jsontoUser(joo);

		System.out.println(joo);

		User user1 = userService.selectByPrimaryTelphone(user.getPhonenum());
		if (null != user1) {
			return 2;
		}
		return userService.insert(user);
	}

	/**
	 * @param req
	 * @return
	 */
	@RequestMapping("/updataUser")
	@ResponseBody
	public int updataUser(HttpServletRequest req) {

		String jsonUser = req.getParameter("user");
		try {
			jsonUser = new String(jsonUser.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JSONObject joo = JSON.parseObject(jsonUser);
		User user = UserJson.jsontoUser(joo);

		System.out.println(joo);

		return userService.updateByPrimaryKey(user);
	}

	/**
	 * 
	 * @param req
	 * @return JSONObject中0表示登陆成功，1表示密码错误，2表示用户不存在
	 */
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject login(HttpServletRequest req) {
		String telphone = req.getParameter("telphone");
		String password = req.getParameter("password");
		User user = userService.selectByPrimaryTelphone(telphone);

		JSONObject joo = UserJson.userToJSON(user);
		System.out.println(telphone);
		System.out.println(joo.toJSONString());
		if (null != user) {
			if (password.equals(user.getPassword())) {
				joo.put("code", 0);
			} else {
				joo.put("code", 1);
			}
		} else {
			joo.put("code", 2);
		}
		return joo;
	}

	/**
	 * 
	 * @param req
	 * @return 0表示该用户不存在，1表示修改成功,2表示用戶不存在
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int updatePassword(HttpServletRequest req) {
		String password = req.getParameter("password");
		String phoneNum = req.getParameter("phoneNum");

		System.out.println(password + " " + phoneNum);

		User user = userService.selectByPrimaryTelphone(phoneNum);
		if (null != user) {
			System.out.println(user.toString());
		}
		if (null == user) {
			return 2;
		} else if (user.getPassword().equals(password)) {
			return 1;
		} else {
			user.setPassword(password);
			return userService.updateByPrimaryKey(user);
		}
	}

	/**
	 * 
	 * @param req
	 * @return JSONObject中0表示查找用户失败，1表示查找用户成功
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public JSONObject getUser(HttpServletRequest req) {
		String telphone = req.getParameter("phonenum");
		User user = userService.selectByPrimaryTelphone(telphone);
		System.out.println(telphone);

		JSONObject joo = UserJson.userToJSON(user);
		if (null == user) {
			joo.put("code", 0);
		}
		joo.put("code", 1);
		return joo;
	}

	@RequestMapping("/getFriend")
	@ResponseBody
	public JSONArray getFriend(HttpServletRequest req) {

		String userID = req.getParameter("userID");
		System.out.println(userID);

		List<User> users = userService.selectFriendByUserID(Integer
				.parseInt(userID));

		return UserJson.usersToJSONArray(users);
	}
	@RequestMapping("/getUserByID")
	@ResponseBody
	public JSONObject selectByPrimaryKey(HttpServletRequest req) {

		String userID = req.getParameter("userID");
		System.out.println(userID);

		User user = userService.selectByPrimaryKey(Integer
				.parseInt(userID));

		return UserJson.userToJSON(user);
	}
}
