package d9;

import vb.b1;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b1<d, e> f6584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b1<h, i> f6585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b1<w, x> f6586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b1<f0, g0> f6587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b1<s, t> f6588e;

    public class a implements dc.b.a<b> {
        @Override // dc.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(vb.d dVar, vb.c cVar) {
            return new b(dVar, cVar, null);
        }
    }

    public static final class b extends dc.a<b> {
        public b(vb.d dVar, vb.c cVar) {
            super(dVar, cVar);
        }

        public /* synthetic */ b(vb.d dVar, vb.c cVar, a aVar) {
            this(dVar, cVar);
        }

        @Override // dc.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b a(vb.d dVar, vb.c cVar) {
            return new b(dVar, cVar);
        }
    }

    public static b1<d, e> a() {
        b1<d, e> b1VarA = f6584a;
        if (b1VarA == null) {
            synchronized (r.class) {
                b1VarA = f6584a;
                if (b1VarA == null) {
                    b1VarA = b1.g().f(b1.d.SERVER_STREAMING).b(b1.b("google.firestore.v1.Firestore", "BatchGetDocuments")).e(true).c(cc.b.b(d.i0())).d(cc.b.b(e.e0())).a();
                    f6584a = b1VarA;
                }
            }
        }
        return b1VarA;
    }

    public static b1<h, i> b() {
        b1<h, i> b1VarA = f6585b;
        if (b1VarA == null) {
            synchronized (r.class) {
                b1VarA = f6585b;
                if (b1VarA == null) {
                    b1VarA = b1.g().f(b1.d.UNARY).b(b1.b("google.firestore.v1.Firestore", "Commit")).e(true).c(cc.b.b(h.i0())).d(cc.b.b(i.f0())).a();
                    f6585b = b1VarA;
                }
            }
        }
        return b1VarA;
    }

    public static b1<s, t> c() {
        b1<s, t> b1VarA = f6588e;
        if (b1VarA == null) {
            synchronized (r.class) {
                b1VarA = f6588e;
                if (b1VarA == null) {
                    b1VarA = b1.g().f(b1.d.BIDI_STREAMING).b(b1.b("google.firestore.v1.Firestore", "Listen")).e(true).c(cc.b.b(s.i0())).d(cc.b.b(t.e0())).a();
                    f6588e = b1VarA;
                }
            }
        }
        return b1VarA;
    }

    public static b1<w, x> d() {
        b1<w, x> b1VarA = f6586c;
        if (b1VarA == null) {
            synchronized (r.class) {
                b1VarA = f6586c;
                if (b1VarA == null) {
                    b1VarA = b1.g().f(b1.d.SERVER_STREAMING).b(b1.b("google.firestore.v1.Firestore", "RunAggregationQuery")).e(true).c(cc.b.b(w.g0())).d(cc.b.b(x.e0())).a();
                    f6586c = b1VarA;
                }
            }
        }
        return b1VarA;
    }

    public static b1<f0, g0> e() {
        b1<f0, g0> b1VarA = f6587d;
        if (b1VarA == null) {
            synchronized (r.class) {
                b1VarA = f6587d;
                if (b1VarA == null) {
                    b1VarA = b1.g().f(b1.d.BIDI_STREAMING).b(b1.b("google.firestore.v1.Firestore", "Write")).e(true).c(cc.b.b(f0.j0())).d(cc.b.b(g0.f0())).a();
                    f6587d = b1VarA;
                }
            }
        }
        return b1VarA;
    }

    public static b f(vb.d dVar) {
        return (b) dc.a.e(new a(), dVar);
    }
}
