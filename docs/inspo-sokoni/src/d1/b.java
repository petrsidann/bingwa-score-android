package d1;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a1.f<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1.f<d> f6266a;

    public b(a1.f<d> delegate) {
        k.e(delegate, "delegate");
        this.f6266a = delegate;
    }

    @Override // a1.f
    public jd.d<d> a() {
        return this.f6266a.a();
    }
}
