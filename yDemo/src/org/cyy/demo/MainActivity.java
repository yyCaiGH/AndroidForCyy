package org.cyy.demo;

import org.cyy.demo.appdown.DownloadTest;
import org.cyy.demo.customdialog.CustomDialogActivity;
import org.cyy.demo.customview.CustomViewActivity;
import org.cyy.demo.customview.CustomViewActivity2;
import org.cyy.demo.dealimge.DealImageActivity;
import org.cyy.demo.dragsortlistview.DSLVActivity;
import org.cyy.demo.essay.EssayActivity;
import org.cyy.demo.fragment.MainTab;
import org.cyy.demo.imagegallery.ImagePagerActivity;
import org.cyy.demo.itemanim.ListViewItemAnimActivity;
import org.cyy.demo.launchmode.StandardActivity;
import org.cyy.demo.ontouchevent.TestActivity;
import org.cyy.demo.other.SmallQuestionActivity;
import org.cyy.demo.recyclerview.RecycleViewActivity;
import org.cyy.demo.refresh.PullRefreshMainActivity;
import org.cyy.demo.scroll.ScrollActivity;
import org.cyy.demo.service.MusicListActivity;
import org.cyy.demo.swiperefreshwidget.RefreshActivity;
import org.cyy.demo.swiperefreshwidget.SwipeRefreshActivity;
import org.cyy.demo.videoview.VideoViewActivity;
import org.cyy.demo.welcome.WelcomePageActivity;
import org.cyy.demo.xutils.XUtilsActivity;
import org.cyy.util.Logger;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity{

	public static String tuwen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Logger.i("MainActivity", "onResume，任务栈id="+this.getTaskId());
	}
	public void ClickButton(View view) {
		//ViewPager+Fragment+RadioButton替代TabActivity
		if(view.getId()==R.id.button1){
			Intent i = new Intent(this,MainTab.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button2){
			Intent i = new Intent(this,TestActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button3){
			Intent i = new Intent(this,CustomViewActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button31){
			Intent i = new Intent(this,CustomViewActivity2.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button4){
			Intent i = new Intent(this,XUtilsActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button5){
			Intent i = new Intent(this,VideoViewActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button6){
			Intent i = new Intent(this,DSLVActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button7){
			Intent i = new Intent(this,EssayActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button8){
			Intent i = new Intent(this,MusicListActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button9){
			Intent i = new Intent(this,RecycleViewActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button10){
			Intent i = new Intent(this,WelcomePageActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button11){
			Intent i = new Intent(this,DownloadTest.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button12){
			Intent i = new Intent(this,CustomDialogActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button13){
			Intent i = new Intent(this,SmallQuestionActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button14){
			Intent i = new Intent(this,StandardActivity.class);
//			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
		}
		if(view.getId()==R.id.button15){
			Intent i = new Intent(this,ScrollActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button16){
			Intent i = new Intent(this,PullRefreshMainActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button17){
			Intent i = new Intent(this,SwipeRefreshActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button18){
			Intent i = new Intent(this,RefreshActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button19){
			Intent i = new Intent(this,DealImageActivity.class);
			startActivity(i);
		}
		if(view.getId()==R.id.button20){
			
			Intent intent = new Intent(this, ImagePagerActivity.class);
			// 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
//			String urls[] = {"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=ccd33b46d53f8794d7ff4b26e2207fc9/0d338744ebf81a4c0f993437d62a6059242da6a1.jpg","http://c.hiphotos.bdimg.com/album/s%3D900%3Bq%3D90/sign=b8658f17f3d3572c62e290dcba28121a/5fdf8db1cb134954bb97309a574e9258d0094a47.jpg"};
			String urls[] = {"file://"+DealImageActivity.IMAGE_DIR+"test100.jpg" + "","file://"+DealImageActivity.IMAGE_DIR+"test50.jpg"};
			intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
			intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, 1);
			startActivity(intent);
		}
		if(view.getId()==R.id.button21){
			Intent i = new Intent(this,ListViewItemAnimActivity.class);
			startActivity(i);
		}
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
//			Button button = (Button)rootView.findViewById(R.id.button1);
			return rootView;
		}
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
