package org.cyy.demo.customview;

import java.util.List;

import org.cyy.demo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MyAdapter extends ArrayAdapter<String> {  
	  
    public MyAdapter(Context context, int textViewResourceId, List<String> objects) {  
        super(context, textViewResourceId, objects);  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        View view;  
        if (convertView == null) {  
            view = LayoutInflater.from(getContext()).inflate(R.layout.my_list_view_item, null);  
        } else {  
            view = convertView;  
        }  
        Button textView = (Button) view.findViewById(R.id.text_view);  
        textView.setText(getItem(position));  
        return view;  
    }  
  
}
