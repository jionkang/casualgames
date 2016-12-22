package com.xiejiantao.cagames.util;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiejiantao on 2016/12/22.
 */

public class RxUtil {

    public static <T>Observable.Transformer<T,T> rxSchedulerHelper(){
        return new Observable.Transformer<T,T>(){
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
