package c4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k f3381c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f3383b;

    public k(Context context) {
        this.f3382a = context.getApplicationContext();
    }

    public static k a(Context context) {
        com.google.android.gms.common.internal.r.l(context);
        synchronized (k.class) {
            if (f3381c == null) {
                b0.d(context);
                f3381c = new k(context);
            }
        }
        return f3381c;
    }

    public static final x d(PackageInfo packageInfo, x... xVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            y yVar = new y(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < xVarArr.length; i10++) {
                if (xVarArr[i10].equals(yVar)) {
                    return xVarArr[i10];
                }
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z10) {
        PackageInfo packageInfo2;
        if (!z10) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z10 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z10 ? d(packageInfo2, a0.f3333a) : d(packageInfo2, a0.f3333a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (j.f(this.f3382a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i10) {
        k0 k0VarC;
        String[] packagesForUid = this.f3382a.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            k0VarC = k0.c("no pkgs");
        } else {
            k0VarC = null;
            for (String str : packagesForUid) {
                k0VarC = f(str, false, false);
                if (!k0VarC.f3385a) {
                }
            }
            com.google.android.gms.common.internal.r.l(k0VarC);
        }
        k0VarC.e();
        return k0VarC.f3385a;
    }

    public final k0 f(String str, boolean z10, boolean z11) {
        k0 k0VarC;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return k0.c("null pkg");
        }
        if (str.equals(this.f3383b)) {
            return k0.b();
        }
        if (b0.e()) {
            k0VarC = b0.b(str, j.f(this.f3382a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f3382a.getPackageManager().getPackageInfo(str, 64);
                boolean zF = j.f(this.f3382a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        y yVar = new y(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        k0 k0VarA = b0.a(str3, yVar, zF, false);
                        if (!k0VarA.f3385a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !b0.a(str3, yVar, false, true).f3385a) {
                            k0VarC = k0VarA;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                    k0VarC = k0.c(str2);
                } else {
                    k0VarC = k0.c(str2);
                }
            } catch (PackageManager.NameNotFoundException e10) {
                return k0.d("no pkg ".concat(str), e10);
            }
        }
        if (k0VarC.f3385a) {
            this.f3383b = str;
        }
        return k0VarC;
    }
}
