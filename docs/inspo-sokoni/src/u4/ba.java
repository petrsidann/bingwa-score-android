package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f16035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f16036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f16037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f16038f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f16039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f16040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e9 f16041n;

    public ba(e9 e9Var, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f16033a = str;
        this.f16034b = str2;
        this.f16035c = j10;
        this.f16036d = bundle;
        this.f16037e = z10;
        this.f16038f = z11;
        this.f16039l = z12;
        this.f16040m = str3;
        this.f16041n = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16041n.Q(this.f16033a, this.f16034b, this.f16035c, this.f16036d, this.f16037e, this.f16038f, this.f16039l, this.f16040m);
    }
}
