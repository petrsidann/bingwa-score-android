package u4;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class rd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ id f16769a;

    public rd(id idVar) {
        this.f16769a = idVar;
    }

    public final void a() {
        this.f16769a.j();
        if (this.f16769a.e().u(this.f16769a.zzb().a())) {
            this.f16769a.e().f16338n.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f16769a.zzj().G().a("Detected application was in foreground");
                c(this.f16769a.zzb().a(), false);
            }
        }
    }

    public final void b(long j10, boolean z10) {
        this.f16769a.j();
        this.f16769a.D();
        if (this.f16769a.e().u(j10)) {
            this.f16769a.e().f16338n.a(true);
            this.f16769a.l().G();
        }
        this.f16769a.e().f16342r.b(j10);
        if (this.f16769a.e().f16338n.b()) {
            c(j10, z10);
        }
    }

    public final void c(long j10, boolean z10) {
        this.f16769a.j();
        if (this.f16769a.f16624a.n()) {
            this.f16769a.e().f16342r.b(j10);
            this.f16769a.zzj().G().b("Session started, time", Long.valueOf(this.f16769a.zzb().b()));
            Long lValueOf = Long.valueOf(j10 / 1000);
            this.f16769a.n().V("auto", "_sid", lValueOf, j10);
            this.f16769a.e().f16343s.b(lValueOf.longValue());
            this.f16769a.e().f16338n.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            this.f16769a.n().P("auto", "_s", j10, bundle);
            String strA = this.f16769a.e().f16348x.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strA);
            this.f16769a.n().P("auto", "_ssr", j10, bundle2);
        }
    }
}
