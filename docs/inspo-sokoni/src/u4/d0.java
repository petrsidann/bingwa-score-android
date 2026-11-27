package u4;

import android.os.Handler;
import com.google.android.gms.internal.measurement.zzdj;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Handler f16081d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q8 f16082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f16083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f16084c;

    public d0(q8 q8Var) {
        com.google.android.gms.common.internal.r.l(q8Var);
        this.f16082a = q8Var;
        this.f16083b = new c0(this, q8Var);
    }

    public final void a() {
        this.f16084c = 0L;
        f().removeCallbacks(this.f16083b);
    }

    public final void b(long j10) {
        a();
        if (j10 >= 0) {
            this.f16084c = this.f16082a.zzb().a();
            if (f().postDelayed(this.f16083b, j10)) {
                return;
            }
            this.f16082a.zzj().C().b("Failed to schedule delayed post. time", Long.valueOf(j10));
        }
    }

    public abstract void d();

    public final boolean e() {
        return this.f16084c != 0;
    }

    public final Handler f() {
        Handler handler;
        if (f16081d != null) {
            return f16081d;
        }
        synchronized (d0.class) {
            if (f16081d == null) {
                f16081d = new zzdj(this.f16082a.zza().getMainLooper());
            }
            handler = f16081d;
        }
        return handler;
    }
}
