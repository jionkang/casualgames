package com.xiejiantao.cagames.model.http;

import com.xiejiantao.cagames.model.bean.WelcomeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xiejiantao on 2016/12/22.
 */

public interface ZhihuApis {
    String HOST = "http://news-at.zhihu.com/api/4/";


    @GET("start-image/{res}")
    Observable<WelcomeBean> getWelcomeInfo(@Path("res")String res);

}
