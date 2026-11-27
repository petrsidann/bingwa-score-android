package id.flutter.flutter_background_service;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class Config {
    final SharedPreferences pref;

    public Config(Context context) {
        this.pref = context.getSharedPreferences("id.flutter.background_service", 0);
    }

    public long getBackgroundHandle() {
        return this.pref.getLong("background_handle", 0L);
    }

    public int getForegroundNotificationId() {
        return this.pref.getInt("foreground_notification_id", 112233);
    }

    public String getInitialNotificationContent() {
        return this.pref.getString("initial_notification_content", "Preparing");
    }

    public String getInitialNotificationTitle() {
        return this.pref.getString("initial_notification_title", "Background Service");
    }

    public String getNotificationChannelId() {
        return this.pref.getString("notification_channel_id", null);
    }

    public boolean isAutoStartOnBoot() {
        return this.pref.getBoolean("auto_start_on_boot", false);
    }

    public boolean isForeground() {
        return this.pref.getBoolean("is_foreground", false);
    }

    public boolean isManuallyStopped() {
        return this.pref.getBoolean("is_manually_stopped", false);
    }

    public void setAutoStartOnBoot(boolean z10) {
        this.pref.edit().putBoolean("auto_start_on_boot", z10).apply();
    }

    public void setBackgroundHandle(long j10) {
        this.pref.edit().putLong("background_handle", j10).apply();
    }

    public void setForegroundNotificationId(int i10) {
        this.pref.edit().putInt("foreground_notification_id", i10).apply();
    }

    public void setInitialNotificationContent(String str) {
        this.pref.edit().putString("initial_notification_content", str).apply();
    }

    public void setInitialNotificationTitle(String str) {
        this.pref.edit().putString("initial_notification_title", str).apply();
    }

    public void setIsForeground(boolean z10) {
        this.pref.edit().putBoolean("is_foreground", z10).apply();
    }

    public void setManuallyStopped(boolean z10) {
        this.pref.edit().putBoolean("is_manually_stopped", z10).apply();
    }

    public void setNotificationChannelId(String str) {
        this.pref.edit().putString("notification_channel_id", str).apply();
    }
}
