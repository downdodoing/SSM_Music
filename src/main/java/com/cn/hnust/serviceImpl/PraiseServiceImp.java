package com.cn.hnust.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.PraiseMapper;
import com.cn.hnust.pojo.Praise;
import com.cn.hnust.service.IPraiseService;

@Service("praiseService")
public class PraiseServiceImp implements IPraiseService {

	@Resource
	private PraiseMapper praiseMapper;

	@Override
	public List<Praise> select(int musicID) {
		return praiseMapper.select(musicID);
	}

	@Override
	public List<Praise> selectNum(int musicID) {
		return praiseMapper.selectNum(musicID);
	}

	@Override
	public int insert(Praise praise) {
		return praiseMapper.insert(praise);
	}

}
