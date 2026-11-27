package h9;

import e9.q;
import e9.r;
import e9.x;
import e9.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class m<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r<T> f9865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e9.j<T> f9866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e9.e f9867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l9.a<T> f9868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f9869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m<T>.b f9870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile x<T> f9872h;

    public final class b implements q, e9.i {
        public b() {
        }
    }

    public static final class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l9.a<?> f9874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?> f9876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r<?> f9877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e9.j<?> f9878e;

        public c(Object obj, l9.a<?> aVar, boolean z10, Class<?> cls) {
            r<?> rVar = obj instanceof r ? (r) obj : null;
            this.f9877d = rVar;
            e9.j<?> jVar = obj instanceof e9.j ? (e9.j) obj : null;
            this.f9878e = jVar;
            g9.a.a((rVar == null && jVar == null) ? false : true);
            this.f9874a = aVar;
            this.f9875b = z10;
            this.f9876c = cls;
        }

        @Override // e9.y
        public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
            boolean zIsAssignableFrom;
            l9.a<?> aVar2 = this.f9874a;
            if (aVar2 != null) {
                zIsAssignableFrom = aVar2.equals(aVar) || (this.f9875b && this.f9874a.d() == aVar.c());
            } else {
                zIsAssignableFrom = this.f9876c.isAssignableFrom(aVar.c());
            }
            if (zIsAssignableFrom) {
                return new m(this.f9877d, this.f9878e, eVar, aVar, this);
            }
            return null;
        }
    }

    public m(r<T> rVar, e9.j<T> jVar, e9.e eVar, l9.a<T> aVar, y yVar) {
        this(rVar, jVar, eVar, aVar, yVar, true);
    }

    public m(r<T> rVar, e9.j<T> jVar, e9.e eVar, l9.a<T> aVar, y yVar, boolean z10) {
        this.f9870f = new b();
        this.f9865a = rVar;
        this.f9866b = jVar;
        this.f9867c = eVar;
        this.f9868d = aVar;
        this.f9869e = yVar;
        this.f9871g = z10;
    }

    public static y h(l9.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.d() == aVar.c(), null);
    }

    @Override // e9.x
    public T c(m9.a aVar) {
        if (this.f9866b == null) {
            return g().c(aVar);
        }
        e9.k kVarA = g9.m.a(aVar);
        if (this.f9871g && kVarA.n()) {
            return null;
        }
        return this.f9866b.a(kVarA, this.f9868d.d(), this.f9870f);
    }

    @Override // e9.x
    public void e(m9.c cVar, T t10) throws IOException {
        r<T> rVar = this.f9865a;
        if (rVar == null) {
            g().e(cVar, t10);
        } else if (this.f9871g && t10 == null) {
            cVar.L();
        } else {
            g9.m.b(rVar.a(t10, this.f9868d.d(), this.f9870f), cVar);
        }
    }

    @Override // h9.l
    public x<T> f() {
        return this.f9865a != null ? this : g();
    }

    public final x<T> g() {
        x<T> xVar = this.f9872h;
        if (xVar != null) {
            return xVar;
        }
        x<T> xVarM = this.f9867c.m(this.f9869e, this.f9868d);
        this.f9872h = xVarM;
        return xVarM;
    }
}
