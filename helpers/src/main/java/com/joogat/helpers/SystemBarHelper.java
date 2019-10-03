package com.joogat.helpers;


import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class SystemBarHelper {

    private Window window;
    private int defaultStatusBarColor = 0x999CA0A5;
    private int defaultNavBarColor = 0xffffffff;
    private int duration = 180;

    private Interpolator interpolator = new DecelerateInterpolator();

    private ValueAnimator statusBarToColor, navBarToColor, statusBarFromColor, navBarFromColor;


    public SystemBarHelper(Activity activity) {
        window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            defaultStatusBarColor = window.getStatusBarColor();
            defaultNavBarColor = window.getNavigationBarColor();
        }
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }


    @TargetApi(21)
    public void animateColorTo(int colorTo) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;

        if ( defaultStatusBarColor != colorTo && statusBarToColor == null ) {
            statusBarToColor = ValueAnimator.ofArgb(defaultStatusBarColor, colorTo);
            statusBarToColor.setInterpolator(interpolator);
            statusBarToColor.setDuration(duration);
            statusBarToColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    window.setStatusBarColor((Integer) animator.getAnimatedValue());
                }
            });
        }

        if ( defaultNavBarColor != colorTo && navBarToColor == null ) {
            navBarToColor = ValueAnimator.ofArgb(defaultNavBarColor, colorTo);
            navBarToColor.setInterpolator(interpolator);
            navBarToColor.setDuration(duration);
            navBarToColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    window.setNavigationBarColor((Integer) animator.getAnimatedValue());
                }
            });
        }

        if(statusBarToColor != null) statusBarToColor.start();
        if(navBarToColor != null) navBarToColor.start();
    }



    @TargetApi(21)
    public void animateColorFrom(int colorFrom) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;

        if ( colorFrom != defaultStatusBarColor && statusBarFromColor == null ) {
            statusBarFromColor = ValueAnimator.ofArgb(colorFrom, defaultStatusBarColor);
            statusBarFromColor.setInterpolator(interpolator);
            statusBarFromColor.setDuration(duration);
            statusBarFromColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    window.setStatusBarColor((Integer) animator.getAnimatedValue());
                }
            });
        }

        if ( colorFrom != defaultNavBarColor && navBarFromColor == null ) {
            navBarFromColor = ValueAnimator.ofArgb(colorFrom, defaultNavBarColor);
            navBarFromColor.setInterpolator(interpolator);
            navBarFromColor.setDuration(duration);
            navBarFromColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    window.setNavigationBarColor((Integer) animator.getAnimatedValue());
                }
            });
        }

        if(statusBarFromColor != null) statusBarFromColor.start();
        if(navBarFromColor != null) navBarFromColor.start();
    }



    public void setColor(int color){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;
        window.setStatusBarColor(color);
        window.setNavigationBarColor(color);
    }

    public void resetColor(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;
        window.setStatusBarColor(defaultStatusBarColor);
        window.setNavigationBarColor(defaultNavBarColor);
    }


    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

}