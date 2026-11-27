package i1;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends p0 implements h0.n {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h0 f10113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10116w;

    public a(h0 h0Var) {
        super(h0Var.t0(), h0Var.v0() != null ? h0Var.v0().o().getClassLoader() : null);
        this.f10115v = -1;
        this.f10116w = false;
        this.f10113t = h0Var;
    }

    @Override // i1.h0.n
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f10384i) {
            return true;
        }
        this.f10113t.h(this);
        return true;
    }

    @Override // i1.p0
    public int f() {
        return q(false);
    }

    @Override // i1.p0
    public int g() {
        return q(true);
    }

    @Override // i1.p0
    public void h() {
        j();
        this.f10113t.b0(this, false);
    }

    @Override // i1.p0
    public void i() {
        j();
        this.f10113t.b0(this, true);
    }

    @Override // i1.p0
    public void k(int i10, p pVar, String str, int i11) {
        super.k(i10, pVar, str, i11);
        pVar.f10346z = this.f10113t;
    }

    @Override // i1.p0
    public p0 l(p pVar) {
        h0 h0Var = pVar.f10346z;
        if (h0Var == null || h0Var == this.f10113t) {
            return super.l(pVar);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + pVar.toString() + " is already attached to a FragmentManager.");
    }

    public void p(int i10) {
        if (this.f10384i) {
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f10378c.size();
            for (int i11 = 0; i11 < size; i11++) {
                p0.a aVar = this.f10378c.get(i11);
                p pVar = aVar.f10396b;
                if (pVar != null) {
                    pVar.f10345y += i10;
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f10396b + " to " + aVar.f10396b.f10345y);
                    }
                }
            }
        }
    }

    public int q(boolean z10) {
        if (this.f10114u) {
            throw new IllegalStateException("commit already called");
        }
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new u0("FragmentManager"));
            r("  ", printWriter);
            printWriter.close();
        }
        this.f10114u = true;
        this.f10115v = this.f10384i ? this.f10113t.k() : -1;
        this.f10113t.Y(this, z10);
        return this.f10115v;
    }

    public void r(String str, PrintWriter printWriter) {
        s(str, printWriter, true);
    }

    public void s(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f10386k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f10115v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f10114u);
            if (this.f10383h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f10383h));
            }
            if (this.f10379d != 0 || this.f10380e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f10379d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f10380e));
            }
            if (this.f10381f != 0 || this.f10382g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f10381f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f10382g));
            }
            if (this.f10387l != 0 || this.f10388m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f10387l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f10388m);
            }
            if (this.f10389n != 0 || this.f10390o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f10389n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f10390o);
            }
        }
        if (this.f10378c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f10378c.size();
        for (int i10 = 0; i10 < size; i10++) {
            p0.a aVar = this.f10378c.get(i10);
            switch (aVar.f10395a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f10395a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f10396b);
            if (z10) {
                if (aVar.f10398d != 0 || aVar.f10399e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f10398d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f10399e));
                }
                if (aVar.f10400f != 0 || aVar.f10401g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f10400f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f10401g));
                }
            }
        }
    }

    public void t() {
        h0 h0Var;
        int size = this.f10378c.size();
        for (int i10 = 0; i10 < size; i10++) {
            p0.a aVar = this.f10378c.get(i10);
            p pVar = aVar.f10396b;
            if (pVar != null) {
                pVar.f10340t = this.f10116w;
                pVar.z1(false);
                pVar.y1(this.f10383h);
                pVar.B1(this.f10391p, this.f10392q);
            }
            switch (aVar.f10395a) {
                case 1:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.o1(pVar, false);
                    this.f10113t.i(pVar);
                    continue;
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f10395a);
                case 3:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.h1(pVar);
                    continue;
                    break;
                case 4:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.F0(pVar);
                    continue;
                    break;
                case 5:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.o1(pVar, false);
                    this.f10113t.s1(pVar);
                    continue;
                    break;
                case 6:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.w(pVar);
                    continue;
                    break;
                case 7:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.o1(pVar, false);
                    this.f10113t.m(pVar);
                    continue;
                    break;
                case 8:
                    h0Var = this.f10113t;
                    break;
                case 9:
                    h0Var = this.f10113t;
                    pVar = null;
                    break;
                case 10:
                    this.f10113t.p1(pVar, aVar.f10403i);
                    continue;
                    break;
            }
            h0Var.q1(pVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f10115v >= 0) {
            sb2.append(" #");
            sb2.append(this.f10115v);
        }
        if (this.f10386k != null) {
            sb2.append(" ");
            sb2.append(this.f10386k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public void u() {
        h0 h0Var;
        for (int size = this.f10378c.size() - 1; size >= 0; size--) {
            p0.a aVar = this.f10378c.get(size);
            p pVar = aVar.f10396b;
            if (pVar != null) {
                pVar.f10340t = this.f10116w;
                pVar.z1(true);
                pVar.y1(h0.l1(this.f10383h));
                pVar.B1(this.f10392q, this.f10391p);
            }
            switch (aVar.f10395a) {
                case 1:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.o1(pVar, true);
                    this.f10113t.h1(pVar);
                    continue;
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f10395a);
                case 3:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.i(pVar);
                    continue;
                    break;
                case 4:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.s1(pVar);
                    continue;
                    break;
                case 5:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.o1(pVar, true);
                    this.f10113t.F0(pVar);
                    continue;
                    break;
                case 6:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.m(pVar);
                    continue;
                    break;
                case 7:
                    pVar.v1(aVar.f10398d, aVar.f10399e, aVar.f10400f, aVar.f10401g);
                    this.f10113t.o1(pVar, true);
                    this.f10113t.w(pVar);
                    continue;
                    break;
                case 8:
                    h0Var = this.f10113t;
                    pVar = null;
                    break;
                case 9:
                    h0Var = this.f10113t;
                    break;
                case 10:
                    this.f10113t.p1(pVar, aVar.f10402h);
                    continue;
                    break;
            }
            h0Var.q1(pVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    public p v(ArrayList<p> arrayList, p pVar) {
        p pVar2 = pVar;
        int i10 = 0;
        while (i10 < this.f10378c.size()) {
            p0.a aVar = this.f10378c.get(i10);
            int i11 = aVar.f10395a;
            if (i11 == 1) {
                arrayList.add(aVar.f10396b);
            } else if (i11 == 2) {
                p pVar3 = aVar.f10396b;
                int i12 = pVar3.E;
                boolean z10 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    p pVar4 = arrayList.get(size);
                    if (pVar4.E == i12) {
                        if (pVar4 == pVar3) {
                            z10 = true;
                        } else {
                            if (pVar4 == pVar2) {
                                this.f10378c.add(i10, new p0.a(9, pVar4, true));
                                i10++;
                                pVar2 = null;
                            }
                            p0.a aVar2 = new p0.a(3, pVar4, true);
                            aVar2.f10398d = aVar.f10398d;
                            aVar2.f10400f = aVar.f10400f;
                            aVar2.f10399e = aVar.f10399e;
                            aVar2.f10401g = aVar.f10401g;
                            this.f10378c.add(i10, aVar2);
                            arrayList.remove(pVar4);
                            i10++;
                        }
                    }
                }
                if (z10) {
                    this.f10378c.remove(i10);
                    i10--;
                } else {
                    aVar.f10395a = 1;
                    aVar.f10397c = true;
                    arrayList.add(pVar3);
                }
            } else if (i11 == 3 || i11 == 6) {
                arrayList.remove(aVar.f10396b);
                p pVar5 = aVar.f10396b;
                if (pVar5 == pVar2) {
                    this.f10378c.add(i10, new p0.a(9, pVar5));
                    i10++;
                    pVar2 = null;
                }
            } else if (i11 == 7) {
                arrayList.add(aVar.f10396b);
            } else if (i11 == 8) {
                this.f10378c.add(i10, new p0.a(9, pVar2, true));
                aVar.f10397c = true;
                i10++;
                pVar2 = aVar.f10396b;
            }
            i10++;
        }
        return pVar2;
    }

    public String w() {
        return this.f10386k;
    }

    public void x() {
        if (this.f10394s != null) {
            for (int i10 = 0; i10 < this.f10394s.size(); i10++) {
                this.f10394s.get(i10).run();
            }
            this.f10394s = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    public p y(ArrayList<p> arrayList, p pVar) {
        for (int size = this.f10378c.size() - 1; size >= 0; size--) {
            p0.a aVar = this.f10378c.get(size);
            int i10 = aVar.f10395a;
            if (i10 == 1) {
                arrayList.remove(aVar.f10396b);
            } else if (i10 != 3) {
                switch (i10) {
                    case 6:
                        arrayList.add(aVar.f10396b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f10396b);
                        break;
                    case 8:
                        pVar = null;
                        break;
                    case 9:
                        pVar = aVar.f10396b;
                        break;
                    case 10:
                        aVar.f10403i = aVar.f10402h;
                        break;
                }
            } else {
                arrayList.add(aVar.f10396b);
            }
        }
        return pVar;
    }
}
