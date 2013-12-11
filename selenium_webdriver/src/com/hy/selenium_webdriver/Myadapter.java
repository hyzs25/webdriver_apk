package com.hy.selenium_webdriver;

import android.content.Context;
import android.provider.Telephony.Sms.Conversations;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Myadapter extends BaseAdapter{
	private Context context;
	private String[] data;
	
	public Myadapter(Context context, String[] data){
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return data[index];
	}

	@Override
	public long getItemId(int index) {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.list, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.title);
		tv.setText(data[index]);
		
		return convertView;
	}

}
