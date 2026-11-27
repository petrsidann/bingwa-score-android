package dd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import mc.n;
import mc.o;

/* JADX INFO: loaded from: classes2.dex */
public class i extends h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f6715a;

        public a(b bVar) {
            this.f6715a = bVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f6715a.iterator();
        }
    }

    public static final <T> Iterable<T> e(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return new a(bVar);
    }

    public static final <T> List<T> f(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        Iterator<? extends T> it = bVar.iterator();
        if (!it.hasNext()) {
            return o.g();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return n.b(next);
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(next);
            if (!it.hasNext()) {
                return arrayList;
            }
            next = it.next();
        }
    }
}
