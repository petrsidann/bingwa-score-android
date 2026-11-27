package z8;

import android.content.Context;
import q7.q;

/* JADX INFO: loaded from: classes.dex */
public class h {

    public interface a<T> {
        String a(T t10);
    }

    public static q7.c<?> b(String str, String str2) {
        return q7.c.l(f.a(str, str2), f.class);
    }

    public static q7.c<?> c(final String str, final a<Context> aVar) {
        return q7.c.m(f.class).b(q.k(Context.class)).f(new q7.g() { // from class: z8.g
            @Override // q7.g
            public final Object a(q7.d dVar) {
                return h.d(str, aVar, dVar);
            }
        }).d();
    }

    public static /* synthetic */ f d(String str, a aVar, q7.d dVar) {
        return f.a(str, aVar.a((Context) dVar.a(Context.class)));
    }
}
