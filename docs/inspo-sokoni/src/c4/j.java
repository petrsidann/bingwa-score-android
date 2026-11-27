package c4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.google.android.gms.common.internal.a1;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f3376a = 12451000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3378c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f3379d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final AtomicBoolean f3377b = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f3380e = new AtomicBoolean();

    @Deprecated
    public static void a(Context context, int i10) throws h, g {
        int iH = f.f().h(context, i10);
        if (iH != 0) {
            Intent intentB = f.f().b(context, iH, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + iH);
            if (intentB != null) {
                throw new h(iH, "Google Play Services not available", intentB);
            }
            throw new g(iH);
        }
    }

    @Deprecated
    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static String c(int i10) {
        return b.X(i10);
    }

    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(Context context) {
        try {
            if (!f3379d) {
                try {
                    PackageInfo packageInfoE = l4.d.a(context).e("com.google.android.gms", 64);
                    k.a(context);
                    if (packageInfoE == null || k.e(packageInfoE, false) || !k.e(packageInfoE, true)) {
                        f3378c = false;
                    } else {
                        f3378c = true;
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e10);
                }
                f3379d = true;
            }
            return f3378c || !j4.h.b();
        } catch (Throwable th) {
            f3379d = true;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:61:0x010d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x010f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x00c9, please report this as an issue */
    @Deprecated
    public static int g(Context context, int i10) {
        String strValueOf;
        String str;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        try {
            context.getResources().getString(l.f3389a);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f3380e.get()) {
            int iA = a1.a(context);
            if (iA == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (iA != f3376a) {
                throw new GooglePlayServicesIncorrectManifestValueException(iA);
            }
        }
        boolean z10 = (j4.h.d(context) || j4.h.f(context)) ? false : true;
        com.google.android.gms.common.internal.r.a(i10 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z10) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                strValueOf = String.valueOf(packageName);
                str = " requires the Google Play Store, but it is missing.";
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            k.a(context);
            if (!k.e(packageInfo2, true)) {
                strValueOf = String.valueOf(packageName);
                str = " requires Google Play services, but their signature is invalid.";
            } else {
                if (!z10) {
                    if (z10) {
                    }
                    if (j4.t.a(packageInfo2.versionCode) < j4.t.a(i10)) {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        if (applicationInfo.enabled) {
                            return 0;
                        }
                        return 3;
                    }
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i10 + " but found " + packageInfo2.versionCode);
                    return 2;
                }
                com.google.android.gms.common.internal.r.l(packageInfo);
                if (!k.e(packageInfo, true)) {
                    strValueOf = String.valueOf(packageName);
                    str = " requires Google Play Store, but its signature is invalid.";
                } else {
                    if (z10 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        if (j4.t.a(packageInfo2.versionCode) < j4.t.a(i10)) {
                            applicationInfo = packageInfo2.applicationInfo;
                            if (applicationInfo == null) {
                                try {
                                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                                } catch (PackageManager.NameNotFoundException e10) {
                                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e10);
                                    return 1;
                                }
                            }
                            if (applicationInfo.enabled) {
                                return 3;
                            }
                            return 0;
                        }
                        Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i10 + " but found " + packageInfo2.versionCode);
                        return 2;
                    }
                    strValueOf = String.valueOf(packageName);
                    str = " requires Google Play Store, but its signature doesn't match that of Google Play services.";
                }
            }
            Log.w("GooglePlayServicesUtil", strValueOf.concat(str));
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @Deprecated
    public static boolean h(Context context, int i10) {
        if (i10 == 18) {
            return true;
        }
        if (i10 == 1) {
            return l(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean i(Context context) {
        Object systemService = context.getSystemService("user");
        com.google.android.gms.common.internal.r.l(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    public static boolean j(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 9;
    }

    @Deprecated
    public static boolean k(Context context, int i10, String str) {
        return j4.r.b(context, i10, str);
    }

    public static boolean l(Context context, String str) throws PackageManager.NameNotFoundException {
        boolean zEquals = str.equals("com.google.android.gms");
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (zEquals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !i(context);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
    }
}
