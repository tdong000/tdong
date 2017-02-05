package com.scott.myapp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.scott.myapp.fragment.page.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 */
public class MainPagerAdapter extends PagerAdapter{

    private List<Page> mFragments;

    public MainPagerAdapter(List<Page> fragments) {
        this.mFragments = fragments;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mFragments.get(position)
                .onCreateView();
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mFragments.get(position).onCreateView());
    }
}
