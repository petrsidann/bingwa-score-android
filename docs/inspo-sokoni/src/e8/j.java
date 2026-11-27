package e8;

import android.content.Context;
import g8.l4;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.firebase.firestore.g f7184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k8.m0 f7185b = new k8.m0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g8.h1 f7186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g8.k0 f7187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f1 f7188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k8.s0 f7189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f7190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g8.l f7191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l4 f7192i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l8.g f7194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l f7195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c8.j f7196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7197e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c8.a<c8.j> f7198f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c8.a<String> f7199g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final k8.i0 f7200h;

        public a(Context context, l8.g gVar, l lVar, c8.j jVar, int i10, c8.a<c8.j> aVar, c8.a<String> aVar2, k8.i0 i0Var) {
            this.f7193a = context;
            this.f7194b = gVar;
            this.f7195c = lVar;
            this.f7196d = jVar;
            this.f7197e = i10;
            this.f7198f = aVar;
            this.f7199g = aVar2;
            this.f7200h = i0Var;
        }
    }

    public j(com.google.firebase.firestore.g gVar) {
        this.f7184a = gVar;
    }

    public static j h(com.google.firebase.firestore.g gVar) {
        return gVar.d() ? new e1(gVar) : new x0(gVar);
    }

    public abstract o a(a aVar);

    public abstract l4 b(a aVar);

    public abstract g8.l c(a aVar);

    public abstract g8.k0 d(a aVar);

    public abstract g8.h1 e(a aVar);

    public abstract k8.s0 f(a aVar);

    public abstract f1 g(a aVar);

    public k8.n i() {
        return this.f7185b.f();
    }

    public k8.q j() {
        return this.f7185b.g();
    }

    public o k() {
        return (o) l8.b.e(this.f7190g, "eventManager not initialized yet", new Object[0]);
    }

    public l4 l() {
        return this.f7192i;
    }

    public g8.l m() {
        return this.f7191h;
    }

    public g8.k0 n() {
        return (g8.k0) l8.b.e(this.f7187d, "localStore not initialized yet", new Object[0]);
    }

    public g8.h1 o() {
        return (g8.h1) l8.b.e(this.f7186c, "persistence not initialized yet", new Object[0]);
    }

    public k8.o0 p() {
        return this.f7185b.j();
    }

    public k8.s0 q() {
        return (k8.s0) l8.b.e(this.f7189f, "remoteStore not initialized yet", new Object[0]);
    }

    public f1 r() {
        return (f1) l8.b.e(this.f7188e, "syncEngine not initialized yet", new Object[0]);
    }

    public void s(a aVar) {
        this.f7185b.k(aVar);
        g8.h1 h1VarE = e(aVar);
        this.f7186c = h1VarE;
        h1VarE.n();
        this.f7187d = d(aVar);
        this.f7189f = f(aVar);
        this.f7188e = g(aVar);
        this.f7190g = a(aVar);
        this.f7187d.q0();
        this.f7189f.P();
        this.f7192i = b(aVar);
        this.f7191h = c(aVar);
    }
}
