package com.joogat.helpers;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public class LayoutHelper {

    public static void setHeight(View v, int height){
        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.height = height;
        v.setLayoutParams(params);
    }

    public static void setWidth(View v, int width){
        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.width = width;
        v.setLayoutParams(params);
    }

    public static ValueAnimator animateHeight(final View view, int heightTo, int duration){

        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        ValueAnimator anim = ValueAnimator.ofInt(view.getMeasuredHeight(), heightTo);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = (Integer) valueAnimator.getAnimatedValue();
                view.setLayoutParams(layoutParams);
            }
        });

        anim.setDuration(duration);
        anim.start();
        return anim;
    }
}
