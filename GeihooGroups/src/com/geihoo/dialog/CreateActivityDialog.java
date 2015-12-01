package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ToastUtil;

public class CreateActivityDialog extends BaseDialog {
	private TextView stratDate,showStartData,endDate,showEndDate;
	private static String tag = "CreateActivityDialog";
	private Context context;
	public CreateActivityDialog(Context context) {
		super(context);
		setContentView(R.layout.dialog_create_activity);
		this.context = context;
		initView();
		
	}

	protected void initView() {
		TextView back = (TextView)this.findViewById(R.id.tv_top_left);
		back.setOnClickListener(this);
		TextView title = (TextView)this.findViewById(R.id.tv_top_title);
		title.setText("白富美的活动");
		TextView finish = (TextView)this.findViewById(R.id.tv_top_right);
		finish.setText("完成");
		finish.setOnClickListener(this);
		
		stratDate = (TextView) findViewById(R.id.tv_act_start_date_key);
		showStartData = (TextView) findViewById(R.id.tv_act_start_data_value);
		endDate = (TextView) findViewById(R.id.tv_act_end_date_key);
		showEndDate = (TextView)findViewById(R.id.tv_act_end_date_value);
		showStartData.setOnClickListener(this);
		showEndDate.setOnClickListener(this);
		
		TextView placeSelect = (TextView)this.findViewById(R.id.tv_act_place_select);
		placeSelect.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v==showStartData) {
			DateDialog.showTimeSelector(context, getLayoutInflater(), showStartData);
		} else if (v==showEndDate) {
			DateDialog.showTimeSelector(context, getLayoutInflater(), showEndDate);
		}
		else if(v.getId()==R.id.tv_top_right){
			ToastUtil.showTextLong(context, "创建活动完成");
			this.cancel();
		}
		else if(v.getId()==R.id.tv_act_place_select){
			new SelectActivityPlaceDialog(context).show();
		}
		super.onClick(v);
	}

}
