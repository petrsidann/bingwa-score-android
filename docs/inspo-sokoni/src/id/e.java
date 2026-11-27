package id;

import gd.g2;
import gd.z1;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public class e<E> extends gd.a<lc.q> implements d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<E> f10622d;

    public e(oc.i iVar, d<E> dVar, boolean z10, boolean z11) {
        super(iVar, z10, z11);
        this.f10622d = dVar;
    }

    @Override // gd.g2
    public void H(Throwable th) {
        CancellationException cancellationExceptionF0 = g2.F0(this, th, null, 1, null);
        this.f10622d.cancel(cancellationExceptionF0);
        D(cancellationExceptionF0);
    }

    public final d<E> Q0() {
        return this.f10622d;
    }

    @Override // id.t
    public Object a() {
        return this.f10622d.a();
    }

    @Override // id.t
    public Object b(oc.e<? super E> eVar) {
        return this.f10622d.b(eVar);
    }

    @Override // gd.g2, gd.y1
    public /* synthetic */ void cancel() {
        H(new z1(M(), null, this));
    }

    @Override // gd.g2, gd.y1
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new z1(M(), null, this);
        }
        H(cancellationException);
    }

    @Override // gd.g2, gd.y1
    public final /* synthetic */ boolean cancel(Throwable th) {
        H(new z1(M(), null, this));
        return true;
    }

    @Override // id.u
    public Object d(E e10, oc.e<? super lc.q> eVar) {
        return this.f10622d.d(e10, eVar);
    }

    @Override // id.u
    public boolean e(Throwable th) {
        return this.f10622d.e(th);
    }

    @Override // id.t
    public f<E> iterator() {
        return this.f10622d.iterator();
    }

    @Override // id.u
    public void j(xc.l<? super Throwable, lc.q> lVar) {
        this.f10622d.j(lVar);
    }

    @Override // id.u
    public Object l(E e10) {
        return this.f10622d.l(e10);
    }

    @Override // id.u
    public boolean m() {
        return this.f10622d.m();
    }
}
