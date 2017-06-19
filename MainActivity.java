package com.baway.zuoye;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private ViewPager vp;
	private List<View> list;
	private Button jump;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (isfirst()) {
			goActivity();
			finish();
			return;
			
		}
		
		initView();
		
		initData();
		
		initViewpagerAdapter();

	}

	public Boolean isfirst() {
		Boolean flag = (Boolean) SharedPreferenceDamo.getParams(
				MainActivity.this, "flag", false);

		return flag;
	}

	private void initViewpagerAdapter() {

		vp.setAdapter(new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {

				return list != null ? list.size() : 0;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(list.get(position));
				return list.get(position);

			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(list.get(position));
			}

		});
	}

	private void initData() {
		
		View view1=View.inflate(MainActivity.this, R.layout.layout1, null);
		View view2=View.inflate(MainActivity.this, R.layout.layout2, null);
		View view3=View.inflate(MainActivity.this, R.layout.layout3, null);
		
		jump = (Button) view2.findViewById(R.id.btnJump);
		
		jump.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferenceDamo.saveParams(MainActivity.this, "flag",
						true);

				goActivity();
				
				
				finish();
			}

		});
		list = Arrays.asList(view1, view3,view2);

	}

	private void goActivity() {
		Intent intent = new Intent(MainActivity.this, TwoActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.in1, R.anim.out2);
	}

	private void initView() {
		
		vp = (ViewPager) findViewById(R.id.vp);
	}

}
