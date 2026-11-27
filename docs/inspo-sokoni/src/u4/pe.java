package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class pe implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f16720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qe f16721d;

    public pe(qe qeVar, String str, String str2, Bundle bundle) {
        this.f16718a = str;
        this.f16719b = str2;
        this.f16720c = bundle;
        this.f16721d = qeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16721d.f16752a.F((n0) com.google.android.gms.common.internal.r.l(this.f16721d.f16752a.G0().G(this.f16718a, this.f16719b, this.f16720c, "auto", this.f16721d.f16752a.zzb().a(), false, true)), this.f16718a);
    }
}
