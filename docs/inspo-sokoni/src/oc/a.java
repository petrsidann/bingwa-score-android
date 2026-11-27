package oc;

import kotlin.jvm.internal.k;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.c<?> f13805a;

    public a(i.c<?> key) {
        k.e(key, "key");
        this.f13805a = key;
    }

    @Override // oc.i.b, oc.i
    public <R> R fold(R r10, p<? super R, ? super i.b, ? extends R> pVar) {
        return (R) i.b.a.a(this, r10, pVar);
    }

    @Override // oc.i.b, oc.i
    public <E extends i.b> E get(i.c<E> cVar) {
        return (E) i.b.a.b(this, cVar);
    }

    @Override // oc.i.b
    public i.c<?> getKey() {
        return this.f13805a;
    }

    @Override // oc.i.b, oc.i
    public i minusKey(i.c<?> cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // oc.i
    public i plus(i iVar) {
        return i.b.a.d(this, iVar);
    }
}
