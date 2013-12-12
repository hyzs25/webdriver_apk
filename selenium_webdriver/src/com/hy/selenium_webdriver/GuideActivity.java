package com.hy.selenium_webdriver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GuideActivity extends Activity implements OnClickListener{
	
	private Button javaBtn,rubyBtn,pythonBtn,watirBtn;
	private Intent intent; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		
		javaBtn = (Button) findViewById(R.id.javaBtn);
		rubyBtn = (Button) findViewById(R.id.rubyBtn);
		pythonBtn = (Button) findViewById(R.id.pythonBtn);
		watirBtn = (Button) findViewById(R.id.watirBtn);
		
		javaBtn.setOnClickListener(this);
		rubyBtn.setOnClickListener(this);
		pythonBtn.setOnClickListener(this);
		watirBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		intent = new Intent(GuideActivity.this,ContentListActivity.class);
		switch(v.getId()){
		case R.id.javaBtn: 
			intent.putExtra("name", "JAVA");
			break;
		case R.id.rubyBtn:
			intent.putExtra("name", "RUBY");
			break;
		case R.id.pythonBtn: 
			intent.putExtra("name", "PYTHON");
			break;
		case R.id.watirBtn:
			intent.putExtra("name", "WATIR-WEBDRIVER");
			break;
		}
		startActivity(intent);
	}

}
