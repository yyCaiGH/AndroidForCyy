package com.geihoo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

import com.geihoo.bean.ActivityBean;
import com.geihoo.bean.AlbumBean;
import com.geihoo.bean.ContactsBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

public class Datas {

//	public static int ZDXS = 0;
	private static List<HashMap<String, Object>> noCommonZuzus;// 不常用族族
	private static List<ZuZuBean> allZuzu;// 所有族族
	private static List<ContactsBean> allContact;//所有联系人
	public static List<HashMap<String, Object>> getAllRecentlyMes() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> bean1 = new HashMap<String, Object>();
		bean1.put("image", R.drawable.def_man);
		bean1.put("name", "陈子正");
		bean1.put("mes", "你好，周末有空吗？");
		bean1.put("time", "18:22");
		HashMap<String, Object> bean2 = new HashMap<String, Object>();
		bean2.put("image", R.drawable.def_woman);
		bean2.put("name", "陈琼霞");
		bean2.put("mes", "周末有空吗？我们一起去西湖看菊花展吧！");
		bean2.put("time", "18:29");
		HashMap<String, Object> bean3 = new HashMap<String, Object>();
		bean3.put("image", R.drawable.def_man);
		bean3.put("name", "陈玲");
		bean3.put("mes", "今天谢谢你");
		bean3.put("time", "19:22");
		HashMap<String, Object> bean4 = new HashMap<String, Object>();
		bean4.put("image", R.drawable.def_woman);
		bean4.put("name", "花千骨");
		bean4.put("mes", "晚安");
		bean4.put("time", "20:23");
		HashMap<String, Object> bean5 = new HashMap<String, Object>();
		bean5.put("image", R.drawable.def_man);
		bean5.put("name", "喜来乐");
		bean5.put("mes", "下次我再找你");
		bean5.put("time", "9月1日");
		HashMap<String, Object> bean6 = new HashMap<String, Object>();
		bean6.put("image", R.drawable.def_woman);
		bean6.put("name", "饶赛云");
		bean6.put("mes", "晚上有空吗？");
		bean6.put("time", "9月1日");
		HashMap<String, Object> bean7 = new HashMap<String, Object>();
		bean7.put("image", R.drawable.def_man);
		bean7.put("name", "林峰云");
		bean7.put("mes", "你好，周末有空吗？");
		bean7.put("time", "8月31日");
		HashMap<String, Object> bean8 = new HashMap<String, Object>();
		bean8.put("image", R.drawable.def_man);
		bean8.put("name", "林人理");
		bean8.put("mes", "你好，您已经欠费");
		bean8.put("time", "8月30日");

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
		allContact.add(bean1);
		ContactsBean bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean9.setName("蔡依林");
		allContact.add(bean9);
		ContactsBean bean2 = new ContactsBean();
		bean2.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean2.setName("蔡跃勇");
		allContact.add(bean2);
		ContactsBean bean3 = new ContactsBean();
		bean3.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean3.setName("陈飞蓬");
		allContact.add(bean3);
		ContactsBean bean4 = new ContactsBean();
		bean4.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean4.setName("陈真真");
		allContact.add(bean4);
		ContactsBean bean5 = new ContactsBean();
		bean5.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean5.setName("陈振东");
		allContact.add(bean5);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean9.setName("Filt Super");
		allContact.add(bean9);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean9.setName("郭云萍");
		allContact.add(bean9);
		ContactsBean bean7 = new ContactsBean();
		bean7.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean7.setName("黄进生");
		allContact.add(bean7);
		ContactsBean bean6 = new ContactsBean();
		bean6.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean6.setName("胡陈锦");
		allContact.add(bean6);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean9.setName("林俊杰");
		allContact.add(bean9);
		ContactsBean bean8 = new ContactsBean();
		bean8.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean8.setName("李时珍");
		allContact.add(bean8);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean9.setName("刘碧端");
		allContact.add(bean9);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean9.setName("Sile Girl");
		allContact.add(bean9);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean9.setName("王邵文");
		allContact.add(bean9);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_woman));
		bean9.setName("王心凌");
		allContact.add(bean9);
		bean9 = new ContactsBean();
		bean9.setImage(ImageUtil.readBitMap(context,R.drawable.def_man));
		bean9.setName("郑成功");
		allContact.add(bean9);
		
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
}
