package org.cyy.demo.essay;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cyy.demo.MainActivity;
import org.cyy.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EssayActivity extends Activity implements OnClickListener {

	EditText et_tuwen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_essay);
		et_tuwen = (EditText) this.findViewById(R.id.et_tuwen);
		initTuwen();
		// ImageView iv_essay = (ImageView)this.findViewById(R.id.iv_essay);
		// Bitmap photo =
		// BitmapFactory.decodeFile("/storage/emulated/0/PhotoWallFalls/1377949481_6577.jpg");
		// iv_essay.setImageBitmap(photo);
	}

	private void initTuwen() {
		String imagePath = MainActivity.tuwen;
		Log.i("cyy-cyy", "imagePath:" + imagePath);
		if (imagePath == null) {
			return;
		}
		SpannableString ss = new SpannableString(imagePath);
		Pattern p = Pattern.compile("\\/storage\\/emulated\\/.*?(jpg|png)");
		Matcher m = p.matcher(imagePath);
		while (m.find()) {
			Log.i("cyy-cyy", "匹配一个:" + m.group());
//			Bitmap photo = BitmapFactory.decodeFile(m.group());
			Bitmap photo = getSmallBitmap(m.group());
			if (photo == null) {
				Toast.makeText(this, "获取的图片地址有问题", Toast.LENGTH_LONG).show();
				return;
			}
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
			ImageSpan span = new ImageSpan(this, photo);
			ss.setSpan(span, m.start(), m.end(),
					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		et_tuwen.setText(ss);

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
	 * 插入SpannableString到EditText中
	 * 
	 * @param ss
	 */
	private void insertIntoEditText(SpannableString ss) {
		Editable et = et_tuwen.getText();// 先获取Edittext中的内容
		int start = et_tuwen.getSelectionStart();
		et.insert(start, ss);// 设置ss要添加的位置
		et_tuwen.setText(et);// 把et添加到Edittext中
		et_tuwen.setSelection(start + ss.length());// 设置Edittext中光标在最后面显示
		Log.i("cyy-cyy", "内容：" + et_tuwen.getText().toString());
	}

	private Bitmap getBitmapFromUri(Uri uri) {
		try {
			Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
					.openInputStream(uri));
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.b01) {
			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
					"image/*");
			startActivityForResult(intent, 3);
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		MainActivity.tuwen = et_tuwen.getText().toString();
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
//			Bitmap photo = BitmapFactory.decodeFile(url);
			Bitmap photo = getSmallBitmap(url);
//			Bitmap photo = getBitmapFromUri(uri);
			
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
		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, 240, 320);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;

		return BitmapFactory.decodeFile(filePath, options);
	}
}
