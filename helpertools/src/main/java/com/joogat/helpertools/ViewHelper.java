package com.joogat.helpertools;

import android.view.View;
import android.view.ViewGroup;

public class ViewHelper {

    public static void setClickable(View view, boolean clickable) {
        if (view != null) {
            view.setClickable(clickable);
            if (view instanceof ViewGroup) {
                ViewGroup vg = ((ViewGroup) view);
                for (int i = 0; i < vg.getChildCount(); i++) {
                    setClickable(vg.getChildAt(i), clickable);
                }
            }
        }
    }
}
