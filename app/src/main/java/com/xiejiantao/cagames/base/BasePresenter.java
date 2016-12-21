package com.xiejiantao.cagames.base;

/**
 * Created by xiejiantao on 2016/12/21.
 */

public interface BasePresenter<T extends BaseView> {
    void  attachView(T view);
    void detachView();
}
