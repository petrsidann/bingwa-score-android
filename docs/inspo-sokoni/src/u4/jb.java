package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class jb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f16397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hb f16398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ hb f16399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f16400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kb f16401e;

    public jb(kb kbVar, Bundle bundle, hb hbVar, hb hbVar2, long j10) {
        this.f16397a = bundle;
        this.f16398b = hbVar;
        this.f16399c = hbVar2;
        this.f16400d = j10;
        this.f16401e = kbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        kb.H(this.f16401e, this.f16397a, this.f16398b, this.f16399c, this.f16400d);
    }
}
