package com.example.qqmediaplayer.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter{

	public MainPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}
	private ArrayList<Fragment> fragments ;
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}
