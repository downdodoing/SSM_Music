package com.cn.hnust.pojo;

public class Message extends MessageKey {
	private Integer userid;

	private Integer touserid;

	private String time;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getTouserid() {
		return touserid;
	}

	public void setTouserid(Integer touserid) {
		this.touserid = touserid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}