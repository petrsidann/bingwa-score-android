package p7;

/* JADX INFO: loaded from: classes.dex */
public final class f1 implements com.google.android.gms.common.api.internal.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g1 f14224a;

    public f1(g1 g1Var) {
        this.f14224a = g1Var;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z10) {
        if (z10) {
            this.f14224a.f14236c = true;
            this.f14224a.b();
        } else {
            this.f14224a.f14236c = false;
            if (this.f14224a.f()) {
                this.f14224a.f14235b.c();
            }
        }
    }
}
