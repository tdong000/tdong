package com.scott.myapp.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.scott.myapp.R;
import com.scott.myapp.fragment.AccountFragment;
import com.scott.myapp.fragment.HomeFragment;
import com.scott.myapp.fragment.MediaFragment;
import com.scott.myapp.fragment.MoreFragment;
import com.scott.myapp.fragment.ReaderFragment;
import com.stephentuso.welcome.WelcomeHelper;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private WelcomeHelper mWelcomeHelper;
    private ConvenientBanner mConvenientBanner;
    private BottomBar mBottomBar;
    private FrameLayout mFragementContrainer;
    private ArrayList<Fragment> mFragments;

    @Override

    protected void setStatusBarState() {
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mWelcomeHelper = new WelcomeHelper(this, MyWelcomeActivity.class);
        mWelcomeHelper.show(savedInstanceState);
        mConvenientBanner = (ConvenientBanner) findViewById(R.id.convenient_banner);
        mBottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        mFragementContrainer = (FrameLayout) findViewById(R.id.fragment_container);
        initFragment();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        //创建出每个按钮的界面
        HomeFragment homeFragment = new HomeFragment();
        MediaFragment mediaFragment = new MediaFragment();
        ReaderFragment readerFragment = new ReaderFragment();
        AccountFragment accountFragment = new AccountFragment();
        MoreFragment moreFragment = new MoreFragment();

        mFragments.add(homeFragment);
        mFragments.add(mediaFragment);
        mFragments.add(readerFragment);
        mFragments.add(accountFragment);
        mFragments.add(moreFragment);

        changeFragment(0);
    }

    private void changeFragment(int index) {
        Fragment fragment = mFragments.get(index);
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    protected void initListener() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        changeFragment(0);
                        break;
                    case R.id.tab_media:
                        changeFragment(1);
                        break;
                    case R.id.tab_reader:
                        changeFragment(2);
                        break;
                    case R.id.tab_account:
                        changeFragment(3);
                        break;
                    case R.id.tab_more:
                        changeFragment(4);
                        break;
                    default:
                        changeFragment(0);
                        break;
                }
            }
        });

        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                //                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void processClick(View v) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWelcomeHelper.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
