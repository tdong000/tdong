package com.scott.myapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.scott.myapp.R;

/**
 * Created by Administrator on 2017/2/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarState();
        setContentView(setLayoutId());
        initView(savedInstanceState);
        initListener();
        initData();
    }

    protected void setStatusBarState() {

    }

    protected abstract int setLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                processClick(v);
        }
    }

    protected abstract void processClick(View v);
}
