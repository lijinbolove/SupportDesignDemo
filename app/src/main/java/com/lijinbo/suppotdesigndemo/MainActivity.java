package com.lijinbo.suppotdesigndemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout mDrawerLayout; //抽屉布局
    private MenuItem currentSelectedMenu; //当前选中的 导航menu
    private NavigationView mLeftNavigation; //左侧导航菜单
    private Toolbar mToolbar;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle("");//必须在setSupportActionBar 之前调用才有效
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mLeftNavigation = (NavigationView) findViewById(R.id.left_navigation);
        mLeftNavigation.setItemIconTintList(null);//设置了此属性 自己设置的icon才能显示出来  否则icon显示不出来一直是灰色

        mLeftNavigation.setNavigationItemSelectedListener(this);
        initDrawerToggle();

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        findViewById(R.id.floating_action_button).setOnClickListener(this);
    }

    private void initDrawerToggle() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        //设置左上角图标颜色
        DrawerArrowDrawable drawerArrowDrawable = new DrawerArrowDrawable(this);
        drawerArrowDrawable.setColor(Color.WHITE);
        drawerToggle.setDrawerArrowDrawable(drawerArrowDrawable);
        drawerToggle.syncState();//同步状态
        mDrawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (currentSelectedMenu != null) {
            currentSelectedMenu.setChecked(false);
        }
        if (item.getItemId() == R.id.logout || item.getItemId() == R.id.exit) {
            currentSelectedMenu = null;
        } else {
            item.setChecked(true);
            currentSelectedMenu = item;
        }
        mDrawerLayout.closeDrawer(mLeftNavigation);
        switch (item.getItemId()) {
            case R.id.g1_m1:
                showSnackBar("主页");
                break;
            case R.id.g1_m2:
                showSnackBar("发动态");
                break;
            case R.id.g1_m3:
                showSnackBar("拍照");
                break;
            case R.id.g1_m4:
                showSnackBar("定位");
                break;
            case R.id.logout:
                showSnackBar("注销");
                break;
            case R.id.exit:
                showSnackBar("退出");
                break;
        }
        return true;
    }


    private void showSnackBar(final String text) {
        Snackbar.make(mDrawerLayout, text, Snackbar.LENGTH_INDEFINITE).setAction("点击关闭", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.GREEN).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floating_action_button:
                Snackbar.make(mCoordinatorLayout, "哈哈哈哈", Snackbar.LENGTH_INDEFINITE).setAction("点击关闭", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "哈哈哈哈", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }
}
