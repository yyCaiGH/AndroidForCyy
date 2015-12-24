package com.geihoo.bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.TextView;

import com.geihoo.view.CustomImageView;

public class ContactsBean implements Parcelable {
	private Bitmap image;
	private String name;
	private boolean checked;// 选择属性，辅助选择
	private int sex; //1:男，2：女
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}


	public static final Parcelable.Creator<ContactsBean> CREATOR = new Creator<ContactsBean>() {
		public ContactsBean createFromParcel(Parcel source) {
			ContactsBean pb = new ContactsBean();
			pb.name = source.readString();
			pb.image = Bitmap.CREATOR.createFromParcel(source);
			/** boolean 读出 */
			pb.checked = (source.readInt() == 1) ? true : false;
			pb.sex = source.readInt();
			return pb;
		}

		public ContactsBean[] newArray(int size) {
			return new ContactsBean[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeString(name);
		image.writeToParcel(parcel, 0);
		parcel.writeInt(checked ? 1 : 0);
		parcel.writeInt(sex);
	}
}
