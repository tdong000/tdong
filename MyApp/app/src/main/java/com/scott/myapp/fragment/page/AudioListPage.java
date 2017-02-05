package com.scott.myapp.fragment.page;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.scott.myapp.global.MyApp;

/**
 * Created by Administrator on 2017/2/5.
 */
public class AudioListPage implements Page {
    @Override
    public View onCreateView() {
        TextView textView = new TextView(MyApp.getContextObject());
        textView.setText("AudioListPage");
        textView.setTextColor(Color.BLACK);
        return textView;
    }
}
