package com.xiejiantao.cagames.presenter.contract;

import com.xiejiantao.cagames.base.BasePresenter;
import com.xiejiantao.cagames.base.BaseView;
import com.xiejiantao.cagames.model.bean.CasualListBean;

/**
 * Created by xiejiantao on 2016/12/23.
 */

public interface CasualGamesContract {

    interface  View extends BaseView{
        void showContent(CasualListBean bean);
    }

    interface Presenter extends BasePresenter<View>{
       void   getSectionData();
    }
}
