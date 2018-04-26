package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Common;

public interface ICommonService {
	public List<Common> select(String musicName, String musicArtise);

	public Common selectByPrimaryKey(String commonid);

	public int insertCommon(Common common);

	public int updateCommon(Common common);

	public int deleteCommon(Integer commonId);

	public int updateCommonPraise(Integer commonId);
}
