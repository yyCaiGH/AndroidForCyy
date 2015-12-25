package com.geihoo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;

import com.geihoo.bean.ActivityBean;
import com.geihoo.bean.AlbumBean;
import com.geihoo.bean.ContactsBean;
import com.geihoo.bean.FunBean;
import com.geihoo.bean.HomePageBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ImageUtil;

public class Datas {

//	public static int ZDXS = 0;
	private static List<HashMap<String, Object>> noCommonZuzus;// 不常用族族
	private static List<ZuZuBean> allZuzu;// 所有族族
	private static List<ContactsBean> allContact;//所有联系人
	private static List<FunBean> allFun;
	public static List<HashMap<String, Object>> getAllRecentlyMes() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> bean1 = new HashMap<String, Object>();
		bean1.put("image", R.drawable.def_man);
		bean1.put("name", "陈子正");
		bean1.put("mes", "你好，周末有空吗？");
		bean1.put("time", "18:22");
		bean1.put("sex", Constant.CONTACT_SEX_MAN);
		HashMap<String, Object> bean2 = new HashMap<String, Object>();
		bean2.put("image", R.drawable.def_woman);
		bean2.put("name", "陈琼霞");
		bean2.put("mes", "周末有空吗？我们一起去西湖看菊花展吧！");
		bean2.put("time", "18:29");
		bean2.put("sex", Constant.CONTACT_SEX_WOMEN);
		HashMap<String, Object> bean3 = new HashMap<String, Object>();
		bean3.put("image", R.drawable.def_man);
		bean3.put("name", "陈玲");
		bean3.put("mes", "今天谢谢你");
		bean3.put("time", "19:22");
		bean3.put("sex", Constant.CONTACT_SEX_MAN);
		HashMap<String, Object> bean4 = new HashMap<String, Object>();
		bean4.put("image", R.drawable.def_woman);
		bean4.put("name", "花千骨");
		bean4.put("mes", "晚安");
		bean4.put("time", "20:23");
		bean4.put("sex", Constant.CONTACT_SEX_WOMEN);
		HashMap<String, Object> bean5 = new HashMap<String, Object>();
		bean5.put("image", R.drawable.def_man);
		bean5.put("name", "喜来乐");
		bean5.put("mes", "下次我再找你");
		bean5.put("time", "9月1日");
		bean5.put("sex", Constant.CONTACT_SEX_MAN);
		HashMap<String, Object> bean6 = new HashMap<String, Object>();
		bean6.put("image", R.drawable.def_woman);
		bean6.put("name", "饶赛云");
		bean6.put("mes", "晚上有空吗？");
		bean6.put("time", "9月1日");
		bean6.put("sex", Constant.CONTACT_SEX_WOMEN);
		HashMap<String, Object> bean7 = new HashMap<String, Object>();
		bean7.put("image", R.drawable.def_man);
		bean7.put("name", "林峰云");
		bean7.put("mes", "你好，周末有空吗？");
		bean7.put("time", "8月31日");
		bean7.put("sex", Constant.CONTACT_SEX_MAN);
		HashMap<String, Object> bean8 = new HashMap<String, Object>();
		bean8.put("image", R.drawable.def_man);
		bean8.put("name", "林人理");
		bean8.put("mes", "你好，您已经欠费");
		bean8.put("time", "8月30日");
		bean8.put("sex", Constant.CONTACT_SEX_MAN);
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		list.add(bean4);
		list.add(bean5);
		list.add(bean6);
		list.add(bean7);
		list.add(bean8);
		return list;
	}

	public static List<ContactsBean> getContacts(Context context) {
		if(allContact!=null){
			return allContact;
		}
		allContact = new ArrayList<ContactsBean>();
		ContactsBean bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context, R.drawable.def_woman));
		bean1.setName("蔡巧恋");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("蔡依林");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("蔡跃勇");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("陈飞蓬");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("陈真真");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("陈振东");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("Filt Super");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("郭云萍");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("黄进生");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("胡陈锦");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("林俊杰");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("李时珍");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("刘碧端");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("Sile Girl");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("王邵文");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean1.setName("王心凌");
		bean1.setSex(Constant.CONTACT_SEX_WOMEN);
		allContact.add(bean1);
		bean1 = new ContactsBean();
		bean1.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean1.setName("郑成功");
		bean1.setSex(Constant.CONTACT_SEX_MAN);
		allContact.add(bean1);
		
		return allContact;
	}

	public static List<HashMap<String, Object>> getZuZuMembers(Context activity) {
		List<HashMap<String, Object>> members = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> member = new HashMap<String, Object>();
		member.put("member_name", "陈子正");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx1));
		member.put("menmber_tab", 1);// 0：普通成员，1：族长，2：管理员
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "陈琼霞");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx2));
		member.put("menmber_tab", 2);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "陈玲");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx3));
		member.put("menmber_tab", 0);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "花千骨");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx4));
		member.put("menmber_tab", 0);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "喜来乐");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx5));
		member.put("menmber_tab", 0);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "饶赛云");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx6));
		member.put("menmber_tab", 0);
		members.add(member);

		return members;
	}

	public static List<HashMap<String, Object>> getZuZuMemberFriends(
			Context activity) {
		List<HashMap<String, Object>> members = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> member = new HashMap<String, Object>();
		member.put("member_name", "陈子");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx1));
		member.put("menmber_tab", 0);// 0：普通成员，1：族长，2：管理员
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "蔡跃勇");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx2));
		member.put("menmber_tab", 2);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "玲儿");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx3));
		member.put("menmber_tab", 0);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "花骨");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx4));
		member.put("menmber_tab", 0);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "喜乐");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx5));
		member.put("menmber_tab", 0);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "饶云");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx6));
		member.put("menmber_tab", 0);
		members.add(member);

		return members;
	}

	/**
	 * 查看朋友圈成员
	 * @param activity
	 * @return
	 */
	public static List<HashMap<String, Object>> getFcMembers(
			Context activity) {
		List<HashMap<String, Object>> members = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> member = new HashMap<String, Object>();
		member.put("member_name", "陈子");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx1));
		member.put("menmber_tab", 5);// 5:朋友圈好友
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "跃勇");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx2));
		member.put("menmber_tab", 5);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "玲儿");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx3));
		member.put("menmber_tab", 5);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "花骨");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx4));
		member.put("menmber_tab", 5);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "喜乐");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx5));
		member.put("menmber_tab", 5);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "饶云");
		member.put("image", ImageUtil.readBitMap(activity, R.drawable.tx6));
		member.put("menmber_tab", 5);
		members.add(member);

		return members;
	}
	public static List<HashMap<String, Object>> getCommonZuzu(Context ctx) {
		List<HashMap<String, Object>> l = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "北香子诗社");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx1));
		l.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "漫雅居");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx2));
		l.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "金融俱乐部");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx3));
		l.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "国研和谐科学研究中心");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx4));
		l.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "福建电商之家");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx5));
		l.add(map);
		return l;
	}

	/**
	 * 非常用族族
	 * 
	 * @param ctx
	 * @return
	 */
	public static List<HashMap<String, Object>> getNoCommonZuzu(Context ctx) {
		if (noCommonZuzus != null) {
			return noCommonZuzus;
		}
		noCommonZuzus = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "佛缘企业家");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx6));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "跑步精英营");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx7));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "爱心大本营");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx8));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "无欲则刚");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx9));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "时间买卖客户研究中心");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx10));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "骑行王者");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx11));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "雨与伞");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx12));
		noCommonZuzus.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "电商之家");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.tx1));
		noCommonZuzus.add(map);
		return noCommonZuzus;
	}

	/**
	 * 获取族族类型
	 * 
	 * @param ctx
	 * @return
	 */
	public static List<HashMap<String, Object>> getZuzuTypes(Context ctx) {
		List<HashMap<String, Object>> groups = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "家人");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.jiaren));
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "挚友");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.pengyou));
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "俱乐部");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.jiaren));
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "活动策划");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.jiaren));
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "父母");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.pengyou));
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "团队成员");
		map.put("image", ImageUtil.readBitMap(ctx, R.drawable.jiaren));
		groups.add(map);
		return groups;
	}

	/**
	 * 所有族族
	 * 
	 * @param ctx
	 * @return
	 */
	public static List<ZuZuBean> getAllZuzu(Context ctx) {
		if (allZuzu != null) {
			return allZuzu;
		}
		allZuzu = new ArrayList<ZuZuBean>();
		ZuZuBean zz = new ZuZuBean();
		zz.setName("佛缘企业家");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx6));
		allZuzu.add(zz);
		zz = new ZuZuBean();
		zz.setName("跑步精英营");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx9));
		allZuzu.add(zz);
		zz = new ZuZuBean();
		zz.setName("爱心大本营");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx8));
		allZuzu.add(zz);
		zz = new ZuZuBean();
		zz.setName("无欲则刚");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx7));
		allZuzu.add(zz);
		zz = new ZuZuBean();
		zz.setName("时间买卖客户研究中心");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx10));
		allZuzu.add(zz);
		zz = new ZuZuBean();
		zz.setName("骑行王者");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx11));
		allZuzu.add(zz);
		zz = new ZuZuBean();
		zz.setName("雨与伞");
		zz.setHeadIcon(ImageUtil.readBitMap(ctx, R.drawable.tx12));
		allZuzu.add(zz);

		return allZuzu;
	}

	/**
	 * 获取count个族族
	 * 
	 * @param ctx
	 * @param count
	 * @return
	 */
	public static List<ZuZuBean> getsomeZuzubyCount(Context ctx, int count) {
		if (allZuzu == null) {
			allZuzu = getAllZuzu(ctx);
		}
		return allZuzu.subList(0, count);
	}
	/**
	 * 获取活动预告
	 * @param mActivity
	 * @return
	 */
	public static List<ActivityBean> getActivitys(Context mActivity){
		ActivityBean test1 = new ActivityBean();
		test1.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test1.setTitle("公司聚会唱歌");
		test1.setDate("12月12日 13:00 - 12月13日 18:00");
		test1.setDt("12月");
		test1.setPlace("红馆KTV");
		test1.setOrganizer("黄帝");
		test1.setNum(23);
		ActivityBean test2 = new ActivityBean();
		test2.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test2.setTitle("福州骑行");
		test2.setDate("12月12日 13:00 - 12月13日 18:00");
		test2.setDt("12月");
		test2.setPlace("江滨");
		test2.setOrganizer("小李子");
		test2.setNum(11);
		ActivityBean test3 = new ActivityBean();
		test3.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test3.setTitle("周末爬山");
		test3.setDate("12月12日 13:00 - 12月13日 18:00");
		test3.setDt("12月");
		test3.setPlace("鼓山");
		test3.setOrganizer("蔡先生");
		test3.setNum(98);
		ActivityBean test4 = new ActivityBean();
		test4.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test4.setTitle("组队逛街");
		test4.setDate("11月12日 13:00 - 11月13日 18:00");
		test4.setDt("11月");
		test4.setPlace("红馆KTV");
		test4.setOrganizer("许小姐");
		test4.setNum(29);
		ActivityBean test5 = new ActivityBean();
		test5.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test5.setTitle("大扫除");
		test5.setDate("11月12日 13:00 - 11月13日 18:00");
		test5.setDt("11月");
		test5.setPlace("永兴洋房3#206宿舍");
		test5.setOrganizer("习近平");
		test5.setNum(999);
		List<ActivityBean> list = new ArrayList<ActivityBean>();
		list.add(test1);
		list.add(test2);
		list.add(test3);
		list.add(test4);
		list.add(test5);
		return list;
	}
	/**
	 * 获取往期活动
	 * @param mActivity
	 * @return
	 */
	public static List<ActivityBean> getOldActivitys(Context mActivity){
		ActivityBean test1=new ActivityBean();
		test1.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test1.setTitle("生日聚会");
		test1.setDate("10月12日 13:00 - 10月13日 18:00");
		test1.setDt("10月");
		test1.setPlace("悦华酒店");
		test1.setOrganizer("小男子");
		test1.setNum(20);
		List<ActivityBean> list=new ArrayList<ActivityBean>();
		
		ActivityBean test2 = new ActivityBean();
		test2.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test2.setTitle("登山");
		test2.setDate("10月12日 13:00 - 10月13日 18:00");
		test2.setDt("10月");
		test2.setPlace("太姥山");
		test2.setOrganizer("jolin");
		test2.setNum(2);
		ActivityBean test3 = new ActivityBean();
		test3.setImage(ImageUtil.readBitMap(mActivity,R.drawable.travel));
		test3.setTitle("游泳");
		test3.setDate("9月12日 13:00 - 9月13日 18:00");
		test3.setDt("9月");
		test3.setPlace("省体游泳馆");
		test3.setOrganizer("猪八戒");
		test3.setNum(0);
		list.add(test1);
		list.add(test2);
		list.add(test3);
		return list;
	}
	/**
	 * 获取相册列表
	 * @param mActivity
	 * @return
	 */
	public static List<AlbumBean> getAlbums(Context mActivity){
		List<AlbumBean> list = new ArrayList<AlbumBean>();
		for(int i=1;i<=4;i++){
			AlbumBean bean = new AlbumBean();
			if(i==2 || i==4){
				bean.setImage(ImageUtil.readBitMap(mActivity, R.drawable.album_demo1));
			}
			else{
				bean.setImage(ImageUtil.readBitMap(mActivity, R.drawable.album_demo));
			}
			bean.setName("我的相册"+i);
			bean.setNum(20+i);
			list.add(bean);
		}
		return list;
	}
	
	/**
	 * 获取相册的图片
	 * @param mActivity
	 * @return
	 */
	public static List<HashMap<String,Object>> getPhotos(Context mActivity){
		List<HashMap<String,Object>> imagelist = new ArrayList<HashMap<String,Object>>();
		  // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
		  // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
		  HashMap<String,Object> map1 = new HashMap<String,Object>();
		  map1.put("image", R.drawable.tx1);
		  imagelist.add(map1);
		  HashMap<String,Object> map2 = new HashMap<String,Object>();
		  map2.put("image", R.drawable.travel);
		  imagelist.add(map2);
		  HashMap<String,Object> map3 = new HashMap<String,Object>();
		  map3.put("image", R.drawable.tx1);
		  imagelist.add(map3);
		  HashMap<String,Object> map4 = new HashMap<String,Object>();
		  map4.put("image", R.drawable.travel);
		  imagelist.add(map4);
		  HashMap<String,Object> map5 = new HashMap<String,Object>();
		  map5.put("image", R.drawable.tx5);
		  imagelist.add(map5);
		  HashMap<String,Object> map6 = new HashMap<String,Object>();
		  map6.put("image", R.drawable.tx6);
		  imagelist.add(map6);
		  HashMap<String,Object> map7 = new HashMap<String,Object>();
		  map7.put("image", R.drawable.travel);
		  imagelist.add(map7);
		  HashMap<String,Object> map8 = new HashMap<String,Object>();
		  map8.put("image", R.drawable.tx6);
		  imagelist.add(map8);
		  HashMap<String,Object> map9 = new HashMap<String,Object>();
		  map9.put("image", R.drawable.travel);
		  imagelist.add(map9);
		  HashMap<String,Object> map10 = new HashMap<String,Object>();
		  map10.put("image", R.drawable.tx6);
		  imagelist.add(map10);
		  HashMap<String,Object> map11 = new HashMap<String,Object>();
		  map11.put("image", R.drawable.travel);
		  imagelist.add(map11);
		  
		  return imagelist;
	}
	
	/**
	 * 获取所有功能
	 * 
	 * @param ctx
	 * @return
	 */
	public static List<FunBean> getAllFuns(Context ctx) {
		if(allFun!=null){
			return allFun;
		}
		allFun = new ArrayList<FunBean>();
		FunBean fun = new FunBean();
		fun.setName("族记");
		fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_notepad));
		fun.setAdd(true);
		allFun.add(fun);
		fun = new FunBean();
		fun.setName("记账");
		fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_jizhangben));
		fun.setAdd(true);
		allFun.add(fun);
		fun = new FunBean();
		fun.setName("音乐");
		fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_music));
		fun.setAdd(true);
		allFun.add(fun);
		fun = new FunBean();
		fun.setName("视频");
		fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_shipin));
		fun.setAdd(true);
		allFun.add(fun);
		fun = new FunBean();
		fun.setName("收藏");
		fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_shoucang));
		fun.setAdd(true);
		allFun.add(fun);
		fun = new FunBean();
		fun.setName("书架");
		fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_shujiaxuanzhong));
		fun.setAdd(true);
		allFun.add(fun);
		for (int i = 1; i < 11; i++) {
			fun = new FunBean();
			fun.setName("功能"+i);
			fun.setImage(ImageUtil.readBitMap(ctx, R.drawable.my_gongneng));
			fun.setAdd(false);
			allFun.add(fun);
		}
		return allFun;
	}
	/**
	 * 获取主页的动态内容
	 * @param mActivity
	 * @return
	 */
	public static List<HomePageBean> getHomePageContent(Context mActivity){
		List<Bitmap> imgs0 = new ArrayList<Bitmap>();
		imgs0.add(ImageUtil.readBitMap(mActivity, R.drawable.test_content_img_2));
		List<Bitmap> imgs1 = new ArrayList<Bitmap>();
		imgs1.add(ImageUtil.readBitMap(mActivity, R.drawable.tx8));
		imgs1.add(ImageUtil.readBitMap(mActivity, R.drawable.tx3));
		imgs1.add(ImageUtil.readBitMap(mActivity, R.drawable.tx1));
		imgs1.add(ImageUtil.readBitMap(mActivity, R.drawable.tx5));
		imgs1.add(ImageUtil.readBitMap(mActivity, R.drawable.tx2));
		List<Bitmap> imgs = new ArrayList<Bitmap>();
		imgs.add(ImageUtil.readBitMap(mActivity, R.drawable.test_content_img_8));
		imgs.add(ImageUtil.readBitMap(mActivity, R.drawable.tx10));
		imgs.add(ImageUtil.readBitMap(mActivity, R.drawable.tx9));
		List<HomePageBean> dynamic = new ArrayList<HomePageBean>();
		HomePageBean bean = new HomePageBean();
		bean.setContent("从今天起，我要做个有梦想的人，不止为了儿时的梦。更是为了那个不悔的青春");
		bean.setImgs(imgs1);
		bean.setTime("今天");
		dynamic.add(bean);
		bean = new HomePageBean();
		bean.setContent("我最想去的几个地方！！");
		
		bean.setImgs(imgs);
		bean.setTime("星期五");
		dynamic.add(bean);
		bean = new HomePageBean();
		bean.setContent("世界那么大，我想去看看");
		
		bean.setImgs(imgs0);
		bean.setTime("8月30日");
		dynamic.add(bean);
		bean = new HomePageBean();
		bean.setContent("转发：我喜欢的，你不一定喜欢");
		
		bean.setImgs(imgs);
		bean.setTime("8月28日");
		dynamic.add(bean);
		bean = new HomePageBean();
		bean.setContent("西藏，一个神圣的地域，在我读完《藏地密码》后，我对他的崇拜已经不可言喻，我期待哪一天，我能踏上它，面对布达拉宫，说一声：西藏，我来了!");
		
		bean.setImgs(imgs0);
		bean.setTime("8月25日");
		dynamic.add(bean);
		bean = new HomePageBean();
		bean.setContent("云岚来了，好开心！！");
		
		bean.setImgs(imgs);
		bean.setTime("8月21日");
		dynamic.add(bean);
		return dynamic;
	}
}
