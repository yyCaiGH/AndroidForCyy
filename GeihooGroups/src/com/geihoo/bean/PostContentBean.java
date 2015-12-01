package com.geihoo.bean;

/**
 * 用来记录贴子内容的bean
 * @author hjs
 *
 */
public class PostContentBean {
	
	//头像URL
	private int headImgId;
	//发帖人姓名
	private String name;
	//发帖时间
	private String time;
	//帖子内容
	private String content;
	//帖子中的图片1
	private int imageId1;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHeadImgId() {
		return headImgId;
	}
	public void setHeadImgId(int headImgId) {
		this.headImgId = headImgId;
	}
	public int getImageId1() {
		return imageId1;
	}
	public void setImageId1(int imageId1) {
		this.imageId1 = imageId1;
	}
	
}

