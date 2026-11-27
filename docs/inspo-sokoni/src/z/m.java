package z;

/* JADX INFO: loaded from: classes.dex */
public abstract class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y.e f19717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f19718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y.e.b f19719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f19720e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19721f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19722g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f19723h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f19724i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f19725j = b.NONE;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19726a;

        static {
            int[] iArr = new int[y.d.b.values().length];
            f19726a = iArr;
            try {
                iArr[y.d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19726a[y.d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19726a[y.d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19726a[y.d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19726a[y.d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public m(y.e eVar) {
        this.f19717b = eVar;
    }

    @Override // z.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i10) {
        fVar.f19692l.add(fVar2);
        fVar.f19686f = i10;
        fVar2.f19691k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f19692l.add(fVar2);
        fVar.f19692l.add(this.f19720e);
        fVar.f19688h = i10;
        fVar.f19689i = gVar;
        fVar2.f19691k.add(fVar);
        gVar.f19691k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        int iMax;
        if (i11 == 0) {
            y.e eVar = this.f19717b;
            int i12 = eVar.f19187p;
            iMax = Math.max(eVar.f19185o, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        } else {
            y.e eVar2 = this.f19717b;
            int i13 = eVar2.f19193s;
            iMax = Math.max(eVar2.f19191r, i10);
            if (i13 > 0) {
                iMax = Math.min(i13, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        }
        return iMax;
    }

    public final f h(y.d dVar) {
        m mVar;
        m mVar2;
        y.d dVar2 = dVar.f19141d;
        if (dVar2 == null) {
            return null;
        }
        y.e eVar = dVar2.f19139b;
        int i10 = a.f19726a[dVar2.f19140c.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                mVar2 = eVar.f19165e;
            } else if (i10 == 3) {
                mVar = eVar.f19167f;
            } else {
                if (i10 == 4) {
                    return eVar.f19167f.f19713k;
                }
                if (i10 != 5) {
                    return null;
                }
                mVar2 = eVar.f19167f;
            }
            return mVar2.f19724i;
        }
        mVar = eVar.f19165e;
        return mVar.f19723h;
    }

    public final f i(y.d dVar, int i10) {
        y.d dVar2 = dVar.f19141d;
        if (dVar2 == null) {
            return null;
        }
        y.e eVar = dVar2.f19139b;
        m mVar = i10 == 0 ? eVar.f19165e : eVar.f19167f;
        int i11 = a.f19726a[dVar2.f19140c.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return mVar.f19724i;
        }
        return mVar.f19723h;
    }

    public long j() {
        g gVar = this.f19720e;
        if (gVar.f19690j) {
            return gVar.f19687g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f19722g;
    }

    public final void l(int i10, int i11) {
        g gVar;
        int iG;
        int i12 = this.f19716a;
        if (i12 == 0) {
            gVar = this.f19720e;
            iG = g(i11, i10);
        } else if (i12 == 1) {
            int iG2 = g(this.f19720e.f19702m, i10);
            gVar = this.f19720e;
            iG = Math.min(iG2, i11);
        } else {
            if (i12 != 2) {
                if (i12 != 3) {
                    return;
                }
                y.e eVar = this.f19717b;
                m mVar = eVar.f19165e;
                y.e.b bVar = mVar.f19719d;
                y.e.b bVar2 = y.e.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && mVar.f19716a == 3) {
                    l lVar = eVar.f19167f;
                    if (lVar.f19719d == bVar2 && lVar.f19716a == 3) {
                        return;
                    }
                }
                if (i10 == 0) {
                    mVar = eVar.f19167f;
                }
                if (mVar.f19720e.f19690j) {
                    float fT = eVar.t();
                    this.f19720e.d(i10 == 1 ? (int) ((mVar.f19720e.f19687g / fT) + 0.5f) : (int) ((fT * mVar.f19720e.f19687g) + 0.5f));
                    return;
                }
                return;
            }
            y.e eVarG = this.f19717b.G();
            if (eVarG == null) {
                return;
            }
            g gVar2 = (i10 == 0 ? eVarG.f19165e : eVarG.f19167f).f19720e;
            if (!gVar2.f19690j) {
                return;
            }
            y.e eVar2 = this.f19717b;
            i11 = (int) ((gVar2.f19687g * (i10 == 0 ? eVar2.f19189q : eVar2.f19195t)) + 0.5f);
            gVar = this.f19720e;
            iG = g(i11, i10);
        }
        gVar.d(iG);
    }

    public abstract boolean m();

    public void n(d dVar, y.d dVar2, y.d dVar3, int i10) {
        f fVar;
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f19690j && fVarH2.f19690j) {
            int iC = fVarH.f19687g + dVar2.c();
            int iC2 = fVarH2.f19687g - dVar3.c();
            int i11 = iC2 - iC;
            if (!this.f19720e.f19690j && this.f19719d == y.e.b.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            g gVar = this.f19720e;
            if (gVar.f19690j) {
                if (gVar.f19687g == i11) {
                    this.f19723h.d(iC);
                    fVar = this.f19724i;
                } else {
                    y.e eVar = this.f19717b;
                    float fW = i10 == 0 ? eVar.w() : eVar.K();
                    if (fVarH == fVarH2) {
                        iC = fVarH.f19687g;
                        iC2 = fVarH2.f19687g;
                        fW = 0.5f;
                    }
                    this.f19723h.d((int) (iC + 0.5f + (((iC2 - iC) - this.f19720e.f19687g) * fW)));
                    fVar = this.f19724i;
                    iC2 = this.f19723h.f19687g + this.f19720e.f19687g;
                }
                fVar.d(iC2);
            }
        }
    }

    public void o(d dVar) {
    }

    public void p(d dVar) {
    }
}
