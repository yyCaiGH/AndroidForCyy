package org.cyy.demo.swiperefreshwidget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cyy.demo.R;
import org.cyy.demo.swiperefreshwidget.YSwipeRefreshLayout.OnRefreshAndLoadListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RefreshActivity extends Activity{

	@Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
    
        setContentView(R.layout.refresh);  
  
        // 模拟一些数据  
        final List<String> datas = new ArrayList<String>();  
//        for (int i = 0; i < 6; i++) {  
//            datas.add("item - " + i);  
//        }  
  
        // 构造适配器  
        final BaseAdapter adapter = new ArrayAdapter<String>(this,  
                android.R.layout.simple_list_item_1,  
                datas);  
        // 获取listview实例  
        ListView listView = (ListView) findViewById(R.id.listview);  
        listView.setAdapter(adapter);  
  
        // 获取RefreshLayout实例  
        final YSwipeRefreshLayout myRefreshListView = (YSwipeRefreshLayout)  
                findViewById(R.id.swipe_layout);  
  
        // 设置下拉刷新时的颜色值,颜色值需要定义在xml中  
        myRefreshListView.setColorSchemeResources(R.color.black, android.R.color.holo_blue_light,
				R.color.sys_main_color, android.R.color.holo_red_light);
        // 设置下拉刷新监听器  
        /*myRefreshListView.setOnRefreshListener(new OnRefreshListener() {  
  
            @Override  
            public void onRefresh() {  
  
                Toast.makeText(RefreshActivity.this, "refresh", Toast.LENGTH_SHORT).show();  
  
                myRefreshListView.postDelayed(new Runnable() {  
  
                    @Override  
                    public void run() {  
                        // 更新数据  
//                        datas.add(new Date().toGMTString());  
                    	List<String> ds = new ArrayList<String>();  
                        for (int i = 0; i < 6; i++) {  
                            ds.add("refresh - " + i);  
                        } 
                        datas.clear();
                        datas.addAll(ds);
                        adapter.notifyDataSetChanged();  
                        // 更新完后调用该方法结束刷新  
                        myRefreshListView.setRefreshing(false);  
                    }  
                }, 1000);  
            }  
        });  */
  
        // 加载监听器  
        myRefreshListView.setOnRefreshAndLoadListener(new OnRefreshAndLoadListener() {  
  
            @Override  
            public void onLoad() {  
  
                Toast.makeText(RefreshActivity.this, "load", Toast.LENGTH_SHORT).show();  
  
                myRefreshListView.postDelayed(new Runnable() {  
  
                    @Override  
                    public void run() {  
                        datas.add(new Date().toGMTString());  
                        adapter.notifyDataSetChanged();  
                        // 加载完后调用该方法  
                        if(datas.size()>8){
                        	myRefreshListView.setLoading(false,true);  
                        }
                        else{
                        	myRefreshListView.setLoading(false,false);  
                        }
                        
                    }  
                }, 1500);  
  
            }

			@Override
			public void onRefresh() {
				Toast.makeText(RefreshActivity.this, "refresh", Toast.LENGTH_SHORT).show();  
				  
                myRefreshListView.postDelayed(new Runnable() {  
  
                    @Override  
                    public void run() {  
                        // 更新数据  
//                        datas.add(new Date().toGMTString());  
                    	List<String> ds = new ArrayList<String>();  
                        for (int i = 0; i < 6; i++) {  
                            ds.add("refresh - " + i);  
                        } 
                        datas.clear();
                        datas.addAll(ds);
                        adapter.notifyDataSetChanged();  
                        // 更新完后调用该方法结束刷新  
                        myRefreshListView.setRefreshing(false);  
                    }  
                }, 1000);  
				
			}  
        });  
    }  
}
