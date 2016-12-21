package com.xiejiantao.cagames.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xiejiantao.cagames.app.App;
import com.xiejiantao.cagames.di.component.ActivityComponent;
import com.xiejiantao.cagames.di.component.DaggerActivityComponent;
import com.xiejiantao.cagames.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by xiejiantao on 2016/12/21.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView  {

    @Inject
    protected  T mPresenter;
    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder= ButterKnife.bind(this);
        mContext=this;
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        mUnBinder.unbind();
        App.getInstance().removeActivity(this);
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    protected abstract int getLayout();
    protected abstract void initInject();
    protected abstract void initEventAndData();
}
