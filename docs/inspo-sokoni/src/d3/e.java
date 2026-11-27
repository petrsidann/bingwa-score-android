package d3;

import android.content.Context;
import java.util.concurrent.Executor;
import k3.w;
import k3.x;
import l3.m0;
import l3.n0;
import l3.u0;

/* JADX INFO: loaded from: classes.dex */
public final class e extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kc.a<Executor> f6331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kc.a<Context> f6332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kc.a f6333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kc.a f6334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kc.a f6335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kc.a<String> f6336f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public kc.a<m0> f6337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public kc.a<k3.f> f6338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public kc.a<x> f6339n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public kc.a<j3.c> f6340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kc.a<k3.r> f6341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public kc.a<k3.v> f6342q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public kc.a<t> f6343r;

    public static final class b implements u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6344a;

        public b() {
        }

        @Override // d3.u.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f6344a = (Context) f3.d.b(context);
            return this;
        }

        @Override // d3.u.a
        public u build() {
            f3.d.a(this.f6344a, Context.class);
            return new e(this.f6344a);
        }
    }

    public e(Context context) {
        t(context);
    }

    public static u.a k() {
        return new b();
    }

    @Override // d3.u
    public l3.d d() {
        return this.f6337l.get();
    }

    @Override // d3.u
    public t e() {
        return this.f6343r.get();
    }

    public final void t(Context context) {
        this.f6331a = f3.a.a(k.a());
        f3.b bVarA = f3.c.a(context);
        this.f6332b = bVarA;
        e3.j jVarA = e3.j.a(bVarA, n3.c.a(), n3.d.a());
        this.f6333c = jVarA;
        this.f6334d = f3.a.a(e3.l.a(this.f6332b, jVarA));
        this.f6335e = u0.a(this.f6332b, l3.g.a(), l3.i.a());
        this.f6336f = f3.a.a(l3.h.a(this.f6332b));
        this.f6337l = f3.a.a(n0.a(n3.c.a(), n3.d.a(), l3.j.a(), this.f6335e, this.f6336f));
        j3.g gVarB = j3.g.b(n3.c.a());
        this.f6338m = gVarB;
        j3.i iVarA = j3.i.a(this.f6332b, this.f6337l, gVarB, n3.d.a());
        this.f6339n = iVarA;
        kc.a<Executor> aVar = this.f6331a;
        kc.a aVar2 = this.f6334d;
        kc.a<m0> aVar3 = this.f6337l;
        this.f6340o = j3.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
        kc.a<Context> aVar4 = this.f6332b;
        kc.a aVar5 = this.f6334d;
        kc.a<m0> aVar6 = this.f6337l;
        this.f6341p = k3.s.a(aVar4, aVar5, aVar6, this.f6339n, this.f6331a, aVar6, n3.c.a(), n3.d.a(), this.f6337l);
        kc.a<Executor> aVar7 = this.f6331a;
        kc.a<m0> aVar8 = this.f6337l;
        this.f6342q = w.a(aVar7, aVar8, this.f6339n, aVar8);
        this.f6343r = f3.a.a(v.a(n3.c.a(), n3.d.a(), this.f6340o, this.f6341p, this.f6342q));
    }
}
