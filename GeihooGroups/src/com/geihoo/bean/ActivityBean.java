package com.geihoo.bean;

import android.graphics.Bitmap;

/**
 * 
 * 活动实体类
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class ActivityBean {
	private Bitmap image;//活动图片
	private String title;//活动主题
	private String date;//活动日期
	private String dt;//时间标志，暂时存储
	private String publishDate;//活动发布日期
	private String place;//活动地点
	private String organizer;//活动组织者
	private int num;//活动参加人数
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
