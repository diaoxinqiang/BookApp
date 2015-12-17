package com.diaoxinqiang.bookapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.cengalabs.flatui.TouchEffectAnimator;
import com.diaoxinqiang.bookapp.utils.LogUtil;


public class RippleLinearLayout extends LinearLayout {

    private TouchEffectAnimator touchEffectAnimator;

    public RippleLinearLayout(Context context) {
        super(context);
        LogUtil.i("created");
        init();
    }

    public RippleLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {


        touchEffectAnimator = new TouchEffectAnimator(this);

        touchEffectAnimator.setHasRippleEffect(true);

        touchEffectAnimator.setEffectColor(Color.GRAY);

        touchEffectAnimator.setAnimDuration(2000);

        touchEffectAnimator.setClipRadius(20);

       setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.i("onclick");
            }
        });
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        touchEffectAnimator.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        touchEffectAnimator.onDraw(canvas);
        super.onDraw(canvas);
    }
}
