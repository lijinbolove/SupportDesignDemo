package com.lijinbo.suppotdesigndemo.bottomnavigationview;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.lijinbo.suppotdesigndemo.R;

public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        mTextView = (TextView) findViewById(R.id.tv);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                mTextView.setText(title);
                int i=10/0;
                return true;
            }
        });
    }
}
