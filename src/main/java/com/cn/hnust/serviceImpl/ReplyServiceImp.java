package com.cn.hnust.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.ReplyMapper;
import com.cn.hnust.service.IReplyService;

@Service("replyService")
public class ReplyServiceImp implements IReplyService {
	@Resource
	private ReplyMapper replyDao;

}
