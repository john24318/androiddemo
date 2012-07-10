package cn.com.hh;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class TabHostBottomActivity extends TabActivity implements TabContentFactory {
	private TabHost mTabHost;
	private TranslateAnimation mTranslateAnimation;
	private ImageView mImageView;
	private int mTabSpecWidth = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_bottom_main);
		
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this.getLocalActivityManager());
		
		TabSpec ts1 = mTabHost.newTabSpec("1");
		TextView tv1= new TextView(this);
		tv1.setText("买入");
		tv1.setHeight(40);
		tv1.setGravity(Gravity.CENTER);
		tv1.setBackgroundResource(R.drawable.select_tabhost_bg);
		
		ts1.setIndicator(tv1);
		ts1.setContent(this);
		mTabHost.addTab(ts1);
		TabSpec ts2 = mTabHost.newTabSpec("2");
		TextView tv2= new TextView(this);
		tv2.setText("卖出");
		tv2.setHeight(40);
		tv2.setGravity(Gravity.CENTER);
		tv2.setBackgroundResource(R.drawable.select_tabhost_bg);
		ts2.setIndicator(tv2);
		ts2.setContent(this);
		mTabHost.addTab(ts2);
		TabSpec ts3 = mTabHost.newTabSpec("3");
		TextView tv3= new TextView(this);
		tv3.setText("持仓");
		tv3.setHeight(40);
		tv3.setGravity(Gravity.CENTER);
		tv3.setBackgroundResource(R.drawable.select_tabhost_bg);
		ts3.setIndicator(tv3);
		ts3.setContent(this);
		mTabHost.addTab(ts3);
		TabSpec ts4 = mTabHost.newTabSpec("4");
		TextView tv4= new TextView(this);
		tv4.setText("成交");
		tv4.setHeight(40);
		tv4.setGravity(Gravity.CENTER);
		tv4.setBackgroundResource(R.drawable.select_tabhost_bg);
		ts4.setIndicator(tv4);
		ts4.setContent(this);
		mTabHost.addTab(ts4);
		TabSpec ts5 = mTabHost.newTabSpec("5");
		TextView tv5= new TextView(this);
		tv5.setText("撤单");
		tv5.setHeight(40);
		tv5.setGravity(Gravity.CENTER);
		tv5.setBackgroundResource(R.drawable.select_tabhost_bg);
		ts5.setIndicator(tv5);
		ts5.setContent(this);
		mTabHost.addTab(ts5);
		TabSpec ts6 = mTabHost.newTabSpec("6");
		TextView tv6= new TextView(this);
		tv6.setText("另TabHost");
		tv6.setHeight(40);
		tv6.setGravity(Gravity.CENTER);
		tv6.setBackgroundResource(R.drawable.select_tabhost_bg);
		ts6.setIndicator(tv6);
		ts6.setContent(this);
		mTabHost.addTab(ts6);
		
		mImageView = (ImageView)findViewById(R.id.imageView);
		mImageView.setAlpha(0);
	
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			int startX = 0;
			int endX =0;
			@Override
			public void onTabChanged(String tabId) {
				Log.d("TabHost", "OnTabChangeListener = "+tabId);
				mTabSpecWidth = mTabHost.getCurrentTabView().getWidth();
				Log.e("TabHost", "mTabSpecWidth ="+mTabSpecWidth+"\ngetChildCount="+mTabHost.getChildCount());
				
				endX = mTabSpecWidth*(Integer.parseInt(tabId)-1);
				
				mTranslateAnimation = new TranslateAnimation(startX,endX,0,0);
				mTranslateAnimation.setDuration(200);
				mTranslateAnimation.setFillEnabled(true);
				mTranslateAnimation.setFillAfter(true);
				mImageView.startAnimation(mTranslateAnimation);
				startX = endX;
				if(tabId.equals("6")){
				startActivity(new Intent(TabHostBottomActivity.this,TabHostActivity.class));	
				}
			}
		});
	}

	@Override
	public View createTabContent(String tag) {
		final TextView tv = new TextView(this);
		tv.setText("Content for tab with tag " + tag);
		return tv;
	}

}
