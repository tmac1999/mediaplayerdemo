package com.example.qqmediaplayer.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initData();
		initView();
		return createView();
	}
/**
 * 初始化数据 在初始化视图之前
 * 
 *@author mrz
 */
	public abstract void initData();

	public abstract View createView();
	public abstract void initView();
}
