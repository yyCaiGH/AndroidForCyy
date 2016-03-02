package org.cyy.demo.appdown;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.cyy.demo.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
 
public class DownloadService extends Service{
 
	public static final String DOWN_LOAD_APP_ACTION="org.cyy.demo.downloadapp";
	private DownLoadAppBinder mBinder;
	private DownLoadAppBroadCast broadCast;
    private NotificationManager nm;
    private Notification notification;
    private MyHandler myHandler;
    private ExecutorService executorService = Executors.newFixedThreadPool(5); // 固定五个线程来执行任务
    private Map<Integer,Integer> download = new HashMap<Integer, Integer>();
    private Context context;
    @Override
    public IBinder onBind(Intent intent) {
    	Log.i("cyy-cyy", "====================onBind");
        return mBinder;
    }
 
    @Override
    public void onCreate() {
    	Log.i("cyy-cyy", "====================onCreate");
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        myHandler = new MyHandler(Looper.myLooper(), DownloadService.this);
        context = this;
        
        mBinder = new DownLoadAppBinder();
        
        broadCast = new DownLoadAppBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(DOWN_LOAD_APP_ACTION);
        this.registerReceiver(broadCast, filter);
    }
 
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	Log.i("cyy-cyy", "====================onStartCommand");
    	return super.onStartCommand(intent, flags, startId);
    }
    @Override
	public boolean onUnbind(Intent intent) {
    	Log.i("cyy-cyy", "====================onUnbind");
		return super.onUnbind(intent);
	}

    
    @Override
    public void onDestroy() {
    	Log.i("cyy-cyy", "====================onDestroy");
        super.onDestroy();
        unregisterReceiver(broadCast);
    }
 
    /**
     * （Activity调用Service的方法）第一种方式：
     * 直接public开发给外部接口调用，封装性不好
     * @param url
     * @param notificationId
     * @param name
     * @param progress 
     */
    public void downNewFile(String url,int notificationId,String name, ListenerProgress progress){
        if(download.containsKey(notificationId))
            return;
        notification = new Notification();
        notification.icon = R.drawable.delete_x;
        // notification.icon=android.R.drawable.stat_sys_download_done;
        notification.tickerText = name+"开始下载";
        notification.when = System.currentTimeMillis();
        notification.defaults = Notification.DEFAULT_LIGHTS;
        //显示在“正在进行中”
        notification.flags = Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;
        PendingIntent contentIntent = PendingIntent.getActivity(context, notificationId,new Intent(context, DownloadTest.class), 0);
        notification.setLatestEventInfo(context, name, "0%", contentIntent);
        download.put(notificationId, 0);
        // 将下载任务添加到任务栏中
        nm.notify(notificationId, notification);
        // 启动线程开始执行下载任务
        downFile(url,notificationId,name,progress);
        
    }
     
    // 下载更新文件
    private void downFile(final String url,final int notificationId,final String name, final ListenerProgress progress) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                File tempFile = null;
                try {
                    HttpClient client = new DefaultHttpClient();
                    // params[0]代表连接的url
                    HttpGet get = new HttpGet(url);
                    HttpResponse response = client.execute(get);
                    HttpEntity entity = response.getEntity();
                    long length = entity.getContentLength();
                    InputStream is = entity.getContent();
                    if (is != null) {
                        File rootFile = new File(Environment.getExternalStorageDirectory(),"/zhtrade");
                        if (!rootFile.exists() && !rootFile.isDirectory())
                            rootFile.mkdir();
 
                        tempFile = new File(Environment.getExternalStorageDirectory(),"/zhtrade/"+url.substring(url.lastIndexOf("/"),url.indexOf("?"))+"_"+notificationId+".apk");
                        if (tempFile.exists())
                            tempFile.delete();
                        tempFile.createNewFile();
 
                        // 已读出流作为参数创建一个带有缓冲的输出流
                        BufferedInputStream bis = new BufferedInputStream(is);
 
                        // 创建一个新的写入流，讲读取到的图像数据写入到文件中
                        FileOutputStream fos = new FileOutputStream(tempFile);
                        // 已写入流作为参数创建一个带有缓冲的写入流
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
 
                        int read;
                        long count = 0;
                        int precent = 0;
                        byte[] buffer = new byte[1024];
                        while ((read = bis.read(buffer)) != -1) {
                            bos.write(buffer, 0, read);
                            count += read;
                            precent = (int) (((double) count / length) * 100);
                            // 每下载完成1%就通知任务栏进行修改下载进度
                            Intent intent  = new Intent();  
                            intent.setAction(DownloadTest.PROGRESS_INFO_ACTION);  
                            intent.putExtra("notificationId", notificationId);
                            if (precent - download.get(notificationId) >= 5) {
                            	Log.i("cyy-cyy", precent+"%");
                                download.put(notificationId, precent);
                                Message message = myHandler.obtainMessage(3,name);
                                message.arg1 = notificationId;
                                myHandler.sendMessage(message);
//                                progress.downPro(precent);通过binder返回进度信息的方式
                                
                                //发送广播通知注册了该广播的所有client现在的进度信息
                                intent.putExtra("progress", precent);  
                                sendBroadcast(intent);
                            }
                        }
                        bos.flush();
                        bos.close();
                        fos.flush();
                        fos.close();
                        is.close();
                        bis.close();
                    }
 
                    if (true) {
                        Message message = myHandler.obtainMessage(2, tempFile);
                        message.arg1 = notificationId;
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name);
                        message.setData(bundle);
                        myHandler.sendMessage(message);
                    } else {
                        tempFile.delete();
                    }
                } catch (ClientProtocolException e) {
                    if (tempFile.exists())
                        tempFile.delete();
                    Message message = myHandler.obtainMessage(4, name +"下载失败：网络异常！");
                    message.arg1 = notificationId;
                    myHandler.sendMessage(message);
                } catch (IOException e) {
                    if (tempFile.exists())
                        tempFile.delete();
                    Message message = myHandler.obtainMessage(4, name +"下载失败：文件传输异常");
                    message.arg1 = notificationId;
                    myHandler.sendMessage(message);
                } catch (Exception e) {
                    if (tempFile.exists())
                        tempFile.delete();
                    Message message = myHandler.obtainMessage(4, name +"下载失败," +e.getMessage());
                    message.arg1 = notificationId;
                    myHandler.sendMessage(message);
                }
            }
        });
    }
 
    // 安装下载后的apk文件
    private void Instanll(File file, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
        context.startActivity(intent);
    }
 
    /* 事件处理类 */
    class MyHandler extends Handler {
        private Context context;
 
        public MyHandler(Looper looper, Context c) {
            super(looper);
            this.context = c;
        }
 
        @Override
        public void handleMessage(Message msg) {
            PendingIntent contentIntent = null;
            super.handleMessage(msg);
            if (msg != null) {
                switch (msg.what) {
                case 0:
                    Toast.makeText(context, msg.obj.toString(),Toast.LENGTH_SHORT).show();
                    download.remove(msg.arg1);
                    break;
                case 1:
                    break;
                case 2:
                    contentIntent = PendingIntent.getActivity(DownloadService.this, msg.arg1,new Intent(DownloadService.this, DownloadTest.class), 0);
                    notification.setLatestEventInfo(DownloadService.this, msg.getData().getString("name") +"下载完成",   "100%",contentIntent);
                    nm.notify(msg.arg1, notification);
                    // 下载完成后清除所有下载信息，执行安装提示
                    download.remove(msg.arg1);
                    nm.cancel(msg.arg1);
                    Instanll((File) msg.obj, context);
                    break;
                case 3:
                    contentIntent = PendingIntent.getActivity(DownloadService.this, msg.arg1,new Intent(DownloadService.this, DownloadTest.class), 0);
                    notification.setLatestEventInfo(DownloadService.this, msg.obj.toString() +"正在下载",  download.get(msg.arg1)  + "%",contentIntent);
                    nm.notify(msg.arg1, notification);
                    break;
                case 4:
                    Toast.makeText(context, msg.obj.toString(),Toast.LENGTH_SHORT).show();
                    download.remove(msg.arg1);
                    nm.cancel(msg.arg1);
                    break;
                }
            }
        }
    }
     
    /**
     * （Activity调用Service的方法）第二种方式：
     * 说明：client直接通过bindService获取binder来调取接口
     *
     * @author yy_cai
     *
     * 2016年2月29日
     */
	private class DownLoadAppBinder extends Binder implements IDownloadApp{

		@Override
		public void downloadApp(String url,int notificationId,String name,ListenerProgress progress) {
			downNewFile(url, notificationId, name,progress);
		}
    	
    }
 
	/**
	 * 
	 * 说明：监听进度接口
	 *
	 * @author yy_cai
	 *
	 * 2016年2月29日
	 */
	interface ListenerProgress{
		void downPro(int pro);//下载进度
	}
	/**
	 * 
	 * 说明：让binder提供业务接口，ListenerProgress返回进度信息
	 *
	 * @author yy_cai
	 *
	 * 2016年2月29日
	 */
    interface IDownloadApp{
    	void downloadApp(String url,int notificationId,String name,ListenerProgress listener);
    }
    
    /**
     * （Activity调用Service的方法）第三种方式
     * 说明：通过广播来调用服务端的接口
     *
     * @author yy_cai
     *
     * 2016年2月29日
     */
    private class DownLoadAppBroadCast extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			String url = intent.getStringExtra("url");
			int notificationId = intent.getIntExtra("notificationId", -1);
			String name = intent.getStringExtra("name");
			if(DOWN_LOAD_APP_ACTION.equals(action)){
				downNewFile(url, notificationId, name,null);
			}
			
		}
    	
    }
}