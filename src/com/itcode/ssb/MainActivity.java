package com.itcode.ssb;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.itcode.ssb.adapter.ListViewAdapter;

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

		ssb = new SpannableStringBuilder("�������屳��ɫ ");
		ssb.setSpan(new BackgroundColorSpan(Color.GRAY), new String("��������").length(), new String("�������屳��ɫ ").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ���ñ���ɫΪ��ɫ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�����»���");
		// �����»���
		ssb.setSpan(new UnderlineSpan(), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("����ɾ����");
		ssb.setSpan(new StrikethroughSpan(),  0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�������±�:y=x3+An");
		//
		ssb.setSpan(new SuperscriptSpan(), new String("�������±�:y=x").length(), new String("�������±�:y=x2").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �±�
		ssb.setSpan(new SubscriptSpan(),  new String("�������±�:y=x3+a").length(), new String("�������±�:y=x3+an").length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �ϱ�
		spannablesbList.add(ssb);
		
		ssb = new SpannableStringBuilder("��������:�绰 ");
		ssb.setSpan(new URLSpan("tel:13912345678"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �绰
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:�ʼ� ");
		ssb.setSpan(new URLSpan("mailto:webmaster@google.com"),5, 7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �ʼ�
		ssb.setSpan(new ForegroundColorSpan(Color.YELLOW),5, 7,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:���� ");
		ssb.setSpan(new URLSpan("http://www.baidu.com"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new ForegroundColorSpan(Color.LTGRAY),5, 7,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:���� ");
		ssb.setSpan(new URLSpan("sms:13912345678"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new ForegroundColorSpan(Color.BLUE),5, 7,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:��ͼ ");
		ssb.setSpan(new URLSpan("geo:38.899533,-77.036476"), 5, 7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 
		ssb.setSpan(new ForegroundColorSpan(Color.GREEN),5, 7,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		// ע�⣺�������Ӻ�ָ��������ı�������ɫ������ס��ǰ���õ���ɫ������Ӧ���������Ӻ���Ϊָ�����������������ɫ
		ssb = new SpannableStringBuilder("��������:�ı� ");
		ssb.setSpan(new URLSpan("cacaca") {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "��������õ�����", 0).show();
			}
		}, 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED),5, 7,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);
		

		
		ssb = new SpannableStringBuilder("������Ŀ����");
		ssb.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN),  0, new String("������Ŀ����").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ��һ��������ʾ��Ŀ����ռ�õĿ�ȣ��ڶ�������Ϊ��Ŀ���ŵ���ɫ
		spannablesbList.add(ssb);
		
		ssb = new SpannableStringBuilder("����������ʽ���������壬б�壬��б�� ");
		// ����������ʽ���������壬б�壬��б��
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 6, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 9, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // б��
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ��б��
		spannablesbList.add(ssb);


		// ��������(default,default-bold,monospace,serif,sans-serif)
		String str = "��������(default,default-bold,monospace,serif,sans-serif)";
		ssb = new SpannableStringBuilder(str);
		ssb.setSpan(new TypefaceSpan("default"), 0, new String("��������(default,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("default-bold"), new String("��������(default,").length(), new String("��������(default,default-bold,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("monospace"), new String("��������(default,default-bold,").length(), new String("��������(default,default-bold,monospace,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("serif"), new String("��������(default,default-bold,monospace,").length(), new String("��������(default,default-bold,monospace,serif,").length(),
		Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("sans-serif"), new String("��������(default,default-bold,monospace,serif,").length(), new String("��������(default,default-bold,monospace,serif,sans-serif)").length(),
		Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("���������С(����ֵ����λ:����/��λ:����)");
		ssb.setSpan(new AbsoluteSizeSpan(20),new String("���������С(����ֵ,").length(), new String("���������С(����ֵ,��λ:����,").length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new AbsoluteSizeSpan(20, true),new String("���������С(����ֵ,��λ:����,").length(), new String("���������С(����ֵ,��λ:����,��λ:����)").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �ڶ�������boolean
																								// dip�����Ϊtrue����ʾǰ��������С��λΪdip������Ϊ���أ���ͬ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("���������С�����ֵ��һ��/����,��λ�����أ� ������ʾΪĬ�������С�Ķ��ٱ� ");
		ssb.setSpan(new RelativeSizeSpan(0.5f), new String("���������С�����ֵ��").length(), new String("���������С�����ֵ��һ��/").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 0.5f��ʾĬ�������С��һ��
		ssb.setSpan(new RelativeSizeSpan(2.0f), new String("���������С�����ֵ��һ��/").length(), new String("���������С�����ֵ��һ��/����,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 2.0f��ʾĬ�������С������
		spannablesbList.add(ssb);
	}

}
