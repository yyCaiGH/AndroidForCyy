package org.cyy.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class MyLetterListView extends View {
    private final static String TAG="MyLetterListView";
    OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    String[] b = {"#","A","B","C","D","E","F","G","H","I","J","K","L"
            ,"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    int choose = -1;
    Paint paint = new Paint();
    float Ratio =1f;
    /**
     * 在点击的时候设为true，从而可以在调用ondraw的时候改变view的背景
     */
    boolean showBkg = false;
    public MyLetterListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
 
    public MyLetterListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getRatio((Activity)context);
    }
 
    public MyLetterListView(Context context) {
        super(context);
    }
 
    /**
     * 获得字体要缩放的比率
     */
    private void getRatio(Activity activity){
    	DisplayMetrics displayMetrics = new DisplayMetrics();  
    	activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);  
    	int screenWidth = displayMetrics.widthPixels;  
    	int screenHeight = displayMetrics.heightPixels;  
    	float ratioWidth = (float)screenWidth / 480;  
    	float ratioHeight = (float)screenHeight / 800;  
    	Ratio = Math.min(ratioWidth, ratioHeight);  
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(showBkg){
            canvas.drawColor(Color.parseColor("#20000000"));
        }
        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / b.length;
        for(int i=0;i<b.length;i++){
           paint.setColor(Color.GRAY);
           paint.setTextSize(15*Ratio);
           paint.setTypeface(Typeface.DEFAULT_BOLD);//设置字体
           paint.setAntiAlias(true);//防止边缘的锯齿
           if(i == choose){
               paint.setColor(Color.parseColor("#3399ff"));
               paint.setFakeBoldText(true);
           }
           //计算字母放置的位置
           float xPos = width/2  - paint.measureText(b[i])/2;//让字母居中
           float yPos = singleHeight * i + singleHeight;
           canvas.drawText(b[i], xPos, yPos, paint);
           paint.reset();
        }
 
    }
 
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    	super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();//得到的y值是这个view范围内的y轴的值，也就是这个view的左上角（x，y）=（0，0），而不是从屏幕的边缘计算的
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y/getHeight()*b.length);//计算出在一定范围内所点击的位置是属于某个字母的
 
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showBkg = true;
                if(oldChoose != c && listener != null){
                    if(c > 0 && c< b.length){
                        listener.onTouchingLetterChanged(b[c]);
                        choose = c;
                        invalidate();//刷新界面,会调用ondraw（）
                    }
                }
 
                break;
            case MotionEvent.ACTION_MOVE:
                if(oldChoose != c && listener != null){
                    if(c > 0 && c< b.length){
                        listener.onTouchingLetterChanged(b[c]);
                        choose = c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                showBkg = false;
                choose = -1;
                invalidate();
                break;
        }
        return true;
    }
 
 
    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }
    /**
     * 回调接口，使用者可以继承这个接口，并重写接口里的方法，当用户者要用这个控件的时候，只需要为这个控件设置该监听，
     * 即调用setOnTouchingLetterChangedListener这个方法来给出使用者重写后的监听类的对象，这时候本控件的
     * onTouchingLetterChangedListener引用就会指向使用者的对象，在上面的调用操作，比如listener.onTouchingLetterChanged(b[c]);
     * 就会因为类的多态特性（父类引用指向子类对象，调用的方法是子类的方法），而去调用使用者重写的方法，实现回调的机制！
     * @author cyy
     *
     */
    public interface OnTouchingLetterChangedListener{
        public void onTouchingLetterChanged(String s);
    }
 
}
