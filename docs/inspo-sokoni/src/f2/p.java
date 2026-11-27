package f2;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class p extends l {
    public int Q;
    public ArrayList<l> O = new ArrayList<>();
    public boolean P = true;
    public boolean R = false;
    public int S = 0;

    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f8147a;

        public a(l lVar) {
            this.f8147a = lVar;
        }

        @Override // f2.l.f
        public void c(l lVar) {
            this.f8147a.Y();
            lVar.U(this);
        }
    }

    public static class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f8149a;

        public b(p pVar) {
            this.f8149a = pVar;
        }

        @Override // f2.m, f2.l.f
        public void a(l lVar) {
            p pVar = this.f8149a;
            if (pVar.R) {
                return;
            }
            pVar.f0();
            this.f8149a.R = true;
        }

        @Override // f2.l.f
        public void c(l lVar) {
            p pVar = this.f8149a;
            int i10 = pVar.Q - 1;
            pVar.Q = i10;
            if (i10 == 0) {
                pVar.R = false;
                pVar.r();
            }
            lVar.U(this);
        }
    }

    @Override // f2.l
    public void S(View view) {
        super.S(view);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).S(view);
        }
    }

    @Override // f2.l
    public void W(View view) {
        super.W(view);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).W(view);
        }
    }

    @Override // f2.l
    public void Y() {
        if (this.O.isEmpty()) {
            f0();
            r();
            return;
        }
        t0();
        if (this.P) {
            Iterator<l> it = this.O.iterator();
            while (it.hasNext()) {
                it.next().Y();
            }
            return;
        }
        for (int i10 = 1; i10 < this.O.size(); i10++) {
            this.O.get(i10 - 1).a(new a(this.O.get(i10)));
        }
        l lVar = this.O.get(0);
        if (lVar != null) {
            lVar.Y();
        }
    }

    @Override // f2.l
    public void a0(l.e eVar) {
        super.a0(eVar);
        this.S |= 8;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).a0(eVar);
        }
    }

    @Override // f2.l
    public void c0(g gVar) {
        super.c0(gVar);
        this.S |= 4;
        if (this.O != null) {
            for (int i10 = 0; i10 < this.O.size(); i10++) {
                this.O.get(i10).c0(gVar);
            }
        }
    }

    @Override // f2.l
    public void d0(o oVar) {
        super.d0(oVar);
        this.S |= 2;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).d0(oVar);
        }
    }

    @Override // f2.l
    public String g0(String str) {
        String strG0 = super.g0(str);
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strG0);
            sb2.append("\n");
            sb2.append(this.O.get(i10).g0(str + "  "));
            strG0 = sb2.toString();
        }
        return strG0;
    }

    @Override // f2.l
    public void h(s sVar) {
        if (L(sVar.f8154b)) {
            for (l lVar : this.O) {
                if (lVar.L(sVar.f8154b)) {
                    lVar.h(sVar);
                    sVar.f8155c.add(lVar);
                }
            }
        }
    }

    @Override // f2.l
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public p a(l.f fVar) {
        return (p) super.a(fVar);
    }

    @Override // f2.l
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public p b(View view) {
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            this.O.get(i10).b(view);
        }
        return (p) super.b(view);
    }

    @Override // f2.l
    public void j(s sVar) {
        super.j(sVar);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).j(sVar);
        }
    }

    public p j0(l lVar) {
        k0(lVar);
        long j10 = this.f8094c;
        if (j10 >= 0) {
            lVar.Z(j10);
        }
        if ((this.S & 1) != 0) {
            lVar.b0(u());
        }
        if ((this.S & 2) != 0) {
            y();
            lVar.d0(null);
        }
        if ((this.S & 4) != 0) {
            lVar.c0(x());
        }
        if ((this.S & 8) != 0) {
            lVar.a0(t());
        }
        return this;
    }

    public final void k0(l lVar) {
        this.O.add(lVar);
        lVar.f8109w = this;
    }

    @Override // f2.l
    public void l(s sVar) {
        if (L(sVar.f8154b)) {
            for (l lVar : this.O) {
                if (lVar.L(sVar.f8154b)) {
                    lVar.l(sVar);
                    sVar.f8155c.add(lVar);
                }
            }
        }
    }

    public l l0(int i10) {
        if (i10 < 0 || i10 >= this.O.size()) {
            return null;
        }
        return this.O.get(i10);
    }

    public int m0() {
        return this.O.size();
    }

    @Override // f2.l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public p U(l.f fVar) {
        return (p) super.U(fVar);
    }

    @Override // f2.l
    /* JADX INFO: renamed from: o */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.O = new ArrayList<>();
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.k0(this.O.get(i10).clone());
        }
        return pVar;
    }

    @Override // f2.l
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public p V(View view) {
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            this.O.get(i10).V(view);
        }
        return (p) super.V(view);
    }

    @Override // f2.l
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public p Z(long j10) {
        ArrayList<l> arrayList;
        super.Z(j10);
        if (this.f8094c >= 0 && (arrayList = this.O) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.O.get(i10).Z(j10);
            }
        }
        return this;
    }

    @Override // f2.l
    public void q(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long jA = A();
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            l lVar = this.O.get(i10);
            if (jA > 0 && (this.P || i10 == 0)) {
                long jA2 = lVar.A();
                if (jA2 > 0) {
                    lVar.e0(jA2 + jA);
                } else {
                    lVar.e0(jA);
                }
            }
            lVar.q(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    @Override // f2.l
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public p b0(TimeInterpolator timeInterpolator) {
        this.S |= 1;
        ArrayList<l> arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.O.get(i10).b0(timeInterpolator);
            }
        }
        return (p) super.b0(timeInterpolator);
    }

    public p r0(int i10) {
        if (i10 == 0) {
            this.P = true;
        } else {
            if (i10 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
            this.P = false;
        }
        return this;
    }

    @Override // f2.l
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public p e0(long j10) {
        return (p) super.e0(j10);
    }

    public final void t0() {
        b bVar = new b(this);
        Iterator<l> it = this.O.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.Q = this.O.size();
    }
}
