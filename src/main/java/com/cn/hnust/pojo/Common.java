package com.cn.hnust.pojo;

public class Common {
	private String commonid;

	private String content;

	private Integer praisenum;

	private Integer userid;

	private Integer musicid;

	private String username;

	private String musicname;

	private String musicartist;
	
	private String time;
	
	public String getCommonid() {
		return commonid;
	}

	public void setCommonid(String commonid) {
		this.commonid = commonid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getPraisenum() {
		return praisenum;
	}

	public void setPraisenum(Integer praisenum) {
		this.praisenum = praisenum;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getMusicid() {
		return musicid;
	}

	public void setMusicid(Integer musicid) {
		this.musicid = musicid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMusicname() {
		return musicname;
	}

	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}

	public String getMusicartist() {
		return musicartist;
	}

	public void setMusicartist(String musicartist) {
		this.musicartist = musicartist;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}