package com.xiejiantao.cagames.presenter;

import com.xiejiantao.cagames.base.RxPresenter;
import com.xiejiantao.cagames.model.bean.CasualListBean;
import com.xiejiantao.cagames.model.bean.CasualListBean.DataBean;
import com.xiejiantao.cagames.model.http.RetrofitHelper;
import com.xiejiantao.cagames.presenter.contract.CasualGamesContract;
import com.xiejiantao.cagames.util.RxUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by xiejiantao on 2016/12/23.
 */

public class CasualGamesPresenter extends RxPresenter<CasualGamesContract.View> implements CasualGamesContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public CasualGamesPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getSectionData() {
        Subscription rxSubscription = Observable.create(
                new Observable.OnSubscribe<CasualListBean>() {

                    @Override
                    public void call(Subscriber<? super CasualListBean> subscriber) {
                        CasualListBean bean = new CasualListBean();
                        ArrayList<DataBean> list = new ArrayList<DataBean>();
                        DataBean bean1 = new DataBean();
                        bean1.setName("2048");
                        bean1.setThumbnail("http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg");
                        list.add(bean1);
                        DataBean bean2 = new DataBean();

                        bean2.setName("heibai");
                        bean2.setThumbnail("http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg");
                        list.add(bean2);

                        DataBean bean3 = new DataBean();
                        bean3.setName("heibai");
                        bean3.setThumbnail("http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg");
                        list.add(bean3);
                        bean.setData(list);
                        subscriber.onNext(bean);
                    }
                }
        )
                .compose(RxUtil.<CasualListBean>rxSchedulerHelper())
                .subscribe(new Action1<CasualListBean>() {
                    @Override
                    public void call(CasualListBean sectionListBean) {
                        mView.showContent(sectionListBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("数据加载失败ヽ(≧Д≦)ノ");
                    }
                });
        addSubscribe(rxSubscription);
    }
}
