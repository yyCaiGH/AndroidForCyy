package org.cyy.demo.xutils;

import java.io.File;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.cyy.demo.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
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
	@ViewInject(R.id.btn_xutils_login)
	private Button btnLogin;
	@ViewInject(R.id.btn_xutils_upload)
	private Button btnUpload;
	@ViewInject(R.id.tv_xutils_info)
	private TextView tvInfo;
	@ViewInject(R.id.iv_xutils_face)
	private ImageView ivFace;
	private static String ip="192.168.0.104";
	private static String area="geihoo.f3322.net:2222";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_xutils);
		ViewUtils.inject(this); //注入view和事件
		BitmapUtils bitmapUtils = new BitmapUtils(this);
		// 加载网络图片
		bitmapUtils.display(ivFace, "http://geihoo.f3322.net:2222/image_upload/12320151114113856.jpg");
//		Log.i("cyy-cyy", getAlpha("你好啊"));
		 
	}
	
	public static String getAlpha(String str) {
		if (str == null) {
			return "#";
		}

		if (str.trim().length() == 0) {
			return "#";
		}

		char c = str.trim().substring(0, 1).charAt(0);
		Log.i("cyy-cyy", "c="+c);
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		if (pattern.matcher(c + "").matches()) {
			return String.valueOf(c).toUpperCase();
		} else {
			return "#";
		}
	}
	@OnClick(R.id.btn_xutils_res)
	public void registerListener(View view){
		String phone = etPhone.getText().toString();
		String psw = etPsw.getText().toString();
		res(phone,psw);
	}
	@OnClick(R.id.btn_xutils_login)
	public void LoginListener(View view){
		String phone = etPhone.getText().toString();
		String psw = etPsw.getText().toString();
		login(phone,psw);
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
		
		String url = "http://"+ip+":8080/TimeTrading/user/register";
		send(url,params);
	}
	private void login(String phone,String psw){
		RequestParams params = new RequestParams();
		params.addQueryStringParameter("user_phone", phone);
		params.addQueryStringParameter("password", psw);
		String url = "http://"+ip+":8080/TimeTrading/user/login";
		send(url,params);
	}
	/**
	 * 上传
	 */
	private void upload(){
		RequestParams params = new RequestParams();
		params.addQueryStringParameter("_token", "b43a07b5-c221-419b-a11a-43d30ee16139");
		params.addBodyParameter("file", new File(getCacheDir().getPath()+"/bg.jpg"));
//		String url = "http://"+ip+":8080/TimeTrading/user/update_face";
		String url = "http://"+area+"/WebTest/client/user/update_face";
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
		            try {
		            	String str = responseInfo.result.toString();
		            	JSONObject ja = new JSONObject(str);
						Log.i("cyy-cyy", ja.get("result_code").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		        }

		        @Override
		        public void onFailure(HttpException error, String msg) {
		            tvInfo.setText("失败："+error.getExceptionCode() + ":" + msg);
		        }
		});
	}

}
