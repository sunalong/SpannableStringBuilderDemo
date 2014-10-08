package com.itcode.ssb;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView tvShowText;
	private SpannableStringBuilder ssb;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShowText = (TextView) findViewById(R.id.tvShowText);
//        String spannableSBText = "012345678901234567890123456789";
        String spannableSBText = "ThisisSpannableStringBuilderDemo!";
		setSpannableSBText(spannableSBText );
        
    }
	private void setSpannableSBText(String spannableSBText) {
		ssb = new SpannableStringBuilder(spannableSBText);
		/**
		 * Mark the specified range of text with the specified object.<br>
		 * 标记指定的范围使用指定的Object
		 * The flags determine how the span will behave when text is inserted at the start or end of the span's range.<br>
		 * flags决定了范围的开闭情况
		 */
		ssb.setSpan(new ForegroundColorSpan(Color.GREEN), 1, 2, Spannable.SPAN_COMPOSING);//基本使用_1：为指定的区间设置指定的颜色
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.BLUE), 6, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
		ssb.append("fuck!");//基本使用_2:追加字符
		ssb.setSpan(new ForegroundColorSpan(Color.RED), spannableSBText.length()-1, spannableSBText.length()+4, Spannable.SPAN_MARK_POINT);
		//基本使用_3:设置链接
			//注意：设置链接后，指定区间的文本会变成蓝色，会遮住以前设置的颜色，所以应在设置链接后再为指定区间的文字设置颜色
		ssb.setSpan( new URLSpan("cacaca"){
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "点击了设置的链接", 0).show();
			}
		}, spannableSBText.length()+2, spannableSBText.length()+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), spannableSBText.length()-1, spannableSBText.length()+4, Spannable.SPAN_MARK_POINT);
		tvShowText.setText(ssb);
		tvShowText.setMovementMethod(LinkMovementMethod.getInstance());//让链接的点击事件响应的必要一句代码
	}
	
}


































