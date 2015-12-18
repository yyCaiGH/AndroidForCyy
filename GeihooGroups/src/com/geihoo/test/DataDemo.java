package com.geihoo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.geihoo.bean.ContactsBean;
import com.geihoo.bean.FriendCircleBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ImageUtil;

public class DataDemo {
	private  static List<FriendCircleBean> friendcircle;
	private  static List<ZuZuBean> commonZuzus,privateZuzus,publicZuzus;
	private  List<HashMap<String, Object>> data3;
	private  List<HashMap<String, Object>> data4;
	private  List<HashMap<String, Object>> data5;
	
	public static List<ZuZuBean> getCommonZuzu(Context ctx){
		if(commonZuzus!=null){
			return commonZuzus;
		}
		commonZuzus = new ArrayList<ZuZuBean>();
		ZuZuBean zuzu = new ZuZuBean();
		zuzu.setName("北香子诗社");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx9));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("漫雅居");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx8));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("金融俱乐部");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx1));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("国研和谐科学研究中心");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx11));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("福建电商之家");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx2));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("旅游");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.travel));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("商家");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx3));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		commonZuzus.add(zuzu);
		return commonZuzus;
	}
	//朋友圈
	public static List<FriendCircleBean> getFriendsCircle(Context ctx){
		if(friendcircle!=null){
			return friendcircle;
		}
		friendcircle = new ArrayList<FriendCircleBean>();
		FriendCircleBean fc = new FriendCircleBean();
		fc.setName("家人");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx5));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		fc = new FriendCircleBean();
		fc.setName("朋友");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx6));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		fc = new FriendCircleBean();
		fc.setName("同学");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.rao));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		fc = new FriendCircleBean();
		fc.setName("邻居");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx12));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		fc = new FriendCircleBean();
		fc.setName("同事");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx9));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		fc = new FriendCircleBean();
		fc.setName("客户");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx8));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		fc = new FriendCircleBean();
		fc.setName("商家");
		fc.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx3));
		fc.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		friendcircle.add(fc);
		return friendcircle;
	}
	
	
	public static List<ZuZuBean> getPrivateZuzu(Context ctx){
		if(privateZuzus!=null){
			return privateZuzus;
		}
		privateZuzus = new ArrayList<ZuZuBean>();
		ZuZuBean zuzu = new ZuZuBean();
		zuzu.setName("佛缘企业家");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx1));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("跑步精英营");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx7));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("爱心大本营");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx10));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("红楼梦楼");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx12));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("休闲山庄");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx3));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("苍穹文学社团");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx8));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("活宝妞联");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx4));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("时间买卖客户心理研究中心");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx11));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PRIVATE);
		privateZuzus.add(zuzu);
		
		return privateZuzus;
	}
	
	public  static List<ZuZuBean> getPublicZuzus(Context ctx){
		if(publicZuzus!=null){
			return publicZuzus;
		}
		publicZuzus = new ArrayList<ZuZuBean>();
		ZuZuBean zuzu = new ZuZuBean();
		zuzu.setName("休闲山庄");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx3));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		publicZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("苍穹文学社团");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx8));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		publicZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("西游记");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx5));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		publicZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("星缘俱乐部");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx4));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_8));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		publicZuzus.add(zuzu);
		zuzu = new ZuZuBean();
		zuzu.setName("居客集中营");
		zuzu.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx11));
		zuzu.setBgIcon(ImageUtil.readBitMap(ctx, R.drawable.test_content_img_10));
		zuzu.setType(Constant.ZZ_TYPE_PUBLIC);
		publicZuzus.add(zuzu);
		return publicZuzus;
	}
	
	public  List<HashMap<String, Object>> getData3(Context ctx){
		if(data3!=null){
			return data3;
		}
		data3 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "星缘俱乐部");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx5));
		data3.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "居客集中营 ");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx11));
		data3.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "不陋室铭");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx7));
		data3.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "水浒传研究中心");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx8));
		data3.add(map3);
		return data3;
		
	}
	
	public  List<HashMap<String, Object>> getData4(Context ctx){
		if(data4!=null){
			return data4;
		}
		data4 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "人生初见");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx12));
		data4.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "初心始终");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx6));
		data4.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "科技云相册");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx9));
		data4.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "科技之家");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx10));
		data4.add(map3);
		return data4;
		
	}
	
	public  List<HashMap<String, Object>> getData5(Context ctx){
		if(data5!=null){
			return data5;
		}
		data5 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "无欲则刚");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx2));
		data5.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "时间买卖客户心理研究中心");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx1));
		data5.add(map3);
		map3 = new HashMap<String, Object>();
		map3.put("title", "骑行王者");
		map3.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx3));
		data5.add(map3);
		return data5;
		
	}
	
}
