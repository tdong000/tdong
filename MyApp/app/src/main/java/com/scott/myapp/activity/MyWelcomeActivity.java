package com.scott.myapp.activity;

import com.scott.myapp.R;
import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

/**
 * Created by Administrator on 2017/2/3.
 */

public class MyWelcomeActivity extends WelcomeActivity {
    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this).defaultBackgroundColor(R.color.background)
                .page(new TitlePage(R.mipmap.bg1, "Title"))
                .page(new BasicPage(R.mipmap.bg2, "Header", "description").background(
                        R.color.background))
                .page(new BasicPage(R.mipmap.bg3,"Fott","sdadsd"))
                .swipeToDismiss(true)
                .build();
    }
}
