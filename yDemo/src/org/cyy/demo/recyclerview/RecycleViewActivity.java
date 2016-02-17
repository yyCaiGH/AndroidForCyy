package org.cyy.demo.recyclerview;

import java.util.ArrayList;
import java.util.List;

import org.cyy.demo.R;
import org.cyy.demo.recyclerview.PersonAdapter.OnRecyclerViewListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class RecycleViewActivity extends Activity implements OnRecyclerViewListener{

	RecyclerView recyclerView ;
	PersonAdapter adapter;
	List<Person> personList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_recycleview);
		recyclerView = (RecyclerView)this.findViewById(R.id.recycler_view_test_rv);
		recyclerView.setHasFixedSize(true);//使RecyclerView保持固定的大小,这样会提高RecyclerView的性能。

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(OrientationHelper.HORIZONTAL);  //设置为横向滚动
        initData();
        adapter = new PersonAdapter(personList);
        adapter.setOnRecyclerViewListener(this);
        recyclerView.setAdapter(adapter);
	}
	private void initData() {
		personList = new ArrayList<Person>();
		Person p = new Person();
		p.setAge(11);
		p.setName("qwe");
		personList.add(p);
		p = new Person();
		p.setAge(12);
		p.setName("qweqwe");
		personList.add(p);
		p = new Person();
		p.setAge(12);
		p.setName("qweqwe");
		personList.add(p);
		p = new Person();
		p.setAge(12);
		p.setName("qweqwe");
		personList.add(p);
	}
	@Override
	public void onItemClick(int position) {
		Toast.makeText(this, "onitemClick", 0).show();
		
	}
	@Override
	public boolean onItemLongClick(int position) {
		Toast.makeText(this, "onItemLongClick", 0).show();
		return true;
	}
}
