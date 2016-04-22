package org.cyy.demo.refresh;

import org.cyy.demo.R;
import org.cyy.view.refresh.LoadingLayout;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 这个类封装了下拉刷新的布局
 * 
 * @author yyCai
 * @since 2016-5-24
 */
public class HeaderLoadingImageLayout extends LoadingLayout {
    
    /**Header的容器*/
    private RelativeLayout mHeaderContainer;
    /**箭头图片*/
    private ImageView mArrowImageView;
    /**动画*/
    private AnimationDrawable animDrawable;
    /**
     * 构造方法
     * 
     * @param context context
     */
    public HeaderLoadingImageLayout(Context context) {
        super(context);
        init(context);
    }

    /**
     * 构造方法
     * 
     * @param context context
     * @param attrs attrs
     */
    public HeaderLoadingImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化
     * 
     * @param context context
     */
    private void init(Context context) {
        mHeaderContainer = (RelativeLayout) findViewById(R.id.pull_to_refresh_header_content);
        mArrowImageView = (ImageView) findViewById(R.id.pull_to_refresh_header_arrow);
        
        animDrawable =(AnimationDrawable)getResources().getDrawable(R.anim.anim_mucun_logo);
        mArrowImageView.setImageDrawable(animDrawable);
        
    }

    @Override
    public void setLastUpdatedLabel(CharSequence label) {
    }

    @Override
    public int getContentSize() {
        if (null != mHeaderContainer) {
            return mHeaderContainer.getHeight();
        }
        
        return (int) (getResources().getDisplayMetrics().density * 60);
    }
    
    @Override
    protected View createLoadingView(Context context, AttributeSet attrs) {
        View container = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_image, null);
        return container;
    }
    
    @Override
    protected void onStateChanged(State curState, State oldState) {
        super.onStateChanged(curState, oldState);
    }

    @Override
    protected void onReset() {
    	animDrawable.stop();
    }

    @Override
    protected void onPullToRefresh() {
    }

    @Override
    protected void onReleaseToRefresh() {
    }

    @Override
    protected void onRefreshing() {
    	animDrawable.start();
    }
}
