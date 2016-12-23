package com.xiejiantao.cagames.presenter.contract;


import com.xiejiantao.cagames.base.BasePresenter;
import com.xiejiantao.cagames.base.BaseView;
import com.xiejiantao.cagames.model.bean.VersionBean;

/**
 * Created by codeest on 16/10/17.
 */

public interface SettingContract {

    interface View extends BaseView {

        void showUpdateDialog(VersionBean bean);

    }

    interface  Presenter extends BasePresenter<View> {

        void checkVersion(String currentVersion);

    }
}
