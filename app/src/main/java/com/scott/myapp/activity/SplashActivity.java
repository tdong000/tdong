package com.scott.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.scott.myapp.R;
import com.scott.myapp.util.PackageUtil;

/**
 * Created by Administrator on 2017/2/2.
 */

public class SplashActivity extends BaseActivity {

    private TextView mTvSplash;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    break;
            }
        }
    };

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvSplash = (TextView) findViewById(R.id.tv_splash);
        mTvSplash.setText("版本号：" + PackageUtil.getVersionName(this));
        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void processClick(View v) {

    }
}
