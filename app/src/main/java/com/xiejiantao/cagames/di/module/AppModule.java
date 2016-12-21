package com.xiejiantao.cagames.di.module;

import android.app.Application;

import com.xiejiantao.cagames.app.App;
import com.xiejiantao.cagames.di.ContextLife;
import com.xiejiantao.cagames.model.db.RealmHelper;
import com.xiejiantao.cagames.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiejiantao on 2016/12/21.
 */
@Module
public class AppModule {
    private final App application;


    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext(){return application;}

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }

    @Provides
    @Singleton
    RealmHelper provideRealmHelper() {
        return new RealmHelper(application);
    }




}
