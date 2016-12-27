package com.xiejiantao.cagames.ui.main.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatDialog;

import com.xiejiantao.cagames.R;
import com.xiejiantao.cagames.app.App;
import com.xiejiantao.cagames.app.Constants;
import com.xiejiantao.cagames.base.SimpleFragment;
import com.xiejiantao.cagames.util.AlipayUtil;
import com.xiejiantao.cagames.util.LogUtil;
import com.xiejiantao.cagames.util.SharedPreferenceUtil;
import com.xiejiantao.cagames.util.SnackbarUtil;

import butterknife.OnClick;
import retrofit2.http.GET;

/**
 * Created by codeest on 16/8/23.
 */

public class AboutFragment extends SimpleFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initEventAndData() {
    }

    @OnClick(R.id.cv_about_award)
    void awardAuthor() {
        if (AlipayUtil.hasInstalledAlipayClient(mContext)) {
            AlipayUtil.startAlipayClient(getActivity(), Constants.KEY_ALIPAY);

            showPaidDialog();
        } else {
            SnackbarUtil.showShort(getActivity().getWindow().getDecorView(), "木有检测到支付宝客户端 T T");
        }
    }

    private void showPaidDialog() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setTitle("提示");
        builder.setMessage("不管你请我喝饮料没，确定解锁游戏撤销等功能吗？降低游戏难度会失去很多游戏乐趣");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferenceUtil.setPay(true);
            }
        });
        builder.show();
    }

}
