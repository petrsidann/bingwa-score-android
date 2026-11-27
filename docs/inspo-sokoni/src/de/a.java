package de;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DateFormat f6716a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss (z)", Locale.US);

    public static void a(String str, String str2) {
        Log.d("Android: \u001b[32m[Awesome Notifications]\u001b[0m", str2 + " (" + str + ":" + c() + ")");
    }

    public static void b(String str, String str2) {
        Log.e("Android: \u001b[31m[Awesome Notifications]", str2 + " (" + str + ":" + c() + ")\u001b[0m");
    }

    public static String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace.length < 5 ? "?" : String.valueOf(stackTrace[4].getLineNumber());
    }

    public static void d(String str, String str2) {
        Log.i("Android: \u001b[94m[Awesome Notifications]", str2 + " (" + str + ":" + c() + ")\u001b[0m");
    }

    public static void e(String str, String str2) {
        Log.w("Android: \u001b[33m[Awesome Notifications]", str2 + " (" + str + ":" + c() + ")\u001b[0m");
    }
}
