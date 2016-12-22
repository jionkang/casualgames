package com.xiejiantao.cagames.util;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by xiejiantao on 2016/12/22.
 */

public class StartActivityUtil {

    public  static void  startActivity(Intent intent, Activity activity){
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
