package z8;

import java.util.Iterator;
import java.util.Set;
import q7.q;

/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f20383b;

    public c(Set<f> set, d dVar) {
        this.f20382a = e(set);
        this.f20383b = dVar;
    }

    public static q7.c<i> c() {
        return q7.c.c(i.class).b(q.n(f.class)).f(new q7.g() { // from class: z8.b
            @Override // q7.g
            public final Object a(q7.d dVar) {
                return c.d(dVar);
            }
        }).d();
    }

    public static /* synthetic */ i d(q7.d dVar) {
        return new c(dVar.e(f.class), d.a());
    }

    public static String e(Set<f> set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb2.append(next.b());
            sb2.append('/');
            sb2.append(next.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // z8.i
    public String a() {
        if (this.f20383b.b().isEmpty()) {
            return this.f20382a;
        }
        return this.f20382a + ' ' + e(this.f20383b.b());
    }
}
