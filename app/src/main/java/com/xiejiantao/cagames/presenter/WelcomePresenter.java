package com.xiejiantao.cagames.presenter;

import com.google.common.eventbus.Subscribe;
import com.xiejiantao.cagames.base.RxPresenter;
import com.xiejiantao.cagames.model.bean.WelcomeBean;
import com.xiejiantao.cagames.model.http.RetrofitHelper;
import com.xiejiantao.cagames.presenter.contract.WelcomeContract;
import com.xiejiantao.cagames.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by xiejiantao on 2016/12/21.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {
    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public WelcomePresenter(RetrofitHelper mRetrofitHelper){
        this.mRetrofitHelper=mRetrofitHelper;
    }

    @Override
    public void getWelcomeData() {
        Subscription subscription= mRetrofitHelper.fetchWelcomeInfo(RES)
                .compose(RxUtil.< WelcomeBean>rxSchedulerHelper())
                .subscribe(new Action1<WelcomeBean>() {
                    @Override
                    public void call(WelcomeBean welcomeBean) {
                        mView.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("");
                        mView.jumpToMain();
                    }
                });
        addSubscribe(subscription);

    }

    private void startCountDown(){
        Subscription subscription= Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
        addSubscribe(subscription);
    }
}
