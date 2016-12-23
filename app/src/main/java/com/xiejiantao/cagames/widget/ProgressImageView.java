package com.xiejiantao.cagames.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by codeest on 16/9/27.
 */

public class ProgressImageView extends ImageView{


    public ProgressImageView(Context context) {
        super(context);
    }

    public ProgressImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void start() {
        setVisibility(View.VISIBLE);
//        Animatable animatable = (Animatable) getDrawable();
//        if (!animatable.isRunning()) {
//            animatable.start();
//        }
    }

    public void stop() {
//        Animatable animatable = (Animatable) getDrawable();
//        if (animatable.isRunning()) {
//            animatable.stop();
//        }
        setVisibility(View.GONE);
    }
}
