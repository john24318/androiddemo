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
	 * ֻ�����ֵ�ѡ�
	 * @param context
	 * @param str
	 */
	public TabHostView(Context context, String str) {
		this(context,str,0,true);
	}
	/**
	 * �������ֺ�ͼƬ��ѡ�
	 * @param context
	 * @param str ����
	 * @param imageResourceId ͼƬ
	 */
	public TabHostView(Context context, String str, int imageResourceId) {
		this(context,str,imageResourceId,true);

	}
	/**
	 * �������ֺ�ͼƬ��ѡ�,ͼƬ���ϣ���������
	 * @param context
	 * @param str ����
	 * @param imageResourceId ͼƬ
	 * @param topNavigation ��������
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
	 * ��ʼ��ѡ�
	 */
	private void initTabHostView(){
		
	}
}
