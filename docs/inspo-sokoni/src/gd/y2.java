package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class y2<U, T extends U> extends ld.d0<T> implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9275e;

    public y2(long j10, oc.e<? super U> eVar) {
        super(eVar.getContext(), eVar);
        this.f9275e = j10;
    }

    @Override // gd.a, gd.g2
    public String o0() {
        return super.o0() + "(timeMillis=" + this.f9275e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        D(z2.a(this.f9275e, w0.b(getContext()), this));
    }
}
