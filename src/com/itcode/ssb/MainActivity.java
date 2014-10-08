package com.itcode.ssb;

import java.util.ArrayList;
import java.util.List;

import com.itcode.ssb.adapter.ListViewAdapter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private SpannableStringBuilder ssb;
	List<SpannableStringBuilder> spannablesbList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.lvShowText);
		setSpannableSBText();
		listView.setAdapter(new ListViewAdapter(MainActivity.this, spannablesbList));
	}

	private void setSpannableSBText() {
		if (spannablesbList == null)
			spannablesbList = new ArrayList<SpannableStringBuilder>();

		/**
		 * Mark the specified range of text with the specified object.<br>
		 * 标记指定的范围使用指定的Object The flags determine how the span will behave when
		 * text is inserted at the start or end of the span's range.<br>
		 * flags决定了范围的开闭情况
		 */
		ssb = new SpannableStringBuilder("为指定的区间[1,4)设置指定的颜色");
		ssb.setSpan(new ForegroundColorSpan(Color.GREEN), 1, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);// 基本使用_1：为指定的区间设置指定的颜色
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("追加字符");
		ssb.append("fuck!");// 基本使用_2:追加字符
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 4, 8, Spannable.SPAN_MARK_POINT);
		spannablesbList.add(ssb);

		// 基本使用_3:设置链接
		// 注意：设置链接后，指定区间的文本会变成蓝色，会遮住以前设置的颜色，所以应在设置链接后再为指定区间的文字设置颜色
		ssb = new SpannableStringBuilder("设置链接");
		ssb.setSpan(new URLSpan("cacaca") {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "点击了设置的链接", 0).show();
			}
		}, 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 2,4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);
	}

}
