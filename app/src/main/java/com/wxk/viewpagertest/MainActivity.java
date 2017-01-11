package com.wxk.viewpagertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  private BlankFragment mFragment1;
  private BlankFragment mFragment2;
  private BlankFragment mFragment3;
  private BlankFragment mFragment4;
  private BlankFragment mFragment5;
  private ViewPager mViewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
    initData();
  }

  private void initData() {
    mFragment1 = BlankFragment.newInstance("壹");
    mFragment2 = BlankFragment.newInstance("贰");
    mFragment3 = BlankFragment.newInstance("叁");
    mFragment4 = BlankFragment.newInstance("肆");
    mFragment5 = BlankFragment.newInstance("伍");
    mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int position) {
        switch (position) {
          case 0:
            return mFragment1;
          case 1:
            return mFragment2;
          case 2:
            return mFragment3;
          case 3:
            return mFragment4;
          case 4:
            return mFragment5;
          default:
            break;
        }
        return null;
      }

      @Override
      public int getCount() {
        return 5;
      }
    });
    mViewPager.setOffscreenPageLimit(1);//默认缓存的页面数量,设置1,左右各1个,如果超出这个范围的页面将会执行onDestroyView()
  }

  private void initView() {
    mViewPager = ((ViewPager) findViewById(R.id.viewPager));
  }
}
