package dc;

import dc.a;
import vb.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<S extends a<S>> extends b<S> {
    public a(d dVar, vb.c cVar) {
        super(dVar, cVar);
    }

    public static <T extends b<T>> T e(b.a<T> aVar, d dVar) {
        return (T) f(aVar, dVar, vb.c.f17279k);
    }

    public static <T extends b<T>> T f(b.a<T> aVar, d dVar, vb.c cVar) {
        return (T) aVar.a(dVar, cVar.q(c.f6703c, c.a.ASYNC));
    }
}
