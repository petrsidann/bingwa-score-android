package g8;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s7.c<h8.k, h8.h> f8876b;

    public n(int i10, s7.c<h8.k, h8.h> cVar) {
        this.f8875a = i10;
        this.f8876b = cVar;
    }

    public static n a(int i10, Map<h8.k, g1> map) {
        s7.c<h8.k, h8.h> cVarA = h8.i.a();
        for (Map.Entry<h8.k, g1> entry : map.entrySet()) {
            cVarA = cVarA.l(entry.getKey(), entry.getValue().a());
        }
        return new n(i10, cVarA);
    }

    public int b() {
        return this.f8875a;
    }

    public s7.c<h8.k, h8.h> c() {
        return this.f8876b;
    }
}
