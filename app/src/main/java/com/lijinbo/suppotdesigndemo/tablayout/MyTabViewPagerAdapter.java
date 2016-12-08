package com.lijinbo.suppotdesigndemo.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sky_li on 2016/11/16.
 * 说明: ViewPager  的Adapter
 */

public class MyTabViewPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"主页", "联系人", "动态", "我的"};

    public MyTabViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(titles[position]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }


}
