package org.cyy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class RotateImageView extends ImageView{

	/**旋转的动画*/
    private Animation mRotateAnimation;
    /**旋转动画的时间*/
    static final int ROTATION_ANIMATION_DURATION = 2000;
    /**动画插值*/
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    
	public RotateImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		float pivotValue = 0.5f;    // SUPPRESS CHECKSTYLE
        float toDegree = 720.0f;    // SUPPRESS CHECKSTYLE
        mRotateAnimation = new RotateAnimation(0.0f, toDegree, Animation.RELATIVE_TO_SELF, pivotValue,
                Animation.RELATIVE_TO_SELF, pivotValue);
        mRotateAnimation.setFillAfter(true);
        mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        mRotateAnimation.setDuration(ROTATION_ANIMATION_DURATION);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        mRotateAnimation.setRepeatMode(Animation.RESTART);
	}

	public void startRotate() {
		this.startAnimation(mRotateAnimation);
	}
	
	public void stopRotate() {
		this.clearAnimation();
	}
	
}
