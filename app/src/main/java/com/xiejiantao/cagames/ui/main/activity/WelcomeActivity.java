package com.xiejiantao.cagames.ui.main.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiejiantao.cagames.R;
import com.xiejiantao.cagames.base.BaseActivity;
import com.xiejiantao.cagames.component.ImageLoader;
import com.xiejiantao.cagames.model.bean.WelcomeBean;
import com.xiejiantao.cagames.presenter.WelcomePresenter;
import com.xiejiantao.cagames.presenter.contract.WelcomeContract;
import com.xiejiantao.cagames.util.StartActivityUtil;

import butterknife.BindView;

/**
 * Created by xiejiantao on 2016/12/21.
 */

public class WelcomeActivity  extends BaseActivity<WelcomePresenter> implements WelcomeContract.View{

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView tvWelcomeAuthor;

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ImageLoader.load(this,welcomeBean.getImg(),ivWelcomeBg);
        ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        tvWelcomeAuthor.setText(welcomeBean.getText());
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        StartActivityUtil.startActivity(intent,this);
        finish();
    }
}
