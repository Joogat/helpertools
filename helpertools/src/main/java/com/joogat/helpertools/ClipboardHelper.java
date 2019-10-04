package com.joogat.helpertools;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

public class ClipboardHelper {

    public static void copyToClipBoard(String label, String text, Activity activity){

        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);

        if(clipboard != null) {
            clipboard.setPrimaryClip(clip);
            Toast.makeText( activity, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText( activity, "Could not copy", Toast.LENGTH_SHORT).show();
        }
    }
}
