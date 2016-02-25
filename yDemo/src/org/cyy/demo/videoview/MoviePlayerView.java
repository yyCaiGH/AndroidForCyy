package org.cyy.demo.videoview;
import java.io.IOException;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
 
/**
 * 视频播放控件
*@author liuyinjun
 
* @date 2015-2-8
 */
public class MoviePlayerView extends SurfaceView {
 
    private SurfaceHolder mSurfaceHolder;
    private MediaPlayer mPlayer;
     
    public MoviePlayerView(Context context) {
        this(context, null);
    }
     
    public MoviePlayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
     
    public MoviePlayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
         
        mSurfaceHolder = this.getHolder();
        mSurfaceHolder.addCallback(mSurfaceHolderCallback); // holder加入回调接口
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);// setType必须设置，要不出错.
 
    }
     
    /**
     * 播放视频
     * @param fileName 文件路径
     */
    public void play(String fileName, final OnPlayCompletionListener completionListener) {
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        
 
        mPlayer.setOnCompletionListener(new OnCompletionListener() {
 
            @Override
            public void onCompletion(MediaPlayer arg0) {
                stop();
                if(completionListener != null)
                    completionListener.onPlayCompletion();
                // canvas.drawColor(Color.TRANSPARENT,
                // PorterDuff.Mode.CLEAR);
            }
        });
 
        try {
            mPlayer.setDataSource(fileName);
            mPlayer.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mPlayer.start();
    }
 
    private void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
 
    /**
     * 释放资源
     */
    public void release() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
     
    private Callback mSurfaceHolderCallback = new Callback() {
 
        @Override
        public void surfaceDestroyed(SurfaceHolder arg0) {
            mSurfaceHolder = null;
        }
 
        @Override
        public void surfaceCreated(SurfaceHolder arg0) {
            // TODO Auto-generated method stub
            mSurfaceHolder = arg0;
            mPlayer.setDisplay(mSurfaceHolder); // 定义一个SurfaceView播放它
        }
 
        @Override
        public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2,
                int arg3) {
            // TODO Auto-generated method stub
            mSurfaceHolder = arg0;
        }
    };
     
    /**
     * 播放成功回调
    *@author liuyinjun
     
    * @date 2015-2-9
     */
    public interface OnPlayCompletionListener{
        public void onPlayCompletion();
    }
 
}