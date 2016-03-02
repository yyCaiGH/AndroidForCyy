package org.cyy.demo.appdown;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

import org.cyy.demo.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DownloadTest extends Activity implements OnClickListener {
	public static final String PROGRESS_INFO_ACTION="org.cyy.demo.downprogress";
	
	public static final int BAIDU_NOTICE_ID=351;
	public static final int SOUGOU_NOTICE_ID=1071;
	public static final int JUNWANG_NOTICE_ID=1072;
	
	DownloadService.IDownloadApp binder;
	
	ReceiveProgressBroadCast broadCast;
	
	private TextView tv1,tv2,tv3;
	
//	private CustomClipLoading ccl;
	private ImageView ivPro;
	private ClipDrawable mClipDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_file);
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, conn, 0);//bind的方式，通过接口回调虽然可以返回进度信息，但是不方便同时让两个Activity获得进度 信息
        initView();
        registerReceiver();//注册监听进度的广播
        bindListener();
        getSingInfo();
    }
 
    private void initView() {
    	tv1 = (TextView)this.findViewById(R.id.textView1);
    	tv2 = (TextView)this.findViewById(R.id.textView2);
    	tv3 = (TextView)this.findViewById(R.id.textView3);
//    	ccl = (CustomClipLoading)this.findViewById(R.id.ccl_pro);
    	ivPro = (ImageView)this.findViewById(R.id.iv_progress);
    	mClipDrawable = (ClipDrawable) ivPro.getDrawable();
	}

	private void registerReceiver() {
    	broadCast = new ReceiveProgressBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(PROGRESS_INFO_ACTION);
        this.registerReceiver(broadCast, filter);
	}

	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(broadCast);
	};
	ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i("cyy-cyy", "``````````````````````````onServiceDisconnected");
			binder = null;
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i("cyy-cyy", "``````````````````````````onServiceConnected");
			binder = (DownloadService.IDownloadApp)service;
		}
	};
    void bindListener() {
        findViewById(R.id.btn_load_btn_one).setOnClickListener(this);
        findViewById(R.id.btn_load_btn_two).setOnClickListener(this);
        findViewById(R.id.btn_load_btn_three).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
    }
 
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn_load_btn_one:
        	/*binder.downloadApp(
                            "http://m.appchina.com/market/e/882602/0/16/44DFFDF6E89D0CC2F5CB41CE041E9BB7/packagename.apk?refererPage=m.cherry.soft_list",
                            BAIDU_NOTICE_ID, "百度知道", new ListenerProgress() {
								
								@Override
								public void downPro(int pro) {
									Log.i("cyy-cyy", "百度知道：bar="+pro);
								}
							});*/
        	Intent intent  = new Intent();  
            intent.setAction(DownloadService.DOWN_LOAD_APP_ACTION);  
            intent.putExtra("name", "百度知道");  
            intent.putExtra("notificationId", BAIDU_NOTICE_ID);
            intent.putExtra("url", "http://m.appchina.com/market/e/882602/0/16/44DFFDF6E89D0CC2F5CB41CE041E9BB7/packagename.apk?refererPage=m.cherry.soft_list");
            sendBroadcast(intent); 
            break;
        case R.id.btn_load_btn_two:
        	/*binder.downloadApp(
                            "http://m.appchina.com/market/e/886657/feature/1/360F5D5A76A3E0E397451CE9EA503DE6/com.sogou.novel?refererPage=m.cherry.soft_main",
                            SOUGOU_NOTICE_ID, "搜狗小说",new ListenerProgress() {
								
								@Override
								public void downPro(int bar) {
									Log.i("cyy-cyy", "搜狗小说：bar="+bar);
								}
							});*/
        	intent  = new Intent();  
            intent.setAction(DownloadService.DOWN_LOAD_APP_ACTION);  
            intent.putExtra("name", "搜狗小说");  
            intent.putExtra("notificationId", SOUGOU_NOTICE_ID);
            intent.putExtra("url", "http://m.appchina.com/market/e/886657/feature/1/360F5D5A76A3E0E397451CE9EA503DE6/com.sogou.novel?refererPage=m.cherry.soft_main");
            sendBroadcast(intent); 
            break;
        case R.id.btn_load_btn_three:
        	/*binder.downloadApp(
                            "http://m.appchina.com/market/e/885495/feature/2/360F5D5A76A3E0E397451CE9EA503DE6/com.king2.yyh?refererPage=m.cherry.soft_main",
                            JUNWANG_NOTICE_ID, "君王2(新服开启)",new ListenerProgress() {
								
								@Override
								public void downPro(int pro) {
									Log.i("cyy-cyy", "君王2(新服开启)：bar="+pro);
								}
							});*/
        	intent  = new Intent();  
            intent.setAction(DownloadService.DOWN_LOAD_APP_ACTION);  
            intent.putExtra("name", "君王2(新服开启)");  
            intent.putExtra("notificationId", JUNWANG_NOTICE_ID);
            intent.putExtra("url", "http://m.appchina.com/market/e/885495/feature/2/360F5D5A76A3E0E397451CE9EA503DE6/com.king2.yyh?refererPage=m.cherry.soft_main");
            sendBroadcast(intent); 
            break;
        case R.id.button1:
        	Intent i = new Intent(this,DownloadTest2.class);
        	startActivity(i);
        	break;
        default:
            break;
        }
    }
 
 
 
    public void getSingInfo() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(
                    "cn.zgst.bfzhjw", PackageManager.GET_SIGNATURES);
            Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];
            parseSignature(sign.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void parseSignature(byte[] signature) {
        try {
            CertificateFactory certFactory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert = (X509Certificate) certFactory
                    .generateCertificate(new ByteArrayInputStream(signature));
            String pubKey = cert.getPublicKey().toString();
            String signNumber = cert.getSerialNumber().toString();
            System.out.println("signName:"   +cert.getSigAlgName());
            System.out.println("pubKey:"   +pubKey);
            System.out.println("signNumber:"   +signNumber);
            System.out.println("subjectDN:" +cert.getSubjectDN().toString());
            List<String> extendKey =  cert.getExtendedKeyUsage();
            System.out.println("subjectDN_one:" +cert.getSubjectAlternativeNames());
            System.out.println("subjectDN_two:" +cert.getSubjectX500Principal());
            System.out.println("subjectDN_three:" +cert.getExtensionValue("SubjectKeyIdentifier"));
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 说明：自定义监听进度广播
     *
     * @author yy_cai
     *
     * 2016年2月29日
     */
    private class ReceiveProgressBroadCast extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			int progress = intent.getIntExtra("progress",-1);
			int notificationId = intent.getIntExtra("notificationId", -1);
			if(PROGRESS_INFO_ACTION.equals(action)){
//				downNewFile(url, notificationId, name);
				switch (notificationId) {
				case BAIDU_NOTICE_ID:
					tv1.setText("百度知道："+progress+"%");
					break;
				case SOUGOU_NOTICE_ID:
					tv2.setText("搜狗小说："+progress+"%");
					break;
				case JUNWANG_NOTICE_ID:
					tv3.setText("君王2："+progress+"%");
					mClipDrawable.setLevel(progress*100);
					break;
				default:
					break;
				}
			}
			
		}
    	
    }
}
