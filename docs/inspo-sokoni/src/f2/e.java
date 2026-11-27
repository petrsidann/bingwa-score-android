package f2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import i1.s0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends s0 {

    public class a extends l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f8069a;

        public a(Rect rect) {
            this.f8069a = rect;
        }
    }

    public class b implements l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8072b;

        public b(View view, ArrayList arrayList) {
            this.f8071a = view;
            this.f8072b = arrayList;
        }

        @Override // f2.l.f
        public void a(l lVar) {
        }

        @Override // f2.l.f
        public void b(l lVar) {
        }

        @Override // f2.l.f
        public void c(l lVar) {
            lVar.U(this);
            this.f8071a.setVisibility(8);
            int size = this.f8072b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f8072b.get(i10)).setVisibility(0);
            }
        }

        @Override // f2.l.f
        public void d(l lVar) {
        }

        @Override // f2.l.f
        public void e(l lVar) {
        }
    }

    public class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f8074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f8076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f8078e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8079f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f8074a = obj;
            this.f8075b = arrayList;
            this.f8076c = obj2;
            this.f8077d = arrayList2;
            this.f8078e = obj3;
            this.f8079f = arrayList3;
        }

        @Override // f2.m, f2.l.f
        public void a(l lVar) {
            Object obj = this.f8074a;
            if (obj != null) {
                e.this.D(obj, this.f8075b, null);
            }
            Object obj2 = this.f8076c;
            if (obj2 != null) {
                e.this.D(obj2, this.f8077d, null);
            }
            Object obj3 = this.f8078e;
            if (obj3 != null) {
                e.this.D(obj3, this.f8079f, null);
            }
        }

        @Override // f2.l.f
        public void c(l lVar) {
            lVar.U(this);
        }
    }

    public class d extends l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f8081a;

        public d(Rect rect) {
            this.f8081a = rect;
        }
    }

    public static boolean C(l lVar) {
        return (s0.l(lVar.C()) && s0.l(lVar.D()) && s0.l(lVar.E())) ? false : true;
    }

    @Override // i1.s0
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.F().clear();
            pVar.F().addAll(arrayList2);
            D(pVar, arrayList, arrayList2);
        }
    }

    @Override // i1.s0
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.j0((l) obj);
        return pVar;
    }

    public void D(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        l lVar = (l) obj;
        int i10 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int iM0 = pVar.m0();
            while (i10 < iM0) {
                D(pVar.l0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (C(lVar)) {
            return;
        }
        List<View> listF = lVar.F();
        if (listF.size() == arrayList.size() && listF.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                lVar.b(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                lVar.V(arrayList.get(size2));
            }
        }
    }

    @Override // i1.s0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).b(view);
        }
    }

    @Override // i1.s0
    public void b(Object obj, ArrayList<View> arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i10 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int iM0 = pVar.m0();
            while (i10 < iM0) {
                b(pVar.l0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (C(lVar) || !s0.l(lVar.F())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            lVar.b(arrayList.get(i10));
            i10++;
        }
    }

    @Override // i1.s0
    public void e(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    @Override // i1.s0
    public boolean g(Object obj) {
        return obj instanceof l;
    }

    @Override // i1.s0
    public Object h(Object obj) {
        if (obj != null) {
            return ((l) obj).clone();
        }
        return null;
    }

    @Override // i1.s0
    public Object o(Object obj, Object obj2, Object obj3) {
        l lVarR0 = (l) obj;
        l lVar = (l) obj2;
        l lVar2 = (l) obj3;
        if (lVarR0 != null && lVar != null) {
            lVarR0 = new p().j0(lVarR0).j0(lVar).r0(1);
        } else if (lVarR0 == null) {
            lVarR0 = lVar != null ? lVar : null;
        }
        if (lVar2 == null) {
            return lVarR0;
        }
        p pVar = new p();
        if (lVarR0 != null) {
            pVar.j0(lVarR0);
        }
        pVar.j0(lVar2);
        return pVar;
    }

    @Override // i1.s0
    public Object p(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.j0((l) obj);
        }
        if (obj2 != null) {
            pVar.j0((l) obj2);
        }
        if (obj3 != null) {
            pVar.j0((l) obj3);
        }
        return pVar;
    }

    @Override // i1.s0
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((l) obj).a(new b(view, arrayList));
    }

    @Override // i1.s0
    public void s(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // i1.s0
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).a0(new d(rect));
        }
    }

    @Override // i1.s0
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).a0(new a(rect));
        }
    }

    @Override // i1.s0
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        p pVar = (p) obj;
        List<View> listF = pVar.F();
        listF.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            s0.f(listF, arrayList.get(i10));
        }
        listF.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }
}
