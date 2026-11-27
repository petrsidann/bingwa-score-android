package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ma implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16517b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f16520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e9 f16521f;

    public ma(e9 e9Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f16516a = atomicReference;
        this.f16518c = str2;
        this.f16519d = str3;
        this.f16520e = z10;
        this.f16521f = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16521f.f16624a.I().I(this.f16516a, null, this.f16518c, this.f16519d, this.f16520e);
    }
}
