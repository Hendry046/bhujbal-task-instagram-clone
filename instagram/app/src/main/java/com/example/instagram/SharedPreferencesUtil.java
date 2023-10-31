package com.example.instagram;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    private static final String PREF_NAME = "MyAppPreferences";

    public static void saveFollowingCount(Context context, int count) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("followingCount", count);
        editor.apply();
    }

    public static int getFollowingCount(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt("followingCount", 0); // Default value is 0
    }

    public static void saveFollowStatus(Context context, String userId, boolean followStatus) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("followStatus_" + userId, followStatus);
        editor.apply();
    }

    public static boolean getFollowStatus(Context context, String userId) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean("followStatus_" + userId, false); // Default value is false
    }

}
