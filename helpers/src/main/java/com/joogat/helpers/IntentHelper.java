package com.joogat.helpers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

public class IntentHelper {

    public static Intent getGooglePlayStoreIntent(String s){

        Uri uri = Uri.parse(s);

        //        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
//
//        if (Build.VERSION.SDK_INT >= 21) {
//            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
//        } else {
//            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
//        }
//
//        goToMarket.addFlags(flags);

        return new Intent(Intent.ACTION_VIEW, uri);
    }


    public static void openInPlayStore(String packageName, Activity activity){
        try {
            activity.startActivity( getGooglePlayStoreIntent("market://details?id=" + packageName) );
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public static void openInBrowser(String uri, Activity activity){
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
    }

    public static void shareText(String text, Activity activity){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        activity.startActivity(sendIntent);
    }

    public static void view(String url, Activity activity){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        activity.startActivity(intent);
    }

}
