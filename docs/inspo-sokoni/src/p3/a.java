package p3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c4.f;
import c4.g;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c4.a f14121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzf f14122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f14124d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f14125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f14126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f14127g;

    /* JADX INFO: renamed from: p3.a$a, reason: collision with other inner class name */
    public static final class C0248a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14129b;

        @Deprecated
        public C0248a(String str, boolean z10) {
            this.f14128a = str;
            this.f14129b = z10;
        }

        public String a() {
            return this.f14128a;
        }

        public boolean b() {
            return this.f14129b;
        }

        public String toString() {
            String str = this.f14128a;
            boolean z10 = this.f14129b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }
    }

    @VisibleForTesting
    public a(Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        r.l(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f14126f = context;
        this.f14123c = false;
        this.f14127g = j10;
    }

    public static C0248a a(Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0248a c0248aF = aVar.f(-1);
            aVar.e(c0248aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            aVar.c();
            return c0248aF;
        } catch (Throwable th) {
            try {
                aVar.e(null, true, 0.0f, -1L, "", th);
                throw th;
            } catch (Throwable th2) {
                aVar.c();
                throw th2;
            }
        }
    }

    public static void b(boolean z10) {
    }

    public final void c() {
        r.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f14126f == null || this.f14121a == null) {
                return;
            }
            try {
                if (this.f14123c) {
                    i4.b.b().c(this.f14126f, this.f14121a);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.f14123c = false;
            this.f14122b = null;
            this.f14121a = null;
        }
    }

    @VisibleForTesting
    public final void d(boolean z10) {
        r.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f14123c) {
                c();
            }
            Context context = this.f14126f;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int iH = f.f().h(context, 12451000);
                if (iH != 0 && iH != 2) {
                    throw new IOException("Google Play services not available");
                }
                c4.a aVar = new c4.a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!i4.b.b().a(context, intent, aVar, 1)) {
                        throw new IOException("Connection failure");
                    }
                    this.f14121a = aVar;
                    try {
                        this.f14122b = zze.zza(aVar.a(10000L, TimeUnit.MILLISECONDS));
                        this.f14123c = true;
                        if (z10) {
                            g();
                        }
                    } catch (InterruptedException unused) {
                        throw new IOException("Interrupted exception");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                } catch (Throwable th2) {
                    throw new IOException(th2);
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new g(9);
            }
        }
    }

    @VisibleForTesting
    public final boolean e(C0248a c0248a, boolean z10, float f10, long j10, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", "1");
        if (c0248a != null) {
            map.put("limit_ad_tracking", true != c0248a.b() ? "0" : "1");
            String strA = c0248a.a();
            if (strA != null) {
                map.put("ad_id_size", Integer.toString(strA.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j10));
        new b(this, map).start();
        return true;
    }

    public final C0248a f(int i10) {
        C0248a c0248a;
        r.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f14123c) {
                r.l(this.f14121a);
                r.l(this.f14122b);
                c0248a = new C0248a(this.f14122b.zzc(), this.f14122b.zze(true));
            } else {
                synchronized (this.f14124d) {
                    c cVar = this.f14125e;
                    if (cVar == null || !cVar.f14134d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    d(false);
                    if (!this.f14123c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    r.l(this.f14121a);
                    r.l(this.f14122b);
                    try {
                        c0248a = new C0248a(this.f14122b.zzc(), this.f14122b.zze(true));
                    } catch (RemoteException e10) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e10);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e11) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e11);
                }
            }
            throw th;
        }
        g();
        return c0248a;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f14124d) {
            c cVar = this.f14125e;
            if (cVar != null) {
                cVar.f14133c.countDown();
                try {
                    this.f14125e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j10 = this.f14127g;
            if (j10 > 0) {
                this.f14125e = new c(this, j10);
            }
        }
    }
}
