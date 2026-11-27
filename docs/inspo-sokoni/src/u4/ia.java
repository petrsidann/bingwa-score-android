package u4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e9 f16363e;

    public ia(e9 e9Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f16359a = atomicReference;
        this.f16361c = str2;
        this.f16362d = str3;
        this.f16363e = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16363e.f16624a.I().H(this.f16359a, null, this.f16361c, this.f16362d);
    }
}
