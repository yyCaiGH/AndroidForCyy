package com.geihoo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geihoo.bean.PostContentBean;
import com.geihoo.bean.PostContentBean;
import com.geihoo.groups.R;

public class Constants {
	
	public static ArrayList<PostContentBean> getPostList() {
		int[] headIds = {
				R.drawable.test_head_img_0, R.drawable.test_head_img_1,
				R.drawable.test_head_img_2, R.drawable.test_head_img_3,
				R.drawable.test_head_img_4, R.drawable.test_head_img_5,
				R.drawable.test_head_img_6, R.drawable.test_head_img_7,
				R.drawable.test_head_img_8, R.drawable.test_head_img_9
		};
		String[] names = {
				"游戏主角", "旅人", "萝莉一号", "萌萌哒", "死神来了", 
				"小鲜肉", "恐高的鹿", "胖子", "皮卡皮卡", "阿狸"
		};
		int[] imageIds = {
				R.drawable.test_content_img_0, R.drawable.test_content_img_1,
				R.drawable.test_content_img_2, R.drawable.test_content_img_3,
				R.drawable.test_content_img_4, R.drawable.test_content_img_5,
				R.drawable.test_content_img_6, R.drawable.test_content_img_7,
				R.drawable.test_content_img_8, R.drawable.test_content_img_9
		};
		String[] contens = {
				"此松是黄山松的代表，乃至整个黄山的象征，它恰似一位好客的主人，挥展双臂，热情欢迎海内外宾客来黄山游览。",
				"丽江古城，又名“大研古镇”，海拔2400米，是丽江纳西族自治县的中心城市，是中国历史文化名城之一，世界文化遗产，国家5A级旅游景区，全国文明风景旅游区示范点。",
				"布达拉宫位于中国西藏自治区首府拉萨市区西北的玛布日山上，是一座宫堡式建筑群，最初是吐蕃王朝赞普松赞干布为迎娶尺尊公主和文成公主而兴建。",
				"北京故宫，旧称为紫禁城，是中国古代汉族宫殿建筑之精华，无与伦比的建筑杰作，也是世界上现存规模最大、保存最为完整的木质结构的古建筑群。",
				"长城修筑的历史可上溯到西周时期，周王朝为了防御北方游牧民族俨狁的袭击，曾筑连续排列的城堡“列城”以作防御。",
				"武夷山位于福建省武夷山市南郊，武夷山脉北段东南麓总面积999.75平方公里，是中国著名的风景旅游区和避暑胜地。",
				"九寨沟国家级自然保护区位于四川省阿坝藏族羌族自治州九寨沟县境内，是中国第一个以保护自然风景为主要目的的自然保护区，同时，也是中国著名风景名胜区和全国文明风景旅游区示范点。",
				"泰山（Mount Tai），世界文化与自然双重遗产[1] ，世界地质公园，全国重点文物保护单位，国家重点风景名胜区，国家AAAAA级旅游景区。",
				"三亚（Sanya ）位于海南岛的最南端，是中国最南部的热带滨海旅游城市，是中国空气质量最好的城市、全国最长寿地区（平均寿命80岁）。",
				"桂林是世界著名的旅游城市、中国首批国家历史文化名城、中国优秀旅游城市，其境内的山水风光举世闻名，千百年来享有“桂林山水甲天下”的美誉。"
		};
		ArrayList<PostContentBean> PostContentNoTitleBeans = new ArrayList<PostContentBean>();
		for (int i = 0; i < 10; i++) {
			PostContentBean PostContentNoTitleBean = new PostContentBean();
//			if (i == 0) {
//				PostContentNoTitleBean.setType(PostContentNoTitleBean.HEAD_TYPE);
//				PostContentNoTitleBean.setSocietyName("旅游");
//				PostContentNoTitleBean.setSocietyDetail("封闭社团·5位成员");
//			} else {
//				PostContentNoTitleBean.setType(PostContentNoTitleBean.NORMAL_POST_TYPE);
				PostContentNoTitleBean.setName(names[i]);
				PostContentNoTitleBean.setTime("7月"+(20-i)+"日");
				PostContentNoTitleBean.setContent(contens[i]);
				PostContentNoTitleBean.setHeadImgId(headIds[i]);
				PostContentNoTitleBean.setImageId1(imageIds[i]);
//			}
			PostContentNoTitleBeans.add(PostContentNoTitleBean);
		}
		return PostContentNoTitleBeans;
	}

