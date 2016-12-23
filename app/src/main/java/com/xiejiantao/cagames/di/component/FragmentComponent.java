package com.xiejiantao.cagames.di.component;

import android.app.Activity;


import com.xiejiantao.cagames.di.FragmentScope;
import com.xiejiantao.cagames.di.module.FragmentModule;
import com.xiejiantao.cagames.ui.cagames.fragment.CasualGamesFragment;
import com.xiejiantao.cagames.ui.main.fragment.SettingFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(CasualGamesFragment dailyFragment);
//
//    void inject(ThemeFragment themeFragment);
//
//    void inject(SectionFragment sectionFragment);
//
//    void inject(HotFragment hotFragment);
//
//    void inject(CommentFragment longCommentFragment);
//
//    void inject(TechFragment techFragment);
//
//    void inject(GirlFragment girlFragment);
//
//    void inject(LikeFragment likeFragment);
//
//    void inject(WechatMainFragment wechatMainFragment);
//
    void inject(SettingFragment settingFragment);
//
//    void inject(GoldMainFragment goldMainFragment);
//
//    void inject(GoldPagerFragment goldPagerFragment);
}
