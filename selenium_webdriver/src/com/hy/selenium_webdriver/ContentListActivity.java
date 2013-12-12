package com.hy.selenium_webdriver;

import android.R.xml;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ContentListActivity extends Activity implements OnItemClickListener{
	
	private ListView lv;
	private TextView tView;
	private Myadapter adapter;
	private XmlParse xmlParse;
	private String[] titleData;
	private String getIn;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contentlist);
		
		lv = (ListView) findViewById(R.id.lv);
		tView = (TextView) findViewById(R.id.list_version);
		
		xmlParse = new XmlParse(getResources().openRawResource(R.raw.java));
		titleData = xmlParse.getTitleValue("c","title");
		adapter = new Myadapter(this, titleData);
		lv.setAdapter(adapter);
		
		getIn = getIntent().getStringExtra("name");

		tView.setText(getIn + "°æ");
		
		lv.setOnItemClickListener(this);
	
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
		// TODO Auto-generated method stub
		intent = new Intent(ContentListActivity.this, DetailActivity.class);
		intent.putExtra("version", getIn);
		intent.putExtra("index", index);
		intent.putExtra("title", titleData[index]);
		startActivity(intent);
	}
}
