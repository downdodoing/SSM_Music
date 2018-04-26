package com.cn.hnust.json;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.Friend;

public class FriendJson {
	public static Friend JSONToFriend(JSONObject joo) {
		Friend friend = new Friend();

		friend.setUserid(joo.getInteger("userID"));
		friend.setFrienduserid(joo.getInteger("friendUserID"));
		return friend;
	}
}
