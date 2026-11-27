package dd;

import java.util.Iterator;
import kotlin.jvm.internal.k;
import lc.q;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f6713a;

        public a(p pVar) {
            this.f6713a = pVar;
        }

        @Override // dd.b
        public Iterator<T> iterator() {
            return e.a(this.f6713a);
        }
    }

    public static final <T> Iterator<T> a(p<? super d<? super T>, ? super oc.e<? super q>, ? extends Object> block) {
        k.e(block, "block");
        c cVar = new c();
        cVar.f(pc.b.a(block, cVar, cVar));
        return cVar;
    }

    public static final <T> b<T> b(p<? super d<? super T>, ? super oc.e<? super q>, ? extends Object> block) {
        k.e(block, "block");
        return new a(block);
    }
}
