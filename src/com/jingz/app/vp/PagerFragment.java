package com.jingz.app.vp;

import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerFragment extends Fragment {
	
	private static final String TAG = "PagerFragment";
	
	private static final int[] PAGE_COLORS = {
		0xffff5555, 0xff55ff55, 0xff5555ff, 0xff123456, 0xff654321
	};
	
	private int mPosition;
	private TextView mPositionView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate ... " + mPosition);
		super.onCreate(savedInstanceState);
	}

	public PagerFragment(int position) {
		mPosition = position;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView ... " + mPosition);
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_view_page, container, false);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d(TAG, "onActivityCreated ... " + mPosition);
		super.onActivityCreated(savedInstanceState);
		
	}

	@Override
	public void onResume() {
		Log.d(TAG, "onResume ... " + mPosition);
		super.onResume();
		
		mPositionView = (TextView) getView().findViewById(R.id.position);
		mPositionView.setText(String.valueOf(mPosition));
		mPositionView.setBackgroundColor(PAGE_COLORS[mPosition]);
		
		Log.d(TAG, "Text: " + mPositionView.getText());
	}

}
