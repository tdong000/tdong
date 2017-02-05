package com.scott.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.scott.myapp.R;
import com.scott.myapp.activity.MainActivity;
import com.scott.myapp.adapter.MainPagerAdapter;
import com.scott.myapp.fragment.page.AudioListPage;
import com.scott.myapp.fragment.page.Page;
import com.scott.myapp.fragment.page.VideoListPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 */

public class MediaFragment extends Fragment implements View.OnClickListener {

    private ViewPager mViewPager;
    private TextView mTvAudio;
    private TextView mTvVideo;
    private View mViewIndicate;
    private List<Page> mFragments;
    private MainPagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_media,null,true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
        initData();

    }

    private void initData() {
        MainActivity activity = (MainActivity) getActivity();
        mFragments.add(new VideoListPage(activity));
        mFragments.add(new AudioListPage());

        mAdapter.notifyDataSetChanged();
        // 高亮第一个标签
        updateTabs(0);

        // 初始化指示器宽度
        int screenW = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        mViewIndicate.getLayoutParams().width = screenW / 2;
        mViewIndicate.requestLayout(); // 重新计算大小，并刷新控件
        //        indicate_line.invalidate(); // 刷新控件，不会重新计算大小

    }

    private void initListener() {
        mTvVideo.setOnClickListener(this);
        mTvAudio.setOnClickListener(this);

        mFragments = new ArrayList<Page>();
        mAdapter = new MainPagerAdapter(mFragments);
        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new OnMainPageChangeListener());
    }

    private void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.media_viewpager);
        mTvVideo = (TextView) view.findViewById(R.id.media_tv_video);
        mTvAudio = (TextView) view.findViewById(R.id.media_tv_audio);

        mViewIndicate = view.findViewById(R.id.media_indicate_line);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.media_tv_video:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.media_tv_audio:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    private class OnMainPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        /** 当touch事件发生时回调此方法 */
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //            logE("OnMainPageChangeListener.onPageScrolled: position="+position+";Pixels="+positionOffsetPixels);
            // 偏移位置 = 手指划过屏幕的百分比 * 指示器宽度
            int offsetX = (int) (positionOffset * mViewIndicate.getWidth());

            // 偏移位置2 = 手指划过屏幕的像素 / pager个数
            //            int offsetX = positionOffsetPixels / fragments.size();

            // 起始位置 = position * 指示器宽度
            int startX = position * mViewIndicate.getWidth();

            // 指示器移动的位置 = 起始位置 + 偏移位置
            int translationX = startX + offsetX;

            ViewHelper.setTranslationX(mViewIndicate, translationX);
        }

        @Override
        /** 当见面选中状态发生变更时会回调此方法 */
        public void onPageSelected(int position) {
            // 高亮选中页面对应的标签，并将其他的变暗
            updateTabs(position);
        }

        @Override
        /** 当页面的滑动状态发生变更会回调此方法 */
        public void onPageScrollStateChanged(int state) {

        }
    }

    /** 高亮position选中页面对应的标签，并将其他的变暗 */
    private void updateTabs(int position) {
        updateTab(position, 0, mTvVideo);
        updateTab(position, 1, mTvAudio);
    }

    /** 判断当前要处理的 tabPosition 是否是选中的 position，并修改tab的高亮状态 */
    private void updateTab(int position, int tabPosition, TextView tab) {
        int green = getResources().getColor(R.color.media_bg_green);
        int halfWhite = getResources().getColor(R.color.media_half_white);

        if (position == tabPosition){
            // tab对应的页面被选中
            tab.setTextColor(green);
            ViewPropertyAnimator.animate(tab).scaleX(1.2f).scaleY(1.2f);
        }else {
            // tab对应的页面没有被选中
            tab.setTextColor(halfWhite);
            ViewPropertyAnimator.animate(tab).scaleX(1.0f).scaleY(1.0f);
        }
    }
}
