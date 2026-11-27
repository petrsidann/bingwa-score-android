package v4;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import c4.f;
import c4.g;
import c4.h;
import c4.j;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.common.zzi;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f17185a = f.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f17186b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f17187c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f17188d = false;

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Code duplicated, block: B:18:0x004f A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0014, B:7:0x0019, B:12:0x003d, B:13:0x0042, B:15:0x0044, B:26:0x008f, B:27:0x0094, B:29:0x0096, B:30:0x00a4, B:18:0x004f, B:20:0x0053, B:23:0x007d, B:10:0x0027), top: B:36:0x0014, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x008f A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:4:0x0014, B:7:0x0019, B:12:0x003d, B:13:0x0042, B:15:0x0044, B:26:0x008f, B:27:0x0094, B:29:0x0096, B:30:0x00a4, B:18:0x004f, B:20:0x0053, B:23:0x007d, B:10:0x0027), top: B:36:0x0014, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0096 A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:4:0x0014, B:7:0x0019, B:12:0x003d, B:13:0x0042, B:15:0x0044, B:26:0x008f, B:27:0x0094, B:29:0x0096, B:30:0x00a4, B:18:0x004f, B:20:0x0053, B:23:0x007d, B:10:0x0027), top: B:36:0x0014, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void a(Context context) throws h, g {
        Context contextB;
        boolean z10;
        Context contextD;
        r.m(context, "Context must not be null");
        f17185a.k(context, 11925000);
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (f17186b) {
            Context context2 = null;
            if (f17188d) {
                z10 = !f17188d;
                contextD = j.d(context);
                if (contextD == null) {
                    f17188d = true;
                    if (z10) {
                        zzl.zzb("com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats2", contextD.getClassLoader(), zzj.zzb(Context.class, context), zzi.zza(jUptimeMillis), zzi.zza(SystemClock.uptimeMillis()));
                    }
                    context2 = contextD;
                }
                if (context2 != null) {
                    b(context2, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                    return;
                } else {
                    Log.e("ProviderInstaller", "Failed to get remote context");
                    throw new g(8);
                }
            }
            try {
                contextB = DynamiteModule.e(context, DynamiteModule.f4006f, "com.google.android.gms.providerinstaller.dynamite").b();
            } catch (DynamiteModule.a e10) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e10.getMessage())));
                contextB = null;
            }
            if (contextB != null) {
                b(contextB, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            z10 = !f17188d;
            contextD = j.d(context);
            if (contextD == null) {
                f17188d = true;
                if (z10) {
                    try {
                        zzl.zzb("com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats2", contextD.getClassLoader(), zzj.zzb(Context.class, context), zzi.zza(jUptimeMillis), zzi.zza(SystemClock.uptimeMillis()));
                    } catch (Exception e11) {
                        Log.w("ProviderInstaller", "Failed to report request stats: ".concat(e11.toString()));
                    }
                }
                context2 = contextD;
            }
            if (context2 != null) {
                b(context2, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                return;
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new g(8);
            }
            throw th;
        }
    }

    public static void b(Context context, Context context2, String str) throws g {
        try {
            if (f17187c == null) {
                f17187c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f17187c.invoke(null, context);
        } catch (Exception e10) {
            Throwable cause = e10.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e10.toString() : cause.toString())));
            }
            throw new g(8);
        }
    }
}
