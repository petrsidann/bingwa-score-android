package dd;

import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public class g extends f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f6714a;

        public a(Iterator it) {
            this.f6714a = it;
        }

        @Override // dd.b
        public Iterator<T> iterator() {
            return this.f6714a;
        }
    }

    public static final <T> b<T> c(Iterator<? extends T> it) {
        k.e(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> d(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return bVar instanceof dd.a ? bVar : new dd.a(bVar);
    }
}
