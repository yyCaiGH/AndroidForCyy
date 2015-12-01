package com.geihoo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.geihoo.groups.R;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView iv = (ImageView)this.findViewById(R.id.iv_geihoo);
        iv.setAnimation(AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.anim_welcome_go_up));
        
        ImageView iv2 = (ImageView)this.findViewById(R.id.iv_geihoo_come);
        iv2.setAnimation(AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.anim_zoom_out));
        
        new Handler().postDelayed(new Runnable(){
			public void run(){
				Intent intent = new Intent ();
				intent.setClass(WelcomeActivity.this,SignupLoginActivity.class);
				startActivity(intent);
				WelcomeActivity.this.overridePendingTransition(R.anim.anim_welcome_entry, R.anim.anim_welcome_out);
				WelcomeActivity.this.finish();
			}
		}, 2500);
    }

}
