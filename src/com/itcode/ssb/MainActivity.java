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
		 * ���ָ���ķ�Χʹ��ָ����Object The flags determine how the span will behave when
		 * text is inserted at the start or end of the span's range.<br>
		 * flags�����˷�Χ�Ŀ������
		 */
		ssb = new SpannableStringBuilder("Ϊָ��������[1,4)����ָ������ɫ");
		ssb.setSpan(new ForegroundColorSpan(Color.GREEN), 1, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);// ����ʹ��_1��Ϊָ������������ָ������ɫ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("׷���ַ�");
		ssb.append("fuck!");// ����ʹ��_2:׷���ַ�
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 4, 8, Spannable.SPAN_MARK_POINT);
		spannablesbList.add(ssb);

		// ����ʹ��_3:��������
		// ע�⣺�������Ӻ�ָ��������ı�������ɫ������ס��ǰ���õ���ɫ������Ӧ���������Ӻ���Ϊָ�����������������ɫ
		ssb = new SpannableStringBuilder("��������");
		ssb.setSpan(new URLSpan("cacaca") {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "��������õ�����", 0).show();
			}
		}, 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 2,4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);
	}

}
