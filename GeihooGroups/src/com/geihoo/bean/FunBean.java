package com.geihoo.bean;

import android.graphics.Bitmap;

/**
 * 
 * 族族市场的功能
 *
 * @author yy_cai
 *
 * 2015年12月15日
 */
public class FunBean {

	private Bitmap image;
	private String name;
	private boolean add;//是否添加到生活栏目，默认false
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
	public boolean isAdd() {
		return add;
	}
	public void setAdd(boolean add) {
		this.add = add;
	}
	
}
