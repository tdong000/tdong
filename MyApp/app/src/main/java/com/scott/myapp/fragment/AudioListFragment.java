package com.scott.myapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/2/5.
 */
public class AudioListFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("AudioListFragment");
        textView.setTextColor(Color.BLACK);
        return textView;
    }
}
