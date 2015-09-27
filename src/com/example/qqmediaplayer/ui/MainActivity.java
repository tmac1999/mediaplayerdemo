package com.example.qqmediaplayer.ui;

import java.util.ArrayList;

import com.example.qqmediaplayer.R;
import com.example.qqmediaplayer.R.layout;
import com.example.qqmediaplayer.R.menu;
import com.example.qqmediaplayer.adapter.MainPagerAdapter;
import com.example.qqmediaplayer.ui.fragment.AudioFragment;
import com.example.qqmediaplayer.ui.fragment.VideoFragment;
import com.example.qqmediaplayer.utils.GlobalUtils;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.DragEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
public class MainActivity extends BaseActivity {


	private ViewPager viewpager_main;
	private MainPagerAdapter mainPagerAdapter;
	private ArrayList<Fragment> fragments;
	private View view_indicator;
	@Override
	public void initView() {
		setContentView(R.layout.activity_main);
		viewpager_main = (ViewPager) findViewById(R.id.viewpager_main);
		view_indicator = findViewById(R.id.view_indicator);
		FragmentManager fm = getSupportFragmentManager();
		fragments = new ArrayList<Fragment>();
		AudioFragment audioFragment = new AudioFragment();
		VideoFragment videoFragment = new VideoFragment();
		fragments.add(videoFragment);
		fragments.add(audioFragment);
		mainPagerAdapter = new MainPagerAdapter(fm,fragments);
		viewpager_main.setAdapter(mainPagerAdapter);
		initIndicator();
		viewpager_main.setOnDragListener(new OnDragListener() {
			
			@Override
			public boolean onDrag(View v, DragEvent event) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		viewpager_main.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				
			}
			/**
			 * 根据位置变化动态改变indicator
			 */
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				moveIndicatorWithScrolled(positionOffsetPixels);
			}
			

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
	}
/**
 * 初始化indicator的位置
 * 
 *@author mrz
 */
	private void initIndicator() {
		android.view.ViewGroup.LayoutParams params = view_indicator.getLayoutParams();
		int windowWidth = GlobalUtils.getWidth(getBaseContext());
		params.width = windowWidth/fragments.size();
		view_indicator.requestLayout();
	}
	/**
	 * 根据viewpager的移动来移动indicator
	 * 
	 *@author mrz
	 */
	private void moveIndicatorWithScrolled(int positionOffsetPixels) {
		
	}

	@Override
	public void initData() {
		
	}
		
}
