package oc;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends i.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f13810k = b.f13811a;

    public static final class a {
        public static <E extends i.b> E a(f fVar, i.c<E> key) {
            k.e(key, "key");
            if (!(key instanceof oc.b)) {
                if (f.f13810k != key) {
                    return null;
                }
                k.c(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
            oc.b bVar = (oc.b) key;
            if (!bVar.a(fVar.getKey())) {
                return null;
            }
            E e10 = (E) bVar.b(fVar);
            if (e10 instanceof i.b) {
                return e10;
            }
            return null;
        }

        public static i b(f fVar, i.c<?> key) {
            k.e(key, "key");
            if (!(key instanceof oc.b)) {
                return f.f13810k == key ? j.f13812a : fVar;
            }
            oc.b bVar = (oc.b) key;
            return (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) ? fVar : j.f13812a;
        }
    }

    public static final class b implements i.c<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f13811a = new b();
    }

    void I(e<?> eVar);

    <T> e<T> t(e<? super T> eVar);
}
