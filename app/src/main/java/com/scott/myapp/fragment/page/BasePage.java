package com.scott.myapp.fragment.page;

import android.view.View;

import com.scott.myapp.global.MyApp;

/**
 * Created by Administrator on 2017/2/5.
 */

public abstract class BasePage implements Page {
    @Override
    public View onCreateView() {
        View view = View.inflate(MyApp.getContextObject(), setLayoutRes(), null);
        onViewCreated(view);
        return view;
    }

    public abstract int setLayoutRes();

    protected abstract void onViewCreated(View view);
}
