package com.cn.hnust.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.service.IReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyAction {
	@Resource
	private IReplyService replyService;

}
