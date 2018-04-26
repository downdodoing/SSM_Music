package com.cn.hnust.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.CommonMapper;
import com.cn.hnust.pojo.Common;
import com.cn.hnust.service.ICommonService;

@Service("commonService")
public class CommonServiceImp implements ICommonService {

	@Resource
	private CommonMapper commonMapper;

	@Override
	public List<Common> select(String musicName, String musicArtise) {
		return commonMapper.select(musicName, musicArtise);
	}

	@Override
	public int insertCommon(Common common) {
		return commonMapper.insert(common);
	}
	@Override
	public Common selectByPrimaryKey(String commonid) {
		return commonMapper.selectByPrimaryKey(commonid);
	}
	@Override
	public int updateCommon(Common common) {
		return 0;
	}

	@Override
	public int deleteCommon(Integer commonId) {
		return 0;
	}

	@Override
	public int updateCommonPraise(Integer commonId) {
		return 0;
	}

}
