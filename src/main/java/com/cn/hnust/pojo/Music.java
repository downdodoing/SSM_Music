package com.cn.hnust.pojo;

public class Music {
    private Integer musicid;

    private String musicname;

    private String musicartist;

    public Integer getMusicid() {
        return musicid;
    }

    public void setMusicid(Integer musicid) {
        this.musicid = musicid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname == null ? null : musicname.trim();
    }

    public String getMusicartist() {
        return musicartist;
    }

    public void setMusicartist(String musicartist) {
        this.musicartist = musicartist == null ? null : musicartist.trim();
    }
}