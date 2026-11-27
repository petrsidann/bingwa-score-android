package x;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f17874e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f17870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17871b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17872c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<i> f17873d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17875f = false;

    public interface a {
        float a(i iVar);

        int b();

        void c(i iVar, float f10);

        void clear();

        i d(int i10);

        void e();

        float f(int i10);

        float g(i iVar, boolean z10);

        float h(b bVar, boolean z10);

        void i(i iVar, float f10, boolean z10);

        void j(float f10);

        boolean k(i iVar);
    }

    public b() {
    }

    public b(c cVar) {
        this.f17874e = new x.a(this, cVar);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public java.lang.String A() {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.b.A():java.lang.String");
    }

    public void B(d dVar, i iVar, boolean z10) {
        if (iVar.f17920g) {
            this.f17871b += iVar.f17919f * this.f17874e.a(iVar);
            this.f17874e.g(iVar, z10);
            if (z10) {
                iVar.c(this);
            }
        }
    }

    public void C(b bVar, boolean z10) {
        this.f17871b += bVar.f17871b * this.f17874e.h(bVar, z10);
        if (z10) {
            bVar.f17870a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f17889f.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int iB = this.f17874e.b();
            for (int i10 = 0; i10 < iB; i10++) {
                i iVarD = this.f17874e.d(i10);
                if (iVarD.f17917d != -1 || iVarD.f17920g) {
                    this.f17873d.add(iVarD);
                }
            }
            if (this.f17873d.size() > 0) {
                for (i iVar : this.f17873d) {
                    if (iVar.f17920g) {
                        B(dVar, iVar, true);
                    } else {
                        C(dVar.f17889f[iVar.f17917d], true);
                    }
                }
                this.f17873d.clear();
            } else {
                z10 = true;
            }
        }
    }

    @Override // x.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f17870a = null;
            this.f17874e.clear();
            for (int i10 = 0; i10 < bVar.f17874e.b(); i10++) {
                this.f17874e.i(bVar.f17874e.d(i10), bVar.f17874e.f(i10), true);
            }
        }
    }

    @Override // x.d.a
    public void b(i iVar) {
        int i10 = iVar.f17918e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f17874e.c(iVar, f10);
    }

    @Override // x.d.a
    public i c(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    @Override // x.d.a
    public void clear() {
        this.f17874e.clear();
        this.f17870a = null;
        this.f17871b = 0.0f;
    }

    public b d(d dVar, int i10) {
        this.f17874e.c(dVar.o(i10, "ep"), 1.0f);
        this.f17874e.c(dVar.o(i10, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i10) {
        this.f17874e.c(iVar, i10);
        return this;
    }

    public boolean f(d dVar) {
        boolean z10;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z10 = true;
        } else {
            y(iVarG);
            z10 = false;
        }
        if (this.f17874e.b() == 0) {
            this.f17875f = true;
        }
        return z10;
    }

    public i g(d dVar) {
        int iB = this.f17874e.b();
        i iVar = null;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean zV = false;
        boolean zV2 = false;
        i iVar2 = null;
        for (int i10 = 0; i10 < iB; i10++) {
            float f12 = this.f17874e.f(i10);
            i iVarD = this.f17874e.d(i10);
            if (iVarD.f17923j == i.a.UNRESTRICTED) {
                if (iVar == null || f10 > f12) {
                    zV = v(iVarD, dVar);
                    f10 = f12;
                    iVar = iVarD;
                } else if (!zV && v(iVarD, dVar)) {
                    f10 = f12;
                    iVar = iVarD;
                    zV = true;
                }
            } else if (iVar == null && f12 < 0.0f) {
                if (iVar2 == null || f11 > f12) {
                    zV2 = v(iVarD, dVar);
                    f11 = f12;
                    iVar2 = iVarD;
                } else if (!zV2 && v(iVarD, dVar)) {
                    f11 = f12;
                    iVar2 = iVarD;
                    zV2 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // x.d.a
    public i getKey() {
        return this.f17870a;
    }

    public b h(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11) {
        float f11;
        int i12;
        if (iVar2 == iVar3) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar4, 1.0f);
            this.f17874e.c(iVar2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
            this.f17874e.c(iVar3, -1.0f);
            this.f17874e.c(iVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                i12 = (-i10) + i11;
                f11 = i12;
                this.f17871b = f11;
            }
        } else {
            if (f10 <= 0.0f) {
                this.f17874e.c(iVar, -1.0f);
                this.f17874e.c(iVar2, 1.0f);
                f11 = i10;
            } else if (f10 >= 1.0f) {
                this.f17874e.c(iVar4, -1.0f);
                this.f17874e.c(iVar3, 1.0f);
                i12 = -i11;
                f11 = i12;
            } else {
                float f12 = 1.0f - f10;
                this.f17874e.c(iVar, f12 * 1.0f);
                this.f17874e.c(iVar2, f12 * (-1.0f));
                this.f17874e.c(iVar3, (-1.0f) * f10);
                this.f17874e.c(iVar4, 1.0f * f10);
                if (i10 > 0 || i11 > 0) {
                    f11 = ((-i10) * f12) + (i11 * f10);
                }
            }
            this.f17871b = f11;
        }
        return this;
    }

    public b i(i iVar, int i10) {
        this.f17870a = iVar;
        float f10 = i10;
        iVar.f17919f = f10;
        this.f17871b = f10;
        this.f17875f = true;
        return this;
    }

    public b j(i iVar, i iVar2, float f10) {
        this.f17874e.c(iVar, -1.0f);
        this.f17874e.c(iVar2, f10);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f17874e.c(iVar, -1.0f);
        this.f17874e.c(iVar2, 1.0f);
        this.f17874e.c(iVar3, f10);
        this.f17874e.c(iVar4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f17871b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
            this.f17874e.c(iVar4, 1.0f);
            this.f17874e.c(iVar3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f17874e.c(iVar3, 1.0f);
            this.f17874e.c(iVar4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
            this.f17874e.c(iVar4, f13);
            this.f17874e.c(iVar3, -f13);
        }
        return this;
    }

    public b m(i iVar, int i10) {
        a aVar;
        float f10;
        if (i10 < 0) {
            this.f17871b = i10 * (-1);
            aVar = this.f17874e;
            f10 = 1.0f;
        } else {
            this.f17871b = i10;
            aVar = this.f17874e;
            f10 = -1.0f;
        }
        aVar.c(iVar, f10);
        return this;
    }

    public b n(i iVar, i iVar2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f17871b = i10;
        }
        if (z10) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
        } else {
            this.f17874e.c(iVar, -1.0f);
            this.f17874e.c(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f17871b = i10;
        }
        if (z10) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
            this.f17874e.c(iVar3, -1.0f);
        } else {
            this.f17874e.c(iVar, -1.0f);
            this.f17874e.c(iVar2, 1.0f);
            this.f17874e.c(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f17871b = i10;
        }
        if (z10) {
            this.f17874e.c(iVar, 1.0f);
            this.f17874e.c(iVar2, -1.0f);
            this.f17874e.c(iVar3, 1.0f);
        } else {
            this.f17874e.c(iVar, -1.0f);
            this.f17874e.c(iVar2, 1.0f);
            this.f17874e.c(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f17874e.c(iVar3, 0.5f);
        this.f17874e.c(iVar4, 0.5f);
        this.f17874e.c(iVar, -0.5f);
        this.f17874e.c(iVar2, -0.5f);
        this.f17871b = -f10;
        return this;
    }

    public void r() {
        float f10 = this.f17871b;
        if (f10 < 0.0f) {
            this.f17871b = f10 * (-1.0f);
            this.f17874e.e();
        }
    }

    public boolean s() {
        i iVar = this.f17870a;
        return iVar != null && (iVar.f17923j == i.a.UNRESTRICTED || this.f17871b >= 0.0f);
    }

    public boolean t(i iVar) {
        return this.f17874e.k(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.f17870a == null && this.f17871b == 0.0f && this.f17874e.b() == 0;
    }

    public final boolean v(i iVar, d dVar) {
        return iVar.f17926m <= 1;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    public final i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int iB = this.f17874e.b();
        i iVar2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < iB; i10++) {
            float f11 = this.f17874e.f(i10);
            if (f11 < 0.0f) {
                i iVarD = this.f17874e.d(i10);
                if ((zArr == null || !zArr[iVarD.f17916c]) && iVarD != iVar && (((aVar = iVarD.f17923j) == i.a.SLACK || aVar == i.a.ERROR) && f11 < f10)) {
                    f10 = f11;
                    iVar2 = iVarD;
                }
            }
        }
        return iVar2;
    }

    public void y(i iVar) {
        i iVar2 = this.f17870a;
        if (iVar2 != null) {
            this.f17874e.c(iVar2, -1.0f);
            this.f17870a = null;
        }
        float fG = this.f17874e.g(iVar, true) * (-1.0f);
        this.f17870a = iVar;
        if (fG == 1.0f) {
            return;
        }
        this.f17871b /= fG;
        this.f17874e.j(fG);
    }

    public void z() {
        this.f17870a = null;
        this.f17874e.clear();
        this.f17871b = 0.0f;
        this.f17875f = false;
    }
}
