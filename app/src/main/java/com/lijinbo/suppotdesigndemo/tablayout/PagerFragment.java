package com.lijinbo.suppotdesigndemo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lijinbo.suppotdesigndemo.R;

/**
 * Created by sky_li on 2016/11/16.
 * 说明:
 */

public class PagerFragment extends Fragment {

    public static final String PAGETEXT = "ARG_PAGE";
    private String  pageText;

    public static PagerFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString(PAGETEXT, text);
        PagerFragment pageFragment = new PagerFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageText = getArguments().getString(PAGETEXT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.pager_fragment_layout, container, false);
        TextView tv = (TextView) relativeLayout.findViewById(R.id.tv);
        tv.setText("Fragment" + pageText);
        return relativeLayout;
    }
}
