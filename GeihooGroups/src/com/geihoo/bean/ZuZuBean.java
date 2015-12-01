package com.geihoo.bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class ZuZuBean implements Parcelable{

	/**
	 * 族族名称
	 */
	private String name;
	/**
	 * 族族头像
	 */
	private Bitmap headIcon;
	/**
	 * 族族背景
	 */
	private Bitmap BgIcon;
	/**
	 * 族族类型，1-私密，2-公开
	 */
	private int type;
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	

     public static final Parcelable.Creator<ZuZuBean> CREATOR = new Creator<ZuZuBean>() { 
            public ZuZuBean createFromParcel(Parcel source) { 
            	ZuZuBean pb = new ZuZuBean(); 
                pb.name = source.readString(); 
                pb.headIcon = Bitmap.CREATOR.createFromParcel(source);
                pb.BgIcon = Bitmap.CREATOR.createFromParcel(source);
                pb.type = source.readInt();
                return pb; 
            } 
            public ZuZuBean[] newArray(int size) { 
                return new ZuZuBean[size]; 
            } 
        }; 
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        headIcon.writeToParcel(parcel, 0);
        BgIcon.writeToParcel(parcel, 0);
        parcel.writeInt(type);
    }
	
}
