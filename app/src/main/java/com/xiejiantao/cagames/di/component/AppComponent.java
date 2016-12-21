package com.xiejiantao.cagames.di.component;

import com.xiejiantao.cagames.app.App;
import com.xiejiantao.cagames.di.ContextLife;
import com.xiejiantao.cagames.di.module.AppModule;
import com.xiejiantao.cagames.model.db.RealmHelper;
import com.xiejiantao.cagames.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xiejiantao on 2016/12/21.
 */
@Singleton
@Component(modules = AppModule.class)
public interface  AppComponent {

    @ContextLife("Application")
    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类
}
