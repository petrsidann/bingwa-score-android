package u8;

import a8.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f17034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f17035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17036d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f17033a = contextA;
        this.f17034b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f17035c = cVar;
        this.f17036d = c();
    }

    public static Context a(Context context) {
        return f0.a.createDeviceProtectedStorageContext(context);
    }

    public synchronized boolean b() {
        return this.f17036d;
    }

    public final boolean c() {
        return this.f17034b.contains("firebase_data_collection_default_enabled") ? this.f17034b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f17033a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f17033a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized void e(Boolean bool) {
        boolean zEquals;
        try {
            if (bool == null) {
                this.f17034b.edit().remove("firebase_data_collection_default_enabled").apply();
                zEquals = d();
            } else {
                zEquals = Boolean.TRUE.equals(bool);
                this.f17034b.edit().putBoolean("firebase_data_collection_default_enabled", zEquals).apply();
            }
            f(zEquals);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(boolean z10) {
        if (this.f17036d != z10) {
            this.f17036d = z10;
            this.f17035c.b(new a8.a<>(h7.b.class, new h7.b(z10)));
        }
    }
}
