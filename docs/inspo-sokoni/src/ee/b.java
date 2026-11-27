package ee;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f7937a;

    public static b c() {
        if (f7937a == null) {
            f7937a = new b();
        }
        return f7937a;
    }

    public int a(Context context) {
        int iMax = Math.max(b(context) - 1, 0);
        i(context, iMax);
        return iMax;
    }

    public int b(Context context) {
        return Math.max(PreferenceManager.getDefaultSharedPreferences(context).getInt("badgeCount", 0), 0);
    }

    public int d(Context context) {
        int iB = b(context) + 1;
        i(context, iB);
        return iB;
    }

    public boolean e(Context context) {
        return true;
    }

    public boolean f(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "notification_badging") == 1;
        } catch (Settings.SettingNotFoundException unused) {
            return true;
        }
    }

    public boolean g(Context context) {
        return f(context) && e(context);
    }

    public void h(Context context) {
        i(context, 0);
    }

    public void i(Context context, int i10) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt("badgeCount", i10);
        ke.c.a(context, i10);
        editorEdit.apply();
    }
}
