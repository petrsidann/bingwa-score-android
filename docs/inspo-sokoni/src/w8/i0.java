package w8;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17750e = 0;

    public i0(Context context) {
        this.f17746a = context;
    }

    public static String c(h7.f fVar) {
        String strF = fVar.r().f();
        if (strF != null) {
            return strF;
        }
        String strC = fVar.r().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public synchronized String a() {
        if (this.f17747b == null) {
            h();
        }
        return this.f17747b;
    }

    public synchronized String b() {
        if (this.f17748c == null) {
            h();
        }
        return this.f17748c;
    }

    public synchronized int d() {
        PackageInfo packageInfoF;
        if (this.f17749d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
            this.f17749d = packageInfoF.versionCode;
        }
        return this.f17749d;
    }

    public synchronized int e() {
        int i10 = this.f17750e;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f17746a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!j4.m.e()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f17750e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f17750e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (j4.m.e()) {
            this.f17750e = 2;
        } else {
            this.f17750e = 1;
        }
        return this.f17750e;
    }

    public final PackageInfo f(String str) {
        try {
            return this.f17746a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("FirebaseMessaging", "Failed to find package " + e10);
            return null;
        }
    }

    public boolean g() {
        return e() != 0;
    }

    public final synchronized void h() {
        PackageInfo packageInfoF = f(this.f17746a.getPackageName());
        if (packageInfoF != null) {
            this.f17747b = Integer.toString(packageInfoF.versionCode);
            this.f17748c = packageInfoF.versionName;
        }
    }
}
