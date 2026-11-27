package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Cloneable {
    public static final int[] L = {2, 1, 3, 4};
    public static final g M = new a();
    public static ThreadLocal<t.a<Animator, d>> N = new ThreadLocal<>();
    public e I;
    public t.a<String, String> J;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<s> f8111y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ArrayList<s> f8112z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8092a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8093b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8094c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f8095d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Integer> f8096e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<View> f8097f = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<String> f8098l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<Class<?>> f8099m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<Integer> f8100n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<View> f8101o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<Class<?>> f8102p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<String> f8103q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<Integer> f8104r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<View> f8105s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<Class<?>> f8106t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public t f8107u = new t();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public t f8108v = new t();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p f8109w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f8110x = L;
    public ViewGroup A = null;
    public boolean B = false;
    public ArrayList<Animator> C = new ArrayList<>();
    public int D = 0;
    public boolean E = false;
    public boolean F = false;
    public ArrayList<f> G = null;
    public ArrayList<Animator> H = new ArrayList<>();
    public g K = M;

    public static class a extends g {
        @Override // f2.g
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f8113a;

        public b(t.a aVar) {
            this.f8113a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8113a.remove(animator);
            l.this.C.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l.this.C.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.r();
            animator.removeListener(this);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f8116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f8118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public p0 f8119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l f8120e;

        public d(View view, String str, l lVar, p0 p0Var, s sVar) {
            this.f8116a = view;
            this.f8117b = str;
            this.f8118c = sVar;
            this.f8119d = p0Var;
            this.f8120e = lVar;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    public static boolean M(s sVar, s sVar2, String str) {
        Object obj = sVar.f8153a.get(str);
        Object obj2 = sVar2.f8153a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void d(t tVar, View view, s sVar) {
        tVar.f8156a.put(view, sVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (tVar.f8157b.indexOfKey(id2) >= 0) {
                tVar.f8157b.put(id2, null);
            } else {
                tVar.f8157b.put(id2, view);
            }
        }
        String strJ = p0.p0.J(view);
        if (strJ != null) {
            if (tVar.f8159d.containsKey(strJ)) {
                tVar.f8159d.put(strJ, null);
            } else {
                tVar.f8159d.put(strJ, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f8158c.g(itemIdAtPosition) < 0) {
                    p0.p0.y0(view, true);
                    tVar.f8158c.i(itemIdAtPosition, view);
                    return;
                }
                View viewD = tVar.f8158c.d(itemIdAtPosition);
                if (viewD != null) {
                    p0.p0.y0(viewD, false);
                    tVar.f8158c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    public static t.a<Animator, d> z() {
        t.a<Animator, d> aVar = N.get();
        if (aVar != null) {
            return aVar;
        }
        t.a<Animator, d> aVar2 = new t.a<>();
        N.set(aVar2);
        return aVar2;
    }

    public long A() {
        return this.f8093b;
    }

    public List<Integer> C() {
        return this.f8096e;
    }

    public List<String> D() {
        return this.f8098l;
    }

    public List<Class<?>> E() {
        return this.f8099m;
    }

    public List<View> F() {
        return this.f8097f;
    }

    public String[] H() {
        return null;
    }

    public s I(View view, boolean z10) {
        p pVar = this.f8109w;
        if (pVar != null) {
            return pVar.I(view, z10);
        }
        return (z10 ? this.f8107u : this.f8108v).f8156a.get(view);
    }

    public boolean K(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrH = H();
        if (strArrH == null) {
            Iterator<String> it = sVar.f8153a.keySet().iterator();
            while (it.hasNext()) {
                if (M(sVar, sVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrH) {
            if (!M(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean L(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f8100n;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f8101o;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f8102p;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f8102p.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f8103q != null && p0.p0.J(view) != null && this.f8103q.contains(p0.p0.J(view))) {
            return false;
        }
        if ((this.f8096e.size() == 0 && this.f8097f.size() == 0 && (((arrayList = this.f8099m) == null || arrayList.isEmpty()) && ((arrayList2 = this.f8098l) == null || arrayList2.isEmpty()))) || this.f8096e.contains(Integer.valueOf(id2)) || this.f8097f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f8098l;
        if (arrayList6 != null && arrayList6.contains(p0.p0.J(view))) {
            return true;
        }
        if (this.f8099m != null) {
            for (int i11 = 0; i11 < this.f8099m.size(); i11++) {
                if (this.f8099m.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void N(t.a<View, s> aVar, t.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewValueAt = sparseArray.valueAt(i10);
            if (viewValueAt != null && L(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && L(view)) {
                s sVar = aVar.get(viewValueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f8111y.add(sVar);
                    this.f8112z.add(sVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void O(t.a<View, s> aVar, t.a<View, s> aVar2) {
        s sVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewI = aVar.i(size);
            if (viewI != null && L(viewI) && (sVarRemove = aVar2.remove(viewI)) != null && L(sVarRemove.f8154b)) {
                this.f8111y.add(aVar.k(size));
                this.f8112z.add(sVarRemove);
            }
        }
    }

    public final void P(t.a<View, s> aVar, t.a<View, s> aVar2, t.d<View> dVar, t.d<View> dVar2) {
        View viewD;
        int iM = dVar.m();
        for (int i10 = 0; i10 < iM; i10++) {
            View viewN = dVar.n(i10);
            if (viewN != null && L(viewN) && (viewD = dVar2.d(dVar.h(i10))) != null && L(viewD)) {
                s sVar = aVar.get(viewN);
                s sVar2 = aVar2.get(viewD);
                if (sVar != null && sVar2 != null) {
                    this.f8111y.add(sVar);
                    this.f8112z.add(sVar2);
                    aVar.remove(viewN);
                    aVar2.remove(viewD);
                }
            }
        }
    }

    public final void Q(t.a<View, s> aVar, t.a<View, s> aVar2, t.a<String, View> aVar3, t.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewM = aVar3.m(i10);
            if (viewM != null && L(viewM) && (view = aVar4.get(aVar3.i(i10))) != null && L(view)) {
                s sVar = aVar.get(viewM);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f8111y.add(sVar);
                    this.f8112z.add(sVar2);
                    aVar.remove(viewM);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void R(t tVar, t tVar2) {
        t.a<View, s> aVar = new t.a<>(tVar.f8156a);
        t.a<View, s> aVar2 = new t.a<>(tVar2.f8156a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f8110x;
            if (i10 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 1) {
                O(aVar, aVar2);
            } else if (i11 == 2) {
                Q(aVar, aVar2, tVar.f8159d, tVar2.f8159d);
            } else if (i11 == 3) {
                N(aVar, aVar2, tVar.f8157b, tVar2.f8157b);
            } else if (i11 == 4) {
                P(aVar, aVar2, tVar.f8158c, tVar2.f8158c);
            }
            i10++;
        }
    }

    public void S(View view) {
        if (this.F) {
            return;
        }
        t.a<Animator, d> aVarZ = z();
        int size = aVarZ.size();
        p0 p0VarD = a0.d(view);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            d dVarM = aVarZ.m(i10);
            if (dVarM.f8116a != null && p0VarD.equals(dVarM.f8119d)) {
                f2.a.b(aVarZ.i(i10));
            }
        }
        ArrayList<f> arrayList = this.G;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.G.clone();
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((f) arrayList2.get(i11)).b(this);
            }
        }
        this.E = true;
    }

    public void T(ViewGroup viewGroup) {
        d dVar;
        this.f8111y = new ArrayList<>();
        this.f8112z = new ArrayList<>();
        R(this.f8107u, this.f8108v);
        t.a<Animator, d> aVarZ = z();
        int size = aVarZ.size();
        p0 p0VarD = a0.d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animatorI = aVarZ.i(i10);
            if (animatorI != null && (dVar = aVarZ.get(animatorI)) != null && dVar.f8116a != null && p0VarD.equals(dVar.f8119d)) {
                s sVar = dVar.f8118c;
                View view = dVar.f8116a;
                s sVarI = I(view, true);
                s sVarV = v(view, true);
                if (sVarI == null && sVarV == null) {
                    sVarV = this.f8108v.f8156a.get(view);
                }
                if (!(sVarI == null && sVarV == null) && dVar.f8120e.K(sVar, sVarV)) {
                    if (animatorI.isRunning() || animatorI.isStarted()) {
                        animatorI.cancel();
                    } else {
                        aVarZ.remove(animatorI);
                    }
                }
            }
        }
        q(viewGroup, this.f8107u, this.f8108v, this.f8111y, this.f8112z);
        Y();
    }

    public l U(f fVar) {
        ArrayList<f> arrayList = this.G;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.G.size() == 0) {
            this.G = null;
        }
        return this;
    }

    public l V(View view) {
        this.f8097f.remove(view);
        return this;
    }

    public void W(View view) {
        if (this.E) {
            if (!this.F) {
                t.a<Animator, d> aVarZ = z();
                int size = aVarZ.size();
                p0 p0VarD = a0.d(view);
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    d dVarM = aVarZ.m(i10);
                    if (dVarM.f8116a != null && p0VarD.equals(dVarM.f8119d)) {
                        f2.a.c(aVarZ.i(i10));
                    }
                }
                ArrayList<f> arrayList = this.G;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.G.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((f) arrayList2.get(i11)).e(this);
                    }
                }
            }
            this.E = false;
        }
    }

    public final void X(Animator animator, t.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            f(animator);
        }
    }

    public void Y() {
        f0();
        t.a<Animator, d> aVarZ = z();
        for (Animator animator : this.H) {
            if (aVarZ.containsKey(animator)) {
                f0();
                X(animator, aVarZ);
            }
        }
        this.H.clear();
        r();
    }

    public l Z(long j10) {
        this.f8094c = j10;
        return this;
    }

    public l a(f fVar) {
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        this.G.add(fVar);
        return this;
    }

    public void a0(e eVar) {
        this.I = eVar;
    }

    public l b(View view) {
        this.f8097f.add(view);
        return this;
    }

    public l b0(TimeInterpolator timeInterpolator) {
        this.f8095d = timeInterpolator;
        return this;
    }

    public final void c(t.a<View, s> aVar, t.a<View, s> aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            s sVarM = aVar.m(i10);
            if (L(sVarM.f8154b)) {
                this.f8111y.add(sVarM);
                this.f8112z.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            s sVarM2 = aVar2.m(i11);
            if (L(sVarM2.f8154b)) {
                this.f8112z.add(sVarM2);
                this.f8111y.add(null);
            }
        }
    }

    public void c0(g gVar) {
        if (gVar == null) {
            gVar = M;
        }
        this.K = gVar;
    }

    public void d0(o oVar) {
    }

    public l e0(long j10) {
        this.f8093b = j10;
        return this;
    }

    public void f(Animator animator) {
        if (animator == null) {
            r();
            return;
        }
        if (s() >= 0) {
            animator.setDuration(s());
        }
        if (A() >= 0) {
            animator.setStartDelay(A() + animator.getStartDelay());
        }
        if (u() != null) {
            animator.setInterpolator(u());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void f0() {
        if (this.D == 0) {
            ArrayList<f> arrayList = this.G;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.G.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((f) arrayList2.get(i10)).a(this);
                }
            }
            this.F = false;
        }
        this.D++;
    }

    public void g() {
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.C.get(size).cancel();
        }
        ArrayList<f> arrayList = this.G;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.G.clone();
        int size2 = arrayList2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            ((f) arrayList2.get(i10)).d(this);
        }
    }

    public String g0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f8094c != -1) {
            str2 = str2 + "dur(" + this.f8094c + ") ";
        }
        if (this.f8093b != -1) {
            str2 = str2 + "dly(" + this.f8093b + ") ";
        }
        if (this.f8095d != null) {
            str2 = str2 + "interp(" + this.f8095d + ") ";
        }
        if (this.f8096e.size() <= 0 && this.f8097f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f8096e.size() > 0) {
            for (int i10 = 0; i10 < this.f8096e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f8096e.get(i10);
            }
        }
        if (this.f8097f.size() > 0) {
            for (int i11 = 0; i11 < this.f8097f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f8097f.get(i11);
            }
        }
        return str3 + ")";
    }

    public abstract void h(s sVar);

    public final void i(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.f8100n;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
            ArrayList<View> arrayList2 = this.f8101o;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f8102p;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f8102p.get(i10).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z10) {
                        l(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f8155c.add(this);
                    j(sVar);
                    d(z10 ? this.f8107u : this.f8108v, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f8104r;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                        ArrayList<View> arrayList5 = this.f8105s;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f8106t;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    if (this.f8106t.get(i11).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                i(viewGroup.getChildAt(i12), z10);
                            }
                        }
                    }
                }
            }
        }
    }

    public void j(s sVar) {
    }

    public abstract void l(s sVar);

    public void m(ViewGroup viewGroup, boolean z10) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        t.a<String, String> aVar;
        n(z10);
        if ((this.f8096e.size() > 0 || this.f8097f.size() > 0) && (((arrayList = this.f8098l) == null || arrayList.isEmpty()) && ((arrayList2 = this.f8099m) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f8096e.size(); i10++) {
                View viewFindViewById = viewGroup.findViewById(this.f8096e.get(i10).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z10) {
                        l(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f8155c.add(this);
                    j(sVar);
                    d(z10 ? this.f8107u : this.f8108v, viewFindViewById, sVar);
                }
            }
            for (int i11 = 0; i11 < this.f8097f.size(); i11++) {
                View view = this.f8097f.get(i11);
                s sVar2 = new s(view);
                if (z10) {
                    l(sVar2);
                } else {
                    h(sVar2);
                }
                sVar2.f8155c.add(this);
                j(sVar2);
                d(z10 ? this.f8107u : this.f8108v, view, sVar2);
            }
        } else {
            i(viewGroup, z10);
        }
        if (z10 || (aVar = this.J) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList3.add(this.f8107u.f8159d.remove(this.J.i(i12)));
        }
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = (View) arrayList3.get(i13);
            if (view2 != null) {
                this.f8107u.f8159d.put(this.J.m(i13), view2);
            }
        }
    }

    public void n(boolean z10) {
        t tVar;
        if (z10) {
            this.f8107u.f8156a.clear();
            this.f8107u.f8157b.clear();
            tVar = this.f8107u;
        } else {
            this.f8108v.f8156a.clear();
            this.f8108v.f8157b.clear();
            tVar = this.f8108v;
        }
        tVar.f8158c.a();
    }

    @Override // 
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.H = new ArrayList<>();
            lVar.f8107u = new t();
            lVar.f8108v = new t();
            lVar.f8111y = null;
            lVar.f8112z = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator p(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    public void q(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        t.a<Animator, d> aVarZ = z();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int i10 = 0;
        for (int size = arrayList.size(); i10 < size; size = size) {
            s sVar3 = arrayList.get(i10);
            s sVar4 = arrayList2.get(i10);
            if (sVar3 != null && !sVar3.f8155c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f8155c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if (sVar3 == null || sVar4 == null || K(sVar3, sVar4)) {
                    Animator animatorP = p(viewGroup, sVar3, sVar4);
                    if (animatorP != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f8154b;
                            String[] strArrH = H();
                            if (strArrH != null && strArrH.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = tVar2.f8156a.get(view2);
                                if (sVar5 != null) {
                                    int i11 = 0;
                                    while (i11 < strArrH.length) {
                                        Map<String, Object> map = sVar2.f8153a;
                                        Animator animator3 = animatorP;
                                        String str = strArrH[i11];
                                        map.put(str, sVar5.f8153a.get(str));
                                        i11++;
                                        animatorP = animator3;
                                        strArrH = strArrH;
                                    }
                                }
                                Animator animator4 = animatorP;
                                int size2 = aVarZ.size();
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= size2) {
                                        animator2 = animator4;
                                        break;
                                    }
                                    d dVar = aVarZ.get(aVarZ.i(i12));
                                    if (dVar.f8118c != null && dVar.f8116a == view2 && dVar.f8117b.equals(w()) && dVar.f8118c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i12++;
                                }
                            } else {
                                animator2 = animatorP;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            view = sVar3.f8154b;
                            animator = animatorP;
                            sVar = null;
                        }
                        if (animator != null) {
                            aVarZ.put(animator, new d(view, w(), this, a0.d(viewGroup), sVar));
                            this.H.add(animator);
                        }
                    }
                }
            }
            i10++;
        }
        if (sparseIntArray.size() != 0) {
            for (int i13 = 0; i13 < sparseIntArray.size(); i13++) {
                Animator animator5 = this.H.get(sparseIntArray.keyAt(i13));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i13)) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    public void r() {
        int i10 = this.D - 1;
        this.D = i10;
        if (i10 == 0) {
            ArrayList<f> arrayList = this.G;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.G.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).c(this);
                }
            }
            for (int i12 = 0; i12 < this.f8107u.f8158c.m(); i12++) {
                View viewN = this.f8107u.f8158c.n(i12);
                if (viewN != null) {
                    p0.p0.y0(viewN, false);
                }
            }
            for (int i13 = 0; i13 < this.f8108v.f8158c.m(); i13++) {
                View viewN2 = this.f8108v.f8158c.n(i13);
                if (viewN2 != null) {
                    p0.p0.y0(viewN2, false);
                }
            }
            this.F = true;
        }
    }

    public long s() {
        return this.f8094c;
    }

    public e t() {
        return this.I;
    }

    public String toString() {
        return g0("");
    }

    public TimeInterpolator u() {
        return this.f8095d;
    }

    public s v(View view, boolean z10) {
        p pVar = this.f8109w;
        if (pVar != null) {
            return pVar.v(view, z10);
        }
        ArrayList<s> arrayList = z10 ? this.f8111y : this.f8112z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            s sVar = arrayList.get(i10);
            if (sVar == null) {
                return null;
            }
            if (sVar.f8154b == view) {
                break;
            }
            i10++;
        }
        if (i10 >= 0) {
            return (z10 ? this.f8112z : this.f8111y).get(i10);
        }
        return null;
    }

    public String w() {
        return this.f8092a;
    }

    public g x() {
        return this.K;
    }

    public o y() {
        return null;
    }
}
