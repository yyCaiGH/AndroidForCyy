package com.geihoo.bean;

import java.util.List;

import com.geihoo.utils.ImageUtil;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * 
 * 朋友圈实体类
 *
 * @author yyCai
 *
 * 2015年12月18日
 */
public class FriendCircleBean implements Parcelable{

	/**
	 * 朋友圈名称
	 */
	private String name;
	/**
	 * 朋友圈头像
	 */
	private Bitmap headIcon;//图片在intent传送的时候会过大
	/**
	 * 朋友圈头像地址
	 */
	private String headIconUri;//解决传送过大图片的问题
	/**
	 * 朋友圈背景
	 */
	private Bitmap BgIcon;
	/**
	 * 朋友圈背景地址
	 */
	private String bgIconUri;
	/**
	 * 朋友圈成员
	 */
	private List<ContactsBean> contacts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bitmap getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(Bitmap headIcon) {
		this.headIcon = headIcon;
	}
	public Bitmap getBgIcon() {
		return BgIcon;
	}
	public void setBgIcon(Bitmap bgIcon) {
		BgIcon = bgIcon;
	}
	public List<ContactsBean> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactsBean> contacts) {
		this.contacts = contacts;
	}
     public String getHeadIconUri() {
		return headIconUri;
	}
	public void setHeadIconUri(String headIconUri) {
		this.headIconUri = headIconUri;
	}
	public String getBgIconUri() {
		return bgIconUri;
	}
	public void setBgIconUri(String bgIconUri) {
		this.bgIconUri = bgIconUri;
	}

	public static final Parcelable.Creator<FriendCircleBean> CREATOR = new Creator<FriendCircleBean>() { 
            @SuppressWarnings("unchecked")
			public FriendCircleBean createFromParcel(Parcel source) { 
            	FriendCircleBean pb = new FriendCircleBean(); 
                pb.name = source.readString(); 
                pb.headIcon = Bitmap.CREATOR.createFromParcel(source);
                pb.headIconUri = source.readString();
                pb.BgIcon = Bitmap.CREATOR.createFromParcel(source);
                pb.bgIconUri = source.readString();
                pb.contacts = source.readArrayList(ContactsBean.class.getClassLoader());
                return pb; 
            } 
            public FriendCircleBean[] newArray(int size) { 
                return new FriendCircleBean[size]; 
            } 
        }; 
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        if(headIcon!=null){
        	headIcon.writeToParcel(parcel, 0);
        }
        parcel.writeString(headIconUri);
        if(BgIcon!=null){
        	BgIcon.writeToParcel(parcel, 0);
        }
        parcel.writeString(bgIconUri);
        parcel.writeList(contacts);
    }
}
