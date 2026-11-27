package ld;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements gd.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.i f12722a;

    public f(oc.i iVar) {
        this.f12722a = iVar;
    }

    @Override // gd.m0
    public oc.i f() {
        return this.f12722a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + f() + ')';
    }
}
