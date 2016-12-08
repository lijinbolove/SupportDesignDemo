package com.lijinbo.suppotdesigndemo.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lijinbo.suppotdesigndemo.R;

public class TabLayoutAndFragmentActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_fragment);

        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mViewPager.setAdapter(new MyTabViewPagerAdapter(getSupportFragmentManager(), this));
        mTablayout.setupWithViewPager(mViewPager);



    }
}
