package org.cyy.demo;

import org.cyy.demo.customview.CustomViewActivity;
import org.cyy.demo.dragsortlistview.CursorDSLV;
import org.cyy.demo.dragsortlistview.DSLVActivity;
import org.cyy.demo.essay.EssayActivity;
import org.cyy.demo.fragment.MainTab;
import org.cyy.demo.ontouchevent.TestActivity;
import org.cyy.demo.videoview.VideoViewActivity;
import org.cyy.demo.xutils.XUtilsActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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
