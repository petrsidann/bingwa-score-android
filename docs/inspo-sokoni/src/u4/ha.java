package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ha implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16310b;

    public ha(e9 e9Var, long j10) {
        this.f16309a = j10;
        this.f16310b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16310b.N0(this.f16309a);
        this.f16310b.q().F(new AtomicReference<>());
    }
}
