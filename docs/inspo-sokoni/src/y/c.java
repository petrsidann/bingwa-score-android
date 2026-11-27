package y;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f19116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f19117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f19118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f19119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f19120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f19121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f19122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<e> f19123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f19126k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19127l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19128m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f19129n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19130o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19131p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19132q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19133r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f19134s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19135t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f19136u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19137v;

    public c(e eVar, int i10, boolean z10) {
        this.f19116a = eVar;
        this.f19131p = i10;
        this.f19132q = z10;
    }

    public static boolean c(e eVar, int i10) {
        int i11;
        return eVar.O() != 8 && eVar.M[i10] == e.b.MATCH_CONSTRAINT && ((i11 = eVar.f19183n[i10]) == 0 || i11 == 3);
    }

    public void a() {
        if (!this.f19137v) {
            b();
        }
        this.f19137v = true;
    }

    public final void b() {
        int i10 = this.f19131p * 2;
        e eVar = this.f19116a;
        this.f19130o = true;
        e eVar2 = eVar;
        boolean z10 = false;
        while (!z10) {
            this.f19124i++;
            e[] eVarArr = eVar.f19194s0;
            int i11 = this.f19131p;
            e eVar3 = null;
            eVarArr[i11] = null;
            eVar.f19192r0[i11] = null;
            if (eVar.O() != 8) {
                this.f19127l++;
                e.b bVarS = eVar.s(this.f19131p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarS != bVar) {
                    this.f19128m += eVar.A(this.f19131p);
                }
                int iC = this.f19128m + eVar.J[i10].c();
                this.f19128m = iC;
                int i12 = i10 + 1;
                this.f19128m = iC + eVar.J[i12].c();
                int iC2 = this.f19129n + eVar.J[i10].c();
                this.f19129n = iC2;
                this.f19129n = iC2 + eVar.J[i12].c();
                if (this.f19117b == null) {
                    this.f19117b = eVar;
                }
                this.f19119d = eVar;
                e.b[] bVarArr = eVar.M;
                int i13 = this.f19131p;
                if (bVarArr[i13] == bVar) {
                    int i14 = eVar.f19183n[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f19125j++;
                        float f10 = eVar.f19190q0[i13];
                        if (f10 > 0.0f) {
                            this.f19126k += f10;
                        }
                        if (c(eVar, i13)) {
                            if (f10 < 0.0f) {
                                this.f19133r = true;
                            } else {
                                this.f19134s = true;
                            }
                            if (this.f19123h == null) {
                                this.f19123h = new ArrayList<>();
                            }
                            this.f19123h.add(eVar);
                        }
                        if (this.f19121f == null) {
                            this.f19121f = eVar;
                        }
                        e eVar4 = this.f19122g;
                        if (eVar4 != null) {
                            eVar4.f19192r0[this.f19131p] = eVar;
                        }
                        this.f19122g = eVar;
                    }
                    if (this.f19131p != 0 ? !(eVar.f19181m == 0 && eVar.f19191r == 0 && eVar.f19193s == 0) : !(eVar.f19179l == 0 && eVar.f19185o == 0 && eVar.f19187p == 0)) {
                        this.f19130o = false;
                    }
                    if (eVar.Q != 0.0f) {
                        this.f19130o = false;
                        this.f19136u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f19194s0[this.f19131p] = eVar;
            }
            d dVar = eVar.J[i10 + 1].f19141d;
            if (dVar != null) {
                e eVar5 = dVar.f19139b;
                d dVar2 = eVar5.J[i10].f19141d;
                if (dVar2 != null && dVar2.f19139b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z10 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f19117b;
        if (eVar6 != null) {
            this.f19128m -= eVar6.J[i10].c();
        }
        e eVar7 = this.f19119d;
        if (eVar7 != null) {
            this.f19128m -= eVar7.J[i10 + 1].c();
        }
        this.f19118c = eVar;
        if (this.f19131p == 0 && this.f19132q) {
            this.f19120e = eVar;
        } else {
            this.f19120e = this.f19116a;
        }
        this.f19135t = this.f19134s && this.f19133r;
    }
}
