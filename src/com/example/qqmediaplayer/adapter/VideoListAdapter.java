package com.example.qqmediaplayer.adapter;

import com.example.qqmediaplayer.R;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VideoListAdapter extends CursorAdapter{
	private Context context;
	public VideoListAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
		this.context = context;
	}

	public VideoListAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}
	class ViewHolder{
		
	}
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		String duration = cursor.getString(cursor.getColumnIndex(Media.DURATION));
		String title = cursor.getString(cursor.getColumnIndex(Media.TITLE));
		String size = cursor.getString(cursor.getColumnIndex(Media.SIZE));
		View view = View.inflate(context, R.layout.item_videolist, null);
		TextView tv_videoduration = (TextView) view.findViewById(R.id.tv_videoduration);
		
		TextView tv_videoname = (TextView) view.findViewById(R.id.tv_videoname);
		TextView tv_videosize = (TextView) view.findViewById(R.id.tv_videosize);
		tv_videoduration.setText(duration);
		tv_videoname.setText(title);
		tv_videosize.setText(size);
		return view;
		
	}
/**
 * 应该是复用的view 绑定 新的值
 */
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		String duration = cursor.getString(cursor.getColumnIndex(Media.DURATION));
		String title = cursor.getString(cursor.getColumnIndex(Media.TITLE));
		String size = cursor.getString(cursor.getColumnIndex(Media.SIZE));
		TextView tv_videoduration = (TextView) view.findViewById(R.id.tv_videoduration);
		TextView tv_videoname = (TextView) view.findViewById(R.id.tv_videoname);
		TextView tv_videosize = (TextView) view.findViewById(R.id.tv_videosize);
		tv_videoduration.setText(duration);
		tv_videoname.setText(title);
		tv_videosize.setText(size);
	}

}
