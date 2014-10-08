package com.itcode.ssb.adapter;

import java.util.List;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itcode.ssb.R;

public class ListViewAdapter extends BaseAdapter {

	private Context context;
	private List<SpannableStringBuilder> list;
	private TextView tvShowText;

	public ListViewAdapter(Context context, List<SpannableStringBuilder> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(context, R.layout.item_listview, null);
		tvShowText = (TextView) view.findViewById(R.id.tvShowText);
		tvShowText.setText(list.get(position));
		if (position == 2)
			tvShowText.setMovementMethod(LinkMovementMethod.getInstance());// 让链接的点击事件响应的必要一句代码
		return view;
	}

}
