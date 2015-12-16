package com.geihoo.bean;

import android.graphics.Bitmap;
/**
 * 
 * 用户bean
 *
 * @author yyCai
 *
 * 2015年12月16日
 */
public class UserBean {

	/**
	 * 用户头像
	 */
	private Bitmap headImg;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户性别
	 */
	private int sex;
	/**
	 * 用户地址
	 */
	private String area;
	/**
	 * 用户简介
	 */
	private String about;
	
	public Bitmap getHeadImg() {
		return headImg;
	}
	public void setHeadImg(Bitmap headImg) {
		this.headImg = headImg;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
