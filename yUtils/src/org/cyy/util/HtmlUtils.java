package org.cyy.util;

import android.text.Html;

public class HtmlUtils {

	public void test(){
		String mContinuousDays ="8";
		String mGainIntegral ="13";
		Html.fromHtml(
			"<font color = \"#242426\">"+"您已连续打卡"+"</font>"+ 
			"<font color = \"#FA8B3C\">"+mContinuousDays+"</font>"+
			"<font color = \"#242426\">"+"天,获得"+"</font>"+
			"<font color = \"#FA8B3C\">"+mGainIntegral+"</font>"+
			"<font color = \"#242426\">"+"东币"+"</font>"
			);
	}
}
