package h9;

import e9.x;
import e9.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g9.c f9803a;

    public static final class a<E> extends x<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x<E> f9804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g9.i<? extends Collection<E>> f9805b;

        public a(e9.e eVar, Type type, x<E> xVar, g9.i<? extends Collection<E>> iVar) {
            this.f9804a = new n(eVar, xVar, type);
            this.f9805b = iVar;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<E> c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            Collection<E> collectionA = this.f9805b.a();
            aVar.d();
            while (aVar.I()) {
                collectionA.add(this.f9804a.c(aVar));
            }
            aVar.z();
            return collectionA;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.L();
                return;
            }
            cVar.k();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f9804a.e(cVar, it.next());
            }
            cVar.z();
        }
    }

    public b(g9.c cVar) {
        this.f9803a = cVar;
    }

    @Override // e9.y
    public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
        Type typeD = aVar.d();
        Class<? super T> clsC = aVar.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = g9.b.h(typeD, clsC);
        return new a(eVar, typeH, eVar.l(l9.a.b(typeH)), this.f9803a.b(aVar));
    }
}
