package com.xiejiantao.cagames.di.component;

import android.app.Activity;


import com.xiejiantao.cagames.di.ActivityScope;
import com.xiejiantao.cagames.di.module.ActivityModule;
import com.xiejiantao.cagames.ui.main.activity.MainActivity;
import com.xiejiantao.cagames.ui.main.activity.WelcomeActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);
//
    void inject(MainActivity mainActivity);
//
//    void inject(ZhihuDetailActivity zhihuDetailActivity);
//
//    void inject(ThemeActivity themeActivity);
//
//    void inject(SectionActivity sectionActivity);
}
