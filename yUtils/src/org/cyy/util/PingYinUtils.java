package org.cyy.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PingYinUtils {

	/**
	 * 返回每个字符的首字母，英文直接返回，中文返回首字母
	 * 
	 * @param str
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public static String getPinYinHeadChars(String str) {

		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = null;
			try {
				pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word,
						new HanyuPinyinOutputFormat());
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

	/**
	 * 只传入长度为1的字符串，否则返回#
	 * 
	 * @param str
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public static char getPinYinHeadChar(String str) {

		if (str.length() > 1) {
			return '#';
		}
		char convert = '#';
		char word = str.charAt(0);
		String[] pinyinArray = null;
		try {
			pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word,
					new HanyuPinyinOutputFormat());
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pinyinArray != null) {
			convert = pinyinArray[0].charAt(0);// word是中文
		} else {
			convert = word;// word非中文
		}
		return convert;
	}
	/**
	 * 判断两个字符串的首字母是否相同,相同返回空格字符表示不用显示，不同返回则当前字符去显示
	 * @param previous
	 * @param current
	 * @return
	 */
	public static char isSame(String previous,String current){
		char previousLetter = getPinYinHeadChar(previous.substring(0, 1));
		char currentLetter = getPinYinHeadChar(current.substring(0, 1));
		if(previousLetter==currentLetter){
			return ' ';
		}
		return (currentLetter+"").toUpperCase().charAt(0);
	}
}
