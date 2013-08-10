package com.jingz.app.vp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentActivity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;

public class SlidePageActivity extends FragmentActivity {

	private static final int PAGE_NUM = 5;
	
	public static final int EXTRA_ZOOM_OUT = 0;
	public static final int EXTRA_DEPTH = 1;
	
	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_pager);
		
		
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new SlidePageAdapter(getFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		
		Intent intent = getIntent();
		int animation = intent.getIntExtra("animation", -1);
		if (animation != -1) {
			PageTransformer pt = createPageTransformer(animation);
			mViewPager.setPageTransformer(true, pt);
		}
	}

	private PageTransformer createPageTransformer(int animation) {
		switch (animation) {
		case 0:
			return new ZoomOutPageTransformer();
		case 1:
			return new DepthPageTransformer();
		default:
			return null;
		}
		
	}

	@Override
	public void onBackPressed() {
		
		int curr = mViewPager.getCurrentItem();
		if ( curr == 0) {
			super.onBackPressed();
		} else {
			mViewPager.setCurrentItem(curr - 1);
		}
		
	}
	
	private static class SlidePageAdapter extends FragmentStatePagerAdapter {

		public SlidePageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return new PagerFragment(position);
		}

		@Override
		public int getCount() {
			return PAGE_NUM;
		}
		
	}

	
}
