package cn.com.hh;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabHostView extends LinearLayout {

	private Context mContext;
	private LinearLayout parent;
	private TextView mTextView;
	private ImageView mImageView;

	public TabHostView(Context context) {
		super(context);
	}
	/**
	 * 只有文字的选项卡
	 * @param context
	 * @param str
	 */
	public TabHostView(Context context, String str) {
		this(context,str,0,true);
	}
	/**
	 * 含有文字和图片的选项卡
	 * @param context
	 * @param str 文字
	 * @param imageResourceId 图片
	 */
	public TabHostView(Context context, String str, int imageResourceId) {
		this(context,str,imageResourceId,true);

	}
	/**
	 * 含有文字和图片的选项卡,图片在上，文字在下
	 * @param context
	 * @param str 文字
	 * @param imageResourceId 图片
	 * @param topNavigation 导航方向
	 */
	public TabHostView(Context context, String str, int imageResourceId,boolean topNavigation) {
		super(context);
		mContext = context;
		mTextView = new TextView(context);
		mTextView.setText(str);
		mTextView.setGravity(Gravity.CENTER);
		if(imageResourceId != 0){
			this.setOrientation(LinearLayout.VERTICAL);
			this.setGravity(Gravity.CENTER);
			mImageView = new ImageView(context);
			mImageView.setImageResource(imageResourceId);
			if(topNavigation ==true){
				this.addView(mImageView,new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT));
				this.addView(mTextView,new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT));
			}else{
				this.addView(mTextView,new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT));
				this.addView(mImageView,new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT));
			}
			
		}else{
			this.addView(mTextView,new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
		}

	}
	
	
	/**
	 * 初始化选项卡
	 */
	private void initTabHostView(){
		
	}
}
