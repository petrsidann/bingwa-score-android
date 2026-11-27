package vb;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<Object, Object> f17389a = new a();

    public class a extends g<Object, Object> {
        @Override // vb.g
        public void a(String str, Throwable th) {
        }

        @Override // vb.g
        public void b() {
        }

        @Override // vb.g
        public void c(int i10) {
        }

        @Override // vb.g
        public void d(Object obj) {
        }

        @Override // vb.g
        public void e(g.a<Object> aVar, a1 a1Var) {
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f17390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h f17391b;

        public b(d dVar, h hVar) {
            this.f17390a = dVar;
            this.f17391b = (h) j6.m.p(hVar, "interceptor");
        }

        public /* synthetic */ b(d dVar, h hVar, i iVar) {
            this(dVar, hVar);
        }

        @Override // vb.d
        public String b() {
            return this.f17390a.b();
        }

        @Override // vb.d
        public <ReqT, RespT> g<ReqT, RespT> f(b1<ReqT, RespT> b1Var, c cVar) {
            return this.f17391b.a(b1Var, cVar, this.f17390a);
        }
    }

    public static d a(d dVar, List<? extends h> list) {
        j6.m.p(dVar, "channel");
        Iterator<? extends h> it = list.iterator();
        while (it.hasNext()) {
            dVar = new b(dVar, it.next(), null);
        }
        return dVar;
    }
}
