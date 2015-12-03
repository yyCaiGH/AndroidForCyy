package com.geihoo.bean;

import java.util.List;

import com.geihoo.utils.ImageUtil;

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
	private Bitmap headIcon;//图片在intent传送的时候会过大
	/**
	 * 族族头像地址
	 */
	private String headIconUri;//解决传送过大图片的问题
	/**
	 * 族族背景
	 */
	private Bitmap BgIcon;
	/**
	 * 族族背景地址
	 */
	private String bgIconUri;
	/**
	 * 族族类型，constant.ZZ_TYPE_PRIVATE-私密，constant.ZZ_TYPE_PUBLIC-公开
	 */
	private int type;
	/**
	 * 族族成员
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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

	public static final Parcelable.Creator<ZuZuBean> CREATOR = new Creator<ZuZuBean>() { 
            @SuppressWarnings("unchecked")
			public ZuZuBean createFromParcel(Parcel source) { 
            	ZuZuBean pb = new ZuZuBean(); 
                pb.name = source.readString(); 
                pb.headIcon = Bitmap.CREATOR.createFromParcel(source);
                pb.headIconUri = source.readString();
                pb.BgIcon = Bitmap.CREATOR.createFromParcel(source);
                pb.bgIconUri = source.readString();
                pb.type = source.readInt();
                pb.contacts = source.readArrayList(ContactsBean.class.getClassLoader());
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
        if(headIcon!=null){
        	headIcon.writeToParcel(parcel, 0);
        }
        parcel.writeString(headIconUri);
        if(BgIcon!=null){
        	BgIcon.writeToParcel(parcel, 0);
        }
        parcel.writeString(bgIconUri);
        parcel.writeInt(type);
        parcel.writeList(contacts);
    }
}
