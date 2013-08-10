package com.jingz.app.vp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button mSlidePage;
	private Button mZoomOutPage;
	private Button mDepthPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mSlidePage = (Button) findViewById(R.id.slide_page);
		mSlidePage.setOnClickListener(this);
		
		mZoomOutPage = (Button) findViewById(R.id.zoom_out_page);
		mZoomOutPage.setOnClickListener(this);
		
		mDepthPage = (Button) findViewById(R.id.depth_page);
		mDepthPage.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.slide_page:
			openSlidePage();
			break;
		case R.id.zoom_out_page:
			openZoomOutPage();
			break;
		case R.id.depth_page:
			openDepthPage();
			break;
		default:
			break;
		}
	}

	private void openDepthPage() {
		Intent intent = new Intent(this, SlidePageActivity.class);
		intent.putExtra("animation", SlidePageActivity.EXTRA_DEPTH);
		startActivity(intent);
	}

	private void openZoomOutPage() {
		Intent intent = new Intent(this, SlidePageActivity.class);
		intent.putExtra("animation", SlidePageActivity.EXTRA_ZOOM_OUT);
		startActivity(intent);
	}

	private void openSlidePage() {
		Intent intent = new Intent(this, SlidePageActivity.class);
		startActivity(intent);
	}

}
