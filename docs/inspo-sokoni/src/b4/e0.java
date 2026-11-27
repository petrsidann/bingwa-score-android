package b4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2809c = 0;

    public e0(Context context) {
        this.f2807a = context;
    }

    public final synchronized int a() {
        PackageInfo packageInfoE;
        if (this.f2808b == 0) {
            try {
                packageInfoE = l4.d.a(this.f2807a).e("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.w("Metadata", "Failed to find package ".concat(e10.toString()));
                packageInfoE = null;
            }
            if (packageInfoE != null) {
                this.f2808b = packageInfoE.versionCode;
            }
        }
        return this.f2808b;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0046 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x001d, B:12:0x0026, B:14:0x002d, B:16:0x003f, B:24:0x0060, B:19:0x0046, B:21:0x0059, B:27:0x0064, B:31:0x0073), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    public final synchronized int b() {
        List<ResolveInfo> listQueryBroadcastReceivers;
        int i10 = this.f2809c;
        if (i10 != 0) {
            return i10;
        }
        Context context = this.f2807a;
        PackageManager packageManager = context.getPackageManager();
        if (l4.d.a(context).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i11 = 1;
        if (j4.m.e()) {
            Intent intent = new Intent("com.google.iid.TOKEN_REQUEST");
            intent.setPackage("com.google.android.gms");
            listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers != null) {
            }
            Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
            if (true != j4.m.e()) {
                i11 = 2;
            }
            this.f2809c = i11;
            return i11;
        }
        Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent2, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            Intent intent3 = new Intent("com.google.iid.TOKEN_REQUEST");
            intent3.setPackage("com.google.android.gms");
            listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent3, 0);
            if (listQueryBroadcastReceivers != null || listQueryBroadcastReceivers.isEmpty()) {
                Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
                if (true != j4.m.e()) {
                    i11 = 2;
                }
                this.f2809c = i11;
                return i11;
            }
            i11 = 2;
        }
        this.f2809c = i11;
        return i11;
    }
}
