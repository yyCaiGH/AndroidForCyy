package org.cyy.demo.xutils;

import java.io.File;

import org.apache.http.NameValuePair;
import org.cyy.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class XUtilsActivity extends Activity{

	@ViewInject(R.id.et_xutils_phone)
	private EditText etPhone;
	@ViewInject(R.id.et_xutils_psw)
	private EditText etPsw;
	@ViewInject(R.id.btn_xutils_res)
	private Button btnRes;
	@ViewInject(R.id.btn_xutils_upload)
	private Button btnUpload;
	@ViewInject(R.id.tv_xutils_info)
	private TextView tvInfo;
	
	private String ip_port = "192.168.1.102:8080";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_xutils);
		ViewUtils.inject(this); //注入view和事件
	}
	
	@OnClick(R.id.btn_xutils_res)
	public void registerListener(View view){
		String phone = etPhone.getText().toString();
		String psw = etPsw.getText().toString();
		res(phone,psw);
	}
	@OnClick(R.id.btn_xutils_upload)
	public void uploadListener(View view){
		upload();
	}
	
	/**
	 * 注册
	 * @param phone
	 * @param psw
	 */
	private void res(String phone,String psw) {
		RequestParams params = new RequestParams();
//		params.addHeader("name", "value");
		params.addQueryStringParameter("user_phone", phone);
		params.addQueryStringParameter("password", psw);
		
		// 只包含字符串参数时默认使用BodyParamsEntity，
		// 类似于UrlEncodedFormEntity（"application/x-www-form-urlencoded"）。
//		params.addBodyParameter("name", "value");

		// 加入文件参数后默认使用MultipartEntity（"multipart/form-data"），
		// 如需"multipart/related"，xUtils中提供的MultipartEntity支持设置subType为"related"。
		// 使用params.setBodyEntity(httpEntity)可设置更多类型的HttpEntity（如：
		// MultipartEntity,BodyParamsEntity,FileUploadEntity,InputStreamUploadEntity,StringEntity）。
		// 例如发送json参数：params.setBodyEntity(new StringEntity(jsonStr,charset));
		
		String url = "http://"+ip_port+"/TimeTrading/user/register";
		send(url,params);
	}
	/**
	 * 上传
	 */
	private void upload(){
		RequestParams params = new RequestParams();
		params.addQueryStringParameter("_token", "8db28f1e-599a-4293-81c8-c54c55f32c79");
		params.addBodyParameter("file", new File(Environment.getExternalStorageDirectory(),"test.png"));
		String url = "http://"+ip_port+"/WebTest/client/user/update_face";
		send(url,params);
	}
	/**
	 * 网络请求
	 * @param url
	 * @param params
	 */
	private void send(String url,RequestParams params){
		HttpUtils http = new HttpUtils();
		http.send(HttpRequest.HttpMethod.POST,url,params,
		    new RequestCallBack<String>() {

		        @Override
		        public void onStart() {
		        	tvInfo.setText("conn...");
		        }

		        @Override
		        public void onLoading(long total, long current, boolean isUploading) {
		            if (isUploading) {
		                tvInfo.setText("upload: " + current + "/" + total);
		            } else {
		                tvInfo.setText("reply: " + current + "/" + total);
		            }
		        }

		        @Override
		        public void onSuccess(ResponseInfo<String> responseInfo) {
		            tvInfo.setText("reply:成功： " + responseInfo.result);
		        }

		        @Override
		        public void onFailure(HttpException error, String msg) {
		            tvInfo.setText("失败："+error.getExceptionCode() + ":" + msg);
		        }
		});
	}

}
