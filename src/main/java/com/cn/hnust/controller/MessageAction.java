package com.cn.hnust.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.json.MessageJson;
import com.cn.hnust.pojo.Message;
import com.cn.hnust.service.IMessageService;

@Controller
@RequestMapping("/message")
public class MessageAction {
	@Resource
	private IMessageService messageService;

	@RequestMapping("/insert")
	@ResponseBody
	public int insert(HttpServletRequest req) {

		String messageJson = req.getParameter("message");
		try {
			messageJson = new String(messageJson.getBytes("ISO-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(messageJson);
		JSONObject joo = JSONObject.parseObject(messageJson);
		
		return messageService.insert(MessageJson.jsonToMessage(joo));
	}

	@RequestMapping("/select")
	@ResponseBody
	public JSONArray select(HttpServletRequest req) {

		String userID = req.getParameter("userID");
		String toUserID = req.getParameter("toUserID");
		System.out.println(userID + " " + toUserID);
		List<Message> message = messageService.select(Integer.parseInt(userID),
				Integer.parseInt(toUserID));
		List<Message> reply = messageService.select(Integer.parseInt(toUserID),
				Integer.parseInt(userID));

		List<Message> messages = mergeMessageAndReply(message, reply);
		if (null != message && null != reply) {
			JSONArray jaa = MessageJson.messagesToJSONArray(messages);
			System.out.println(jaa.toJSONString());
			return jaa;
		}
		return null;
	}

	public List<Message> mergeMessageAndReply(List<Message> message,
			List<Message> reply) {
		List<Message> messages = new ArrayList<Message>();

		int messageLength = message.size();
		int replyLength = reply.size();

		int messageCount = 0;
		int replyCount = 0;

		while (messageCount < messageLength) {
			messages.add(message.get(messageCount++));
		}

		while (replyCount < replyLength) {
			messages.add(reply.get(replyCount++));
		}
		sort(messages);
		return messages;
	}

	public void sort(List<Message> messages) {
		Message temp = null;
		int size = messages.size();
		for (int i = 0; i < size - 1; i++) {
			for (int j = size - 1; j > i; j--) {
				if (Long.parseLong(messages.get(j - 1).getTime()) > Long
						.parseLong(messages.get(j).getTime())) {
					temp = messages.get(j - 1);
					messages.set(j - 1, messages.get(j));
					messages.set(j, temp);
				}
			}
		}
	}
}
