package com.example.qqmediaplayer.ui;

import com.example.qqmediaplayer.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//三分钟后跳入主页
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Intent intent = new Intent();
				final Intent intent2 = new Intent(SplashActivity.this, MainActivity.class);
				ComponentName component = new ComponentName(SplashActivity.this, MainActivity.class);
				intent.setComponent(component);
				startActivity(intent2);
				finish();
			}
		}).start();
	}
}
