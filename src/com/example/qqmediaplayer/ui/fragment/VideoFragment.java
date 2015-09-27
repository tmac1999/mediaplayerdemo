package com.example.qqmediaplayer.ui.fragment;

import java.net.URI;

import com.example.qqmediaplayer.R;
import com.example.qqmediaplayer.adapter.VideoListAdapter;

import android.R.integer;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class VideoFragment extends BaseFragment{

	private ListView lv_video;

	@Override
	public View createView() {
		View view = View.inflate(getActivity(), R.layout.fragment_video, null);
		lv_video = (ListView) view.findViewById(R.id.lv_video);
		return view;
	}

	@Override
	public void initView() {
		
	}

	@Override
	public void initData() {
		//ContentResolver cResolver = new ContentResolver(getActivity()) {
			
		//};
		
		ContentResolver resolver = getActivity().getContentResolver();
		AsyncQueryHandler handler = new AsyncQueryHandler(resolver) {
			@Override
			protected void onQueryComplete(int token, Object cookie,
					Cursor cursor) {
				VideoListAdapter adapter = new VideoListAdapter(getActivity(), cursor, true);
				lv_video.setAdapter(adapter);
				super.onQueryComplete(token, cookie, cursor);
			}
		};
//		Parameters:
//			token A token passed into onQueryComplete to identify the query.
//			cookie An object that gets passed into onQueryComplete
//			uri The URI, using the content:// scheme, for the content to retrieve.
//			projection A list of which columns to return. Passing null will return all columns, which is discouraged to prevent reading data from storage that isn't going to be used.
//			selection A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given URI.
//			selectionArgs You may include ?s in selection, which will be replaced by the values from selectionArgs, in the order that they appear in the selection. The values will be bound as Strings.
//			orderBy How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
		int token = 0;
		Object cookie = null;
		Uri uri = Media.EXTERNAL_CONTENT_URI;
		getActivity().grantUriPermission(getActivity().getPackageName(), uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
		String[] projection = {Media._ID, Media.TITLE, Media.DURATION, Media.SIZE, Media.DATA};
		String selection = null;
		String[] selectionArgs = null;
		String orderBy = Media.TITLE+" asc";
		handler.startQuery(token, cookie, uri, projection, selection, selectionArgs, orderBy);
	}
		
}
