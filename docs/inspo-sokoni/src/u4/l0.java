package u4;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Iterator<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator<String> f16474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f16475b;

    public l0(i0 i0Var) {
        this.f16475b = i0Var;
        this.f16474a = i0Var.f16326a.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f16474a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f16474a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
