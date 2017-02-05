package com.scott.myapp.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.scott.myapp.R;

/**
 * Created by Administrator on 2017/2/3.
 */

public class PackageUtil {

    public static String getVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        PackageInfo packageInfo;
        try {
            packageInfo = manager.getPackageInfo(context.getPackageName(), Context.MODE_PRIVATE);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return context.getResources()
                .getString(R.string.version_name);
    }

    public static int getVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();
        PackageInfo packageInfo;
        try {
            packageInfo = manager.getPackageInfo(context.getPackageName(), Context.MODE_PRIVATE);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
