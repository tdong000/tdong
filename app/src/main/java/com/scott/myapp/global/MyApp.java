package com.scott.myapp.global;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/2/5.
 */

public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContextObject(){
        return context;
    }
}
