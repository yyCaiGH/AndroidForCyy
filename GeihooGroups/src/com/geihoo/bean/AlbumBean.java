package com.geihoo.bean;

import android.graphics.Bitmap;

/**
 * 
 * 相册实体
 *
 * @author yy_cai
 *
 * 2015年11月26日
 */
public class AlbumBean {
	
	private Bitmap image;//相册封面
	private String name;//相册名称
	private String describe;//相册描述
	private String createDate;//相册创建日期
	private int num;//相册照片数量
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
