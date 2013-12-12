package com.hy.selenium_webdriver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class DetailActivity extends Activity{
	
	private TextView conTextView,titleTextView;
	private XmlParse xml;
	private String version,content,detail_title;
	private int index;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_detail);
//		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebtn); 
		
		conTextView = (TextView) findViewById(R.id.content);
		titleTextView = (TextView) findViewById(R.id.detail_title);
		version = getIntent().getStringExtra("version");
		index = getIntent().getIntExtra("index", 0);
		detail_title = getIntent().getStringExtra("title");
		
		if (version.equals("JAVA")) {
			xml = new XmlParse(getResources().openRawResource(R.raw.java));
		}else if (version.equals("RUBY")) {
			xml = new XmlParse(getResources().openRawResource(R.raw.ruby));
		}else if (version.equals("PYTHON")) {
			xml = new XmlParse(getResources().openRawResource(R.raw.python));
		}else if (version.equals("WATIR-WEBDRIVER")) {
			xml = new XmlParse(getResources().openRawResource(R.raw.watir_webdriver));
		}
		content = xml.getContent("c", index);
		titleTextView.setText(detail_title);
		conTextView.setText(content);
	}
	
}
