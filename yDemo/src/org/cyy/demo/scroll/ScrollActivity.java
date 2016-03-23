package org.cyy.demo.scroll;

import org.cyy.demo.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScrollActivity extends Activity implements OnClickListener{

	TextView tv,tv_hi;
	Button right,left,top,bottom;
	RelativeLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_scroll);
		tv = (TextView)this.findViewById(R.id.tv_scroll);
		ll = (RelativeLayout)this.findViewById(R.id.ll_scroll);
		tv_hi =(TextView)findViewById(R.id.tv_hi);
		right = (Button)this.findViewById(R.id.btn_right);
		left = (Button)this.findViewById(R.id.btn_left);
		top = (Button)this.findViewById(R.id.btn_top);
		bottom = (Button)this.findViewById(R.id.btn_bottom);
		top.setOnClickListener(this);
		bottom.setOnClickListener(this);
		right.setOnClickListener(this);
		left.setOnClickListener(this);
//		tv.setText("x:"+tv.getScrollX()+",y:"+tv.getScaleY());
		Log.i("tag","x:"+tv.getScrollX()+",y:"+tv.getScrollY());
		Log.i("tag-hi","x:"+tv_hi.getScrollX()+",y:"+tv_hi.getScrollY());
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==right){
			tv.scrollBy(-10, 0);
//			tv.offsetLeftAndRight(-10);
//			tv.scrollBy(10, 10);
			tv_hi.scrollBy(-10, -10);
		}
		else if(v==left){
			tv.scrollBy(10, 0);
//			tv.offsetLeftAndRight(10);
		}
		else if(v==top){
			tv.scrollBy(0, 10);
//			tv.setText("x:"+tv.getScrollX()+",y:"+tv.getScaleY());
//			tv.setTextColor(Color.RED);
//			tv.setTextSize(18);
//			tv.setText("tv");
		}
		else if(v==bottom){
			tv.scrollBy(0, -10);
		}
		Log.i("tag","x:"+tv.getScrollX()+",y:"+tv.getScrollY());
		Log.i("tag-hi","x:"+tv_hi.getScrollX()+",y:"+tv_hi.getScrollY());
	}
	
}
