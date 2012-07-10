package cn.com.hh;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabHostActivity extends TabActivity implements TabContentFactory {
private TabHost mTabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main);
		
//		mTabHost = getTabHost();
//		mTabHost.addTab(mTabHost
//				.newTabSpec("tab1")
//				.setIndicator("买入",
//						null)
//				.setContent(new Intent(TabHostActivity.this,BuyInActivity.class)));
//		mTabHost.addTab(mTabHost
//				.newTabSpec("tab2")
//				.setIndicator("卖出",
//						null)
//				.setContent(this));
//		mTabHost.addTab(mTabHost
//				.newTabSpec("tab3")
//				.setIndicator("持仓",
//						null)
//				.setContent(this));
//		mTabHost.addTab(mTabHost
//				.newTabSpec("tab4")
//				.setIndicator("可撤单",
//						null)
//				.setContent(this));
//		mTabHost.addTab(mTabHost
//				.newTabSpec("tab5")
//				.setIndicator("成交",
//						null)
//				.setContent(this));
		
		
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this.getLocalActivityManager());
		
		TabSpec ts1 = mTabHost.newTabSpec("TAB_1");
		TabHostView thv1 = new TabHostView(this, "TEST1",R.drawable.test);
//		TabHostView thv1 = new TabHostView(this, "TEST1");
		thv1.setBackgroundResource(R.drawable.select_tabhost_img_bg);
		ts1.setIndicator((View)thv1);
		ts1.setContent(this);
		mTabHost.addTab(ts1);
		TabSpec ts2 = mTabHost.newTabSpec("TAB_2");
		TabHostView thv2 = new TabHostView(this, "TEST2",R.drawable.test);
//		TabHostView thv2 = new TabHostView(this, "TEST2");
		thv2.setBackgroundResource(R.drawable.select_tabhost_img_bg);
		ts2.setIndicator(thv2);
		ts2.setContent(this);
		mTabHost.addTab(ts2);
		TabSpec ts3 = mTabHost.newTabSpec("TAB_3");
		TabHostView thv3 = new TabHostView(this, "TEST3",R.drawable.test);
//		TabHostView thv3 = new TabHostView(this, "TEST3");
		thv3.setBackgroundResource(R.drawable.select_tabhost_img_bg);
		ts3.setIndicator(thv3);
		ts3.setContent(this);
		mTabHost.addTab(ts3);
		TabSpec ts4 = mTabHost.newTabSpec("TAB_4");
		TabHostView thv4 = new TabHostView(this, "TEST4",R.drawable.test);
//		TabHostView thv4 = new TabHostView(this, "TEST4");
		thv4.setBackgroundResource(R.drawable.select_tabhost_img_bg);
		ts4.setIndicator(thv4);
		ts4.setContent(this);
		mTabHost.addTab(ts4);
		TabSpec ts5 = mTabHost.newTabSpec("TAB_5");
		TabHostView thv5 = new TabHostView(this, "TEST5",R.drawable.test,false);
//		TabHostView thv5 = new TabHostView(this, "TEST5");
		thv5.setBackgroundResource(R.drawable.select_tabhost_img_bg);
		ts5.setIndicator(thv5);
		ts5.setContent(this);
		mTabHost.addTab(ts5);
		
		TabSpec ts6 = mTabHost.newTabSpec("TAB_6");
		TabHostView thv6 = new TabHostView(this, "另TabHost",R.drawable.test,false);
//		TabHostView thv6 = new TabHostView(this, "另TabHost",R.drawable.test);
//		TabHostView thv6 = new TabHostView(this, "另TabHost");
		thv6.setBackgroundResource(R.drawable.select_tabhost_img_bg);
		ts6.setIndicator(thv6);
		ts6.setContent(this);
		mTabHost.addTab(ts6);
		
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				if(tabId.equals("TAB_6")){
					startActivity(new Intent(TabHostActivity.this,TabHostBottomActivity.class));
				}
			}
		});
		
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		super.onContentChanged();
	}
	
	@Override
	public View createTabContent(String arg0) {
		final TextView tv = new TextView(this);
		tv.setText("Content for tab with tag " + arg0);
		return tv;
	}
}