	public static ArrayList<PostContentBean> getDynamicList() {
		int[] headIds = {
				R.drawable.test_head_img_0, R.drawable.test_head_img_1,
				R.drawable.test_head_img_2, R.drawable.test_head_img_3,
				R.drawable.test_head_img_4, R.drawable.test_head_img_5,
				R.drawable.test_head_img_6, R.drawable.test_head_img_7,
				R.drawable.test_head_img_8, R.drawable.test_head_img_9
		};
		String[] names = {
				"游戏主角", "旅人", "萝莉一号", "萌萌哒", "死神来了", 
				"小鲜肉", "恐高的鹿", "胖子", "皮卡皮卡", "阿狸"
		};
		int[] imageIds = {
				R.drawable.test_content_img_0, R.drawable.test_content_img_1,
				R.drawable.test_content_img_2, R.drawable.test_content_img_3,
				R.drawable.test_content_img_4, R.drawable.test_content_img_5,
				R.drawable.test_content_img_6, R.drawable.test_content_img_7,
				R.drawable.test_content_img_8, R.drawable.test_content_img_9
		};
		String[] contens = {
				"此松是黄山松的代表，乃至整个黄山的象征，它恰似一位好客的主人，挥展双臂，热情欢迎海内外宾客来黄山游览。",
				"丽江古城，又名“大研古镇”，海拔2400米，是丽江纳西族自治县的中心城市，是中国历史文化名城之一，世界文化遗产，国家5A级旅游景区，全国文明风景旅游区示范点。",
				"布达拉宫位于中国西藏自治区首府拉萨市区西北的玛布日山上，是一座宫堡式建筑群，最初是吐蕃王朝赞普松赞干布为迎娶尺尊公主和文成公主而兴建。",
				"北京故宫，旧称为紫禁城，是中国古代汉族宫殿建筑之精华，无与伦比的建筑杰作，也是世界上现存规模最大、保存最为完整的木质结构的古建筑群。",
				"长城修筑的历史可上溯到西周时期，周王朝为了防御北方游牧民族俨狁的袭击，曾筑连续排列的城堡“列城”以作防御。",
				"武夷山位于福建省武夷山市南郊，武夷山脉北段东南麓总面积999.75平方公里，是中国著名的风景旅游区和避暑胜地。",
				"九寨沟国家级自然保护区位于四川省阿坝藏族羌族自治州九寨沟县境内，是中国第一个以保护自然风景为主要目的的自然保护区，同时，也是中国著名风景名胜区和全国文明风景旅游区示范点。",
				"泰山（Mount Tai），世界文化与自然双重遗产[1] ，世界地质公园，全国重点文物保护单位，国家重点风景名胜区，国家AAAAA级旅游景区。",
				"三亚（Sanya ）位于海南岛的最南端，是中国最南部的热带滨海旅游城市，是中国空气质量最好的城市、全国最长寿地区（平均寿命80岁）。",
				"桂林是世界著名的旅游城市、中国首批国家历史文化名城、中国优秀旅游城市，其境内的山水风光举世闻名，千百年来享有“桂林山水甲天下”的美誉。"
		};
		ArrayList<PostContentBean> PostContentNoTitleBeans = new ArrayList<PostContentBean>();
		for (int i = 0; i < 10; i++) {
			PostContentBean PostContentNoTitleBean = new PostContentBean();
//			PostContentNoTitleBean.setType(PostContentNoTitleBean.NORMAL_POST_TYPE);
			PostContentNoTitleBean.setName("旅游社");
			PostContentNoTitleBean.setTime(names[i]+"  7月"+(20-i)+"日");
			PostContentNoTitleBean.setContent(contens[i]);
			PostContentNoTitleBean.setHeadImgId(headIds[i]);
			PostContentNoTitleBean.setImageId1(imageIds[i]);
			PostContentNoTitleBeans.add(PostContentNoTitleBean);
		}
		return PostContentNoTitleBeans;
	}
	
	public static List<HashMap<String, String>> getCommentList(){
		List<HashMap<String, String>> resList = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userName", "喵星人");
		map.put("speech", "呵呵！");
		resList.add(map);
		map = new HashMap<String, String>();
		map.put("userName", "汪星人");
		map.put("speech", "哈哈！");
		resList.add(map);
		map = new HashMap<String, String>();
		map.put("userName", "喵星人回复汪星人");
		map.put("speech", "有意思吗？");
		resList.add(map);
		map = new HashMap<String, String>();
		map.put("userName", "汪星人回复喵星人");
		map.put("speech", "Follow you heart!");
		resList.add(map);
		return resList;
	}
}
