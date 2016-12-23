package com.xiejiantao.cagames.ui.cagames.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiejiantao.cagames.R;
import com.xiejiantao.cagames.base.BaseFragment;
import com.xiejiantao.cagames.model.bean.CasualListBean;
import com.xiejiantao.cagames.presenter.CasualGamesPresenter;
import com.xiejiantao.cagames.presenter.contract.CasualGamesContract;
import com.xiejiantao.cagames.ui.cagames.adapter.CasualAdapter;
import com.xiejiantao.cagames.util.SnackbarUtil;
import com.xiejiantao.cagames.widget.ProgressImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by xiejiantao on 2016/12/22.
 */

public class CasualGamesFragment extends BaseFragment<CasualGamesPresenter> implements CasualGamesContract.View{

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.rv_section_list)
    RecyclerView recyclerView;
    @BindView(R.id.iv_progress)
    ProgressImageView ivProgress;

    List<CasualListBean.DataBean> mList;
    CasualAdapter mAdapter;



    @Override
    protected int getLayoutId() {
         return R.layout.fragment_casuals;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        mAdapter = new CasualAdapter(mContext,mList);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        recyclerView.setAdapter(mAdapter);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getSectionData();
            }
        });
        mPresenter.getSectionData();
        ivProgress.start();
    }

    @Override
    public void showError(String msg) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        SnackbarUtil.showShort(recyclerView,msg);
    }

    @Override
    public void showContent(CasualListBean sectionListBean) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        mList.clear();
        mList.addAll(sectionListBean.getData());
        mAdapter.notifyDataSetChanged();
    }
}
