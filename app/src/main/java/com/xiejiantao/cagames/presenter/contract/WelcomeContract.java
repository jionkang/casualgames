package com.xiejiantao.cagames.presenter.contract;

import com.xiejiantao.cagames.base.BasePresenter;
import com.xiejiantao.cagames.base.BaseView;
import com.xiejiantao.cagames.model.bean.WelcomeBean;

/**
 * Created by xiejiantao on 2016/12/21.
 */

public interface WelcomeContract {
    interface  View extends BaseView{

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();
    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
