package org.cyy.demo.customview;

import java.util.ArrayList;

import org.cyy.demo.R;
import org.cyy.demo.customview.MyLetterListView.OnTouchingLetterChangedListener;
import org.cyy.demo.customview.MyListView.OnDeleteListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CustomViewActivity extends Activity{

	//MyLetterListView
	private TextView overlay;
	private OverlayThread overlayThread;
	private LetterListViewListener letterListViewListener;
	private MyLetterListView letterListView;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			
		};
	};
	//MyListView
	private MyListView myListView;
	ArrayList<String> strs = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_custom_view);
		//MyLetterListView
		overlayThread = new OverlayThread();
		letterListViewListener = new LetterListViewListener();
		letterListView = (MyLetterListView) findViewById(R.id.MyLetterListView01);
		overlay = (TextView)this.findViewById(R.id.overlay);
		letterListView.setOnTouchingLetterChangedListener(letterListViewListener);
		
		//MyListView
		myListView = (MyListView)this.findViewById(R.id.mylistview);
		myListView.setOnDeleteListener(new OnDeleteListener() {
			
			@Override
			public void onDelete(int index) {
				strs.remove(index);
				((MyAdapter)myListView.getAdapter()).notifyDataSetChanged();
				
			}
		});
		strs.add("123");
		strs.add("345");
		strs.add("657");
		strs.add("123");
		strs.add("345");
		strs.add("657");
		strs.add("123");
		strs.add("345");
		strs.add("657");
		strs.add("123");
		strs.add("345");
		strs.add("657");
		ArrayAdapter<String> adapter = new MyAdapter(this, 0, strs); 
		myListView.setAdapter(adapter);
	}
	
	private class LetterListViewListener implements OnTouchingLetterChangedListener {
        @Override
        public void onTouchingLetterChanged(final String s) {
            overlay.setText(s);
            overlay.setVisibility(View.VISIBLE);
            handler.removeCallbacks(overlayThread);
            // 延迟一秒后执行，让overlay为不可见
            handler.postDelayed(overlayThread, 1500);
        }
    }
	// 设置overlay不可见
	private class OverlayThread implements Runnable {
		@Override
		public void run() {
			overlay.setVisibility(View.GONE);
		}

	}

}
