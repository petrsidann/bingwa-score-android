package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 extends vb.t0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.c f19027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.a1 f19028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb.b1<?, ?> f19029c;

    public w1(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar) {
        this.f19029c = (vb.b1) j6.m.p(b1Var, "method");
        this.f19028b = (vb.a1) j6.m.p(a1Var, "headers");
        this.f19027a = (vb.c) j6.m.p(cVar, "callOptions");
    }

    @Override // vb.t0.g
    public vb.c a() {
        return this.f19027a;
    }

    @Override // vb.t0.g
    public vb.a1 b() {
        return this.f19028b;
    }

    @Override // vb.t0.g
    public vb.b1<?, ?> c() {
        return this.f19029c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w1.class != obj.getClass()) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return j6.i.a(this.f19027a, w1Var.f19027a) && j6.i.a(this.f19028b, w1Var.f19028b) && j6.i.a(this.f19029c, w1Var.f19029c);
    }

    public int hashCode() {
        return j6.i.b(this.f19027a, this.f19028b, this.f19029c);
    }

    public final String toString() {
        return "[method=" + this.f19029c + " headers=" + this.f19028b + " callOptions=" + this.f19027a + "]";
    }
}
