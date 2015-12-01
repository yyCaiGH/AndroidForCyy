package com.geihoo.activity;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.base.BaseActivity;
import com.geihoo.groups.R;
/**
 * 社团中发布帖子
 * @author whd
 *
 */
public class SendMessageActivity extends BaseActivity {
	private EditText etTitle,etContent;
	private static String oldContent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_send_message);
		initView();
		initContentData();
	}
	protected void initView() {
		initTopBar();
		this.findViewById(R.id.ll_essay_add_image).setOnClickListener(this);
		etTitle = (EditText)this.findViewById(R.id.et_essay_title);
		etContent = (EditText)this.findViewById(R.id.et_essay_content);
	}
	
	@Override
	protected void initTopBar() {
		TextView backView = (TextView) findViewById(R.id.tv_top_left);
		backView.setOnClickListener(this);
		TextView titleView = (TextView) findViewById(R.id.tv_top_title);
		titleView.setText("在 周末旅游 中");
		TextView sendView = (TextView) findViewById(R.id.tv_top_right);
		sendView.setText("发布");
		sendView.setOnClickListener(this);
	}
	
	private void initContentData() {
		String content = SendMessageActivity.oldContent;
		Log.i("cyy-cyy", "imagePath:" + content);
		if (content == null) {
			return;
		}
		SpannableString ss = new SpannableString(content);
		Pattern p = Pattern.compile("\\/storage\\/emulated\\/.*?(jpg|png|jpeg)");
		Matcher m = p.matcher(content);
		while (m.find()) {
			Log.i("cyy-cyy", "匹配一个:" + m.group());
			Bitmap photo = getSmallBitmap(m.group());
			if (photo == null) {
				Toast.makeText(this, "获取的图片地址有问题，请及时告知APP开发人员Y_C", Toast.LENGTH_LONG).show();
				return;
			}
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
			ImageSpan span = new ImageSpan(this, photo);
			ss.setSpan(span, m.start(), m.end(),
					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		etContent.setText(ss);

	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.ll_essay_add_image){
			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
					"image/*");
			startActivityForResult(intent, 3);
		}
		else if(v.getId()==R.id.tv_top_left||v.getId()==R.id.tv_top_right){
			//返回社团页面
			this.onBackPressed();
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		SendMessageActivity.oldContent = etContent.getText().toString();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK && requestCode == 3) {
			Uri uri = data.getData();
			String url = null;
			Cursor cur = getContentResolver()
					.query(uri, new String[] { MediaStore.Images.Media.DATA },
							null, null, null);
			if (cur != null && cur.moveToFirst()) {
				url = cur.getString(0);
				Log.i("cyy-cyy", "url:" + url);
			}
			Bitmap photo = getSmallBitmap(url);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 15, stream);// (0-100)压缩文件
			insertIntoEditText(getBitmapMime(photo, url));
		}
	}

	// 计算图片的缩放值
	public int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		Log.i("cyy-cyy", "height="+height+",width="+width);
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}
		Log.i("cyy-cyy", "inSampleSize="+inSampleSize);
		return inSampleSize;
	}

	// 根据路径获得图片并压缩，返回bitmap用于显示
	public Bitmap getSmallBitmap(String filePath) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, options);
		// Calculate inSampleSize 340, 450
		options.inSampleSize = calculateInSampleSize(options, 340, 450);
		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;

		return BitmapFactory.decodeFile(filePath, options);
	}
	
	/**
	 * 图片转化为SpannableString
	 * 
	 * @param pic
	 * @param uri
	 * @return
	 */
	private SpannableString getBitmapMime(Bitmap pic, String url) {
		SpannableString ss = new SpannableString(url);
		ImageSpan span = new ImageSpan(this, pic);
		ss.setSpan(span, 0, url.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return ss;
	}
	
	/**
	 * 插入图片SpannableString到EditText中
	 * 
	 * @param ss
	 */
	private void insertIntoEditText(SpannableString ss) {
		
		
		Editable et = etContent.getText();// 先获取Edittext中的内容
		int start = etContent.getSelectionStart();
		
		String content = etContent.getText().toString();
		if(start!=0){
			String endChar = content.substring(start-1, start);//光标后的那个位置
			
			if(!"\n".equals(endChar)){//前方没有换行符，则换行
				et.insert(start, "\n");
				start = etContent.getSelectionStart();
			}
		}
		et.insert(start, ss);// 设置ss要添加的位置
		start = etContent.getSelectionStart();
		et.insert(start, "\n");
		etContent.setText(et);// 把et添加到Edittext中
		etContent.setSelection(start + 1);// 设置Edittext中光标在最后面显示
		Log.i("cyy-cyy", "内容：" + etContent.getText().toString());
	}
}
