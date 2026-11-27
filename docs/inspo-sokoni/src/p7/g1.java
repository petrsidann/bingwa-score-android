package p7;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;

/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f14234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f14235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f14236c;

    public g1(Context context, t tVar) {
        this.f14236c = false;
        this.f14234a = 0;
        this.f14235b = tVar;
        com.google.android.gms.common.api.internal.c.c((Application) context.getApplicationContext());
        com.google.android.gms.common.api.internal.c.b().a(new f1(this));
    }

    public g1(h7.f fVar) {
        this(fVar.m(), new t(fVar));
    }

    public final void b() {
        this.f14235b.b();
    }

    public final void c(int i10) {
        if (i10 > 0 && this.f14234a == 0) {
            this.f14234a = i10;
            if (f()) {
                this.f14235b.c();
            }
        } else if (i10 == 0 && this.f14234a != 0) {
            this.f14235b.b();
        }
        this.f14234a = i10;
    }

    public final void d(zzagw zzagwVar) {
        if (zzagwVar == null) {
            return;
        }
        long jZza = zzagwVar.zza();
        if (jZza <= 0) {
            jZza = 3600;
        }
        long jZzb = zzagwVar.zzb() + (jZza * 1000);
        t tVar = this.f14235b;
        tVar.f14313b = jZzb;
        tVar.f14314c = -1L;
        if (f()) {
            this.f14235b.c();
        }
    }

    public final boolean f() {
        return this.f14234a > 0 && !this.f14236c;
    }
}
