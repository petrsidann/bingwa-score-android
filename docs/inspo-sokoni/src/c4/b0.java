package c4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.y0;
import com.google.android.gms.common.internal.z0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile z0 f3343e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f3345g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f3339a = new t(x.f("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f3340b = new u(x.f("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f3341c = new v(x.f("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z f3342d = new w(x.f("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3344f = new Object();

    public static k0 a(String str, x xVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, xVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static k0 b(String str, boolean z10, boolean z11, boolean z12) {
        return g(str, z10, false, false, true);
    }

    public static /* synthetic */ String c(boolean z10, String str, x xVar) {
        String str2 = true != (!z10 && f(str, xVar, true, false).f3385a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = j4.a.b("SHA-256");
        com.google.android.gms.common.internal.r.l(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, j4.i.a(messageDigestB.digest(xVar.i())), Boolean.valueOf(z10), "12451000.false");
    }

    public static synchronized void d(Context context) {
        if (f3345g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f3345g = context.getApplicationContext();
        }
    }

    public static boolean e() {
        boolean zZzi;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                zZzi = f3343e.zzi();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            zZzi = false;
        }
        return zZzi;
    }

    public static k0 f(final String str, final x xVar, final boolean z10, boolean z11) {
        try {
            h();
            com.google.android.gms.common.internal.r.l(f3345g);
            try {
                return f3343e.u(new g0(str, xVar, z10, z11), m4.b.i(f3345g.getPackageManager())) ? k0.b() : new i0(new Callable() { // from class: c4.s
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return b0.c(z10, str, xVar);
                    }
                }, null);
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return k0.d("module call", e10);
            }
        } catch (DynamiteModule.a e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return k0.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, m4.a] */
    public static k0 g(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        String strConcat;
        k0 k0VarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            com.google.android.gms.common.internal.r.l(f3345g);
            try {
                h();
                c0 c0Var = new c0(str, z10, false, m4.b.i(f3345g), false, true);
                try {
                    e0 e0VarC1 = z13 ? f3343e.c1(c0Var) : f3343e.s(c0Var);
                    if (e0VarC1.S()) {
                        k0VarD = k0.f(e0VarC1.T());
                    } else {
                        String strZza = e0VarC1.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = e0VarC1.U() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZza == null) {
                            strZza = "error checking package certificate";
                        }
                        k0VarD = k0.g(e0VarC1.T(), e0VarC1.U(), strZza, nameNotFoundException);
                    }
                } catch (RemoteException e10) {
                    e = e10;
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    strConcat = "module call";
                    k0VarD = k0.d(strConcat, e);
                }
            } catch (DynamiteModule.a e11) {
                e = e11;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                strConcat = "module init: ".concat(String.valueOf(e.getMessage()));
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return k0VarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static void h() {
        if (f3343e != null) {
            return;
        }
        com.google.android.gms.common.internal.r.l(f3345g);
        synchronized (f3344f) {
            if (f3343e == null) {
                f3343e = y0.b(DynamiteModule.e(f3345g, DynamiteModule.f4006f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
