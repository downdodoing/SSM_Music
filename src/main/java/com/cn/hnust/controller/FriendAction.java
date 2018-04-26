package com.cn.hnust.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.json.FriendJson;
import com.cn.hnust.pojo.Friend;
import com.cn.hnust.service.IFriendService;

@Controller
@RequestMapping("/friend")
public class FriendAction {

	@Resource
	private IFriendService friendService;

	/**
	 * 
	 * @param req
	 * @return 2表示用户已经关注了该用户，1表示关注成功
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int inserFriend(HttpServletRequest req) {

		String jsonFriend = req.getParameter("friend");
		JSONObject joo = JSON.parseObject(jsonFriend);
		Friend friend = FriendJson.JSONToFriend(joo);

		Friend friend2 = friendService.selectFriendByID(friend.getUserid(),
				friend.getFrienduserid());
		if (null != friend2) {
			return 3;
		}
		return friendService.insertFriend(friend);
	};

	@RequestMapping("/delete")
	@ResponseBody
	public int delete(HttpServletRequest req) {

		String userID = req.getParameter("userID");
		String friendUserID = req.getParameter("friendUserID");

		return friendService.delete(Integer.parseInt(userID),
				Integer.parseInt(friendUserID));
	};
}
