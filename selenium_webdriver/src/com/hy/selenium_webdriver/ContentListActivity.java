package com.hy.selenium_webdriver;

import android.R.xml;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ContentListActivity extends Activity{
	
	private ListView lv;
	private Myadapter adapter;
	private XmlParse xmlParse;
	private String[] titleData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contentlist);
		
		lv = (ListView) findViewById(R.id.lv);
		
		xmlParse = new XmlParse(getResources().openRawResource(R.raw.java));
		titleData = xmlParse.getTitleValue("c","title");
		adapter = new Myadapter(this, titleData);
		lv.setAdapter(adapter);
	}
}
