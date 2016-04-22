package org.cyy.demo.itemanim;

import java.util.ArrayList;
import java.util.List;

import org.cyy.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewItemAnimActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_anim);
		ListView lv = (ListView)this.findViewById(R.id.lv);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			list.add(i+"");
		}
		lv.setAdapter(new MyAdapter(list, this));
	}
}
