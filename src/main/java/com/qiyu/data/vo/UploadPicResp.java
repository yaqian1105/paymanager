package com.qiyu.data.vo;

import java.io.Serializable;

public class UploadPicResp implements Serializable {
	private long fsize;
	private String key;
	private String hash;
	private int width;
	private int height;
	private String url;
	private String state="SUCCESS";  
	
	//for old vesrion
	public String getPath(){
		return key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String resUrl) {
		this.url = resUrl;
	}
	public long getFsize() {
		return fsize;
	}
	public void setFsize(long fsize) {
		this.fsize = fsize;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "UploadPicResp [fsize=" + fsize + ", key=" + key + ", hash=" + hash + ", width=" + width + ", height="
				+ height + ", resUrl=" + url + "]";
	}
	
	
}
