package i1;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10454f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f10455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f10456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f10457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10459e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final x0 a(ViewGroup container, h0 fragmentManager) {
            kotlin.jvm.internal.k.e(container, "container");
            kotlin.jvm.internal.k.e(fragmentManager, "fragmentManager");
            y0 y0VarA0 = fragmentManager.A0();
            kotlin.jvm.internal.k.d(y0VarA0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, y0VarA0);
        }

        public final x0 b(ViewGroup container, y0 factory) {
            kotlin.jvm.internal.k.e(container, "container");
            kotlin.jvm.internal.k.e(factory, "factory");
            int i10 = h1.b.f9583b;
            Object tag = container.getTag(i10);
            if (tag instanceof x0) {
                return (x0) tag;
            }
            x0 x0VarA = factory.a(container);
            kotlin.jvm.internal.k.d(x0VarA, "factory.createController(container)");
            container.setTag(i10, x0VarA);
            return x0VarA;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f10460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10462c;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            if (!this.f10462c) {
                c(container);
            }
            this.f10462c = true;
        }

        public boolean b() {
            return this.f10460a;
        }

        public void c(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
        }

        public void d(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
        }

        public void e(d.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.k.e(backEvent, "backEvent");
            kotlin.jvm.internal.k.e(container, "container");
        }

        public void f(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
        }

        public final void g(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            if (!this.f10461b) {
                f(container);
            }
            this.f10461b = true;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final n0 f10463l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b finalState, d.a lifecycleImpact, n0 fragmentStateManager) {
            kotlin.jvm.internal.k.e(finalState, "finalState");
            kotlin.jvm.internal.k.e(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.k.e(fragmentStateManager, "fragmentStateManager");
            p pVarK = fragmentStateManager.k();
            kotlin.jvm.internal.k.d(pVarK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, pVarK);
            this.f10463l = fragmentStateManager;
        }

        @Override // i1.x0.d
        public void e() {
            super.e();
            i().f10339s = false;
            this.f10463l.m();
        }

        @Override // i1.x0.d
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != d.a.ADDING) {
                if (j() == d.a.REMOVING) {
                    p pVarK = this.f10463l.k();
                    kotlin.jvm.internal.k.d(pVarK, "fragmentStateManager.fragment");
                    View viewR1 = pVarK.r1();
                    kotlin.jvm.internal.k.d(viewR1, "fragment.requireView()");
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewR1.findFocus() + " on view " + viewR1 + " for Fragment " + pVarK);
                    }
                    viewR1.clearFocus();
                    return;
                }
                return;
            }
            p pVarK2 = this.f10463l.k();
            kotlin.jvm.internal.k.d(pVarK2, "fragmentStateManager.fragment");
            View viewFindFocus = pVarK2.O.findFocus();
            if (viewFindFocus != null) {
                pVarK2.x1(viewFindFocus);
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + pVarK2);
                }
            }
            View viewR2 = i().r1();
            kotlin.jvm.internal.k.d(viewR2, "this.fragment.requireView()");
            if (viewR2.getParent() == null) {
                this.f10463l.b();
                viewR2.setAlpha(0.0f);
            }
            if ((viewR2.getAlpha() == 0.0f) && viewR2.getVisibility() == 0) {
                viewR2.setVisibility(4);
            }
            viewR2.setAlpha(pVarK2.L());
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f10464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f10465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f10466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Runnable> f10467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f10470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f10471h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f10472i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<b> f10473j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List<b> f10474k;

        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f10479a = new a(null);

            public static final class a {
                public a() {
                }

                public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                    this();
                }

                public final b a(View view) {
                    kotlin.jvm.internal.k.e(view, "<this>");
                    return (((view.getAlpha() > 0.0f ? 1 : (view.getAlpha() == 0.0f ? 0 : -1)) == 0) && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i10) {
                    if (i10 == 0) {
                        return b.VISIBLE;
                    }
                    if (i10 == 4) {
                        return b.INVISIBLE;
                    }
                    if (i10 == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i10);
                }
            }

            /* JADX INFO: renamed from: i1.x0$d$b$b, reason: collision with other inner class name */
            public /* synthetic */ class C0171b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10485a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f10485a = iArr;
                }
            }

            public static final b i(int i10) {
                return f10479a.b(i10);
            }

            public final void h(View view, ViewGroup container) {
                int i10;
                kotlin.jvm.internal.k.e(view, "view");
                kotlin.jvm.internal.k.e(container, "container");
                int i11 = C0171b.f10485a[ordinal()];
                if (i11 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i11 == 2) {
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    i10 = 0;
                } else if (i11 != 3) {
                    i10 = 4;
                    if (i11 != 4) {
                        return;
                    }
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                } else {
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i10 = 8;
                }
                view.setVisibility(i10);
            }
        }

        public /* synthetic */ class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10486a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f10486a = iArr;
            }
        }

        public d(b finalState, a lifecycleImpact, p fragment) {
            kotlin.jvm.internal.k.e(finalState, "finalState");
            kotlin.jvm.internal.k.e(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.k.e(fragment, "fragment");
            this.f10464a = finalState;
            this.f10465b = lifecycleImpact;
            this.f10466c = fragment;
            this.f10467d = new ArrayList();
            this.f10472i = true;
            ArrayList arrayList = new ArrayList();
            this.f10473j = arrayList;
            this.f10474k = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.f10467d.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.k.e(effect, "effect");
            this.f10473j.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            this.f10471h = false;
            if (this.f10468e) {
                return;
            }
            this.f10468e = true;
            if (this.f10473j.isEmpty()) {
                e();
                return;
            }
            Iterator it = mc.w.L(this.f10474k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z10) {
            kotlin.jvm.internal.k.e(container, "container");
            if (this.f10468e) {
                return;
            }
            if (z10) {
                this.f10470g = true;
            }
            c(container);
        }

        public void e() {
            this.f10471h = false;
            if (this.f10469f) {
                return;
            }
            if (h0.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f10469f = true;
            Iterator<T> it = this.f10467d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            kotlin.jvm.internal.k.e(effect, "effect");
            if (this.f10473j.remove(effect) && this.f10473j.isEmpty()) {
                e();
            }
        }

        public final List<b> g() {
            return this.f10474k;
        }

        public final b h() {
            return this.f10464a;
        }

        public final p i() {
            return this.f10466c;
        }

        public final a j() {
            return this.f10465b;
        }

        public final boolean k() {
            return this.f10472i;
        }

        public final boolean l() {
            return this.f10468e;
        }

        public final boolean m() {
            return this.f10469f;
        }

        public final boolean n() {
            return this.f10470g;
        }

        public final boolean o() {
            return this.f10471h;
        }

        public final void p(b finalState, a lifecycleImpact) {
            a aVar;
            kotlin.jvm.internal.k.e(finalState, "finalState");
            kotlin.jvm.internal.k.e(lifecycleImpact, "lifecycleImpact");
            int i10 = c.f10486a[lifecycleImpact.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && this.f10464a != b.REMOVED) {
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10466c + " mFinalState = " + this.f10464a + " -> " + finalState + '.');
                        }
                        this.f10464a = finalState;
                        return;
                    }
                    return;
                }
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10466c + " mFinalState = " + this.f10464a + " -> REMOVED. mLifecycleImpact  = " + this.f10465b + " to REMOVING.");
                }
                this.f10464a = b.REMOVED;
                aVar = a.REMOVING;
            } else {
                if (this.f10464a != b.REMOVED) {
                    return;
                }
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10466c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f10465b + " to ADDING.");
                }
                this.f10464a = b.VISIBLE;
                aVar = a.ADDING;
            }
            this.f10465b = aVar;
            this.f10472i = true;
        }

        public void q() {
            this.f10471h = true;
        }

        public final void r(boolean z10) {
            this.f10472i = z10;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f10464a + " lifecycleImpact = " + this.f10465b + " fragment = " + this.f10466c + '}';
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10487a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f10487a = iArr;
        }
    }

    public x0(ViewGroup container) {
        kotlin.jvm.internal.k.e(container, "container");
        this.f10455a = container;
        this.f10456b = new ArrayList();
        this.f10457c = new ArrayList();
    }

    public static final void h(x0 this$0, c operation) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(operation, "$operation");
        if (this$0.f10456b.contains(operation)) {
            d.b bVarH = operation.h();
            View view = operation.i().O;
            kotlin.jvm.internal.k.d(view, "operation.fragment.mView");
            bVarH.h(view, this$0.f10455a);
        }
    }

    public static final void i(x0 this$0, c operation) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(operation, "$operation");
        this$0.f10456b.remove(operation);
        this$0.f10457c.remove(operation);
    }

    public static final x0 u(ViewGroup viewGroup, h0 h0Var) {
        return f10454f.a(viewGroup, h0Var);
    }

    public static final x0 v(ViewGroup viewGroup, y0 y0Var) {
        return f10454f.b(viewGroup, y0Var);
    }

    public final void A() {
        for (d dVar : this.f10456b) {
            if (dVar.j() == d.a.ADDING) {
                View viewR1 = dVar.i().r1();
                kotlin.jvm.internal.k.d(viewR1, "fragment.requireView()");
                dVar.p(d.b.f10479a.b(viewR1.getVisibility()), d.a.NONE);
            }
        }
    }

    public final void B(boolean z10) {
        this.f10458d = z10;
    }

    public final void c(d operation) {
        kotlin.jvm.internal.k.e(operation, "operation");
        if (operation.k()) {
            d.b bVarH = operation.h();
            View viewR1 = operation.i().r1();
            kotlin.jvm.internal.k.d(viewR1, "operation.fragment.requireView()");
            bVarH.h(viewR1, this.f10455a);
            operation.r(false);
        }
    }

    public abstract void d(List<d> list, boolean z10);

    public void e(List<d> operations) {
        kotlin.jvm.internal.k.e(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            mc.t.o(arrayList, ((d) it.next()).g());
        }
        List listL = mc.w.L(mc.w.P(arrayList));
        int size = listL.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listL.get(i10)).d(this.f10455a);
        }
        int size2 = operations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            c(operations.get(i11));
        }
        List listL2 = mc.w.L(operations);
        int size3 = listL2.size();
        for (int i12 = 0; i12 < size3; i12++) {
            d dVar = (d) listL2.get(i12);
            if (dVar.g().isEmpty()) {
                dVar.e();
            }
        }
    }

    public final void f() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f10457c);
        e(this.f10457c);
    }

    public final void g(d.b bVar, d.a aVar, n0 n0Var) {
        synchronized (this.f10456b) {
            p pVarK = n0Var.k();
            kotlin.jvm.internal.k.d(pVarK, "fragmentStateManager.fragment");
            d dVarO = o(pVarK);
            if (dVarO == null) {
                if (n0Var.k().f10339s) {
                    p pVarK2 = n0Var.k();
                    kotlin.jvm.internal.k.d(pVarK2, "fragmentStateManager.fragment");
                    dVarO = p(pVarK2);
                } else {
                    dVarO = null;
                }
            }
            if (dVarO != null) {
                dVarO.p(bVar, aVar);
                return;
            }
            final c cVar = new c(bVar, aVar, n0Var);
            this.f10456b.add(cVar);
            cVar.a(new Runnable() { // from class: i1.v0
                @Override // java.lang.Runnable
                public final void run() {
                    x0.h(this.f10449a, cVar);
                }
            });
            cVar.a(new Runnable() { // from class: i1.w0
                @Override // java.lang.Runnable
                public final void run() {
                    x0.i(this.f10451a, cVar);
                }
            });
            lc.q qVar = lc.q.f12711a;
        }
    }

    public final void j(d.b finalState, n0 fragmentStateManager) {
        kotlin.jvm.internal.k.e(finalState, "finalState");
        kotlin.jvm.internal.k.e(fragmentStateManager, "fragmentStateManager");
        if (h0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, d.a.ADDING, fragmentStateManager);
    }

    public final void k(n0 fragmentStateManager) {
        kotlin.jvm.internal.k.e(fragmentStateManager, "fragmentStateManager");
        if (h0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.GONE, d.a.NONE, fragmentStateManager);
    }

    public final void l(n0 fragmentStateManager) {
        kotlin.jvm.internal.k.e(fragmentStateManager, "fragmentStateManager");
        if (h0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, fragmentStateManager);
    }

    public final void m(n0 fragmentStateManager) {
        kotlin.jvm.internal.k.e(fragmentStateManager, "fragmentStateManager");
        if (h0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.VISIBLE, d.a.NONE, fragmentStateManager);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x014a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0185  */
    public final void n() {
        boolean z10;
        boolean z11;
        if (this.f10459e) {
            return;
        }
        if (!this.f10455a.isAttachedToWindow()) {
            q();
            this.f10458d = false;
            return;
        }
        synchronized (this.f10456b) {
            if (this.f10456b.isEmpty()) {
                List<d> listO = mc.w.O(this.f10457c);
                this.f10457c.clear();
                for (d dVar : listO) {
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dVar + " with no incoming pendingOperations");
                    }
                    dVar.d(this.f10455a, false);
                    if (!dVar.m()) {
                        this.f10457c.add(dVar);
                    }
                }
            } else {
                List<d> listO2 = mc.w.O(this.f10457c);
                this.f10457c.clear();
                for (d dVar2 : listO2) {
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dVar2);
                    }
                    dVar2.d(this.f10455a, dVar2.i().f10339s);
                    if (!dVar2.m()) {
                        this.f10457c.add(dVar2);
                    }
                }
                A();
                List<d> listO3 = mc.w.O(this.f10456b);
                if (listO3.isEmpty()) {
                    return;
                }
                this.f10456b.clear();
                this.f10457c.addAll(listO3);
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                d(listO3, this.f10458d);
                kotlin.jvm.internal.s sVar = new kotlin.jvm.internal.s();
                boolean z12 = true;
                sVar.f12380a = true;
                boolean z13 = true;
                for (d dVar3 : listO3) {
                    if (!dVar3.g().isEmpty()) {
                        List<b> listG = dVar3.g();
                        if (!(listG instanceof Collection) || !listG.isEmpty()) {
                            Iterator<T> it = listG.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!((b) it.next()).b()) {
                                        z11 = false;
                                        break;
                                    }
                                } else {
                                    z11 = true;
                                    break;
                                }
                            }
                        } else {
                            z11 = true;
                            break;
                        }
                        if (z11) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } else {
                        z10 = false;
                    }
                    sVar.f12380a = z10;
                    if (!dVar3.i().f10339s) {
                        z13 = false;
                    }
                }
                if (sVar.f12380a) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it2 = listO3.iterator();
                    while (it2.hasNext()) {
                        mc.t.o(arrayList, ((d) it2.next()).g());
                    }
                    if (!(!arrayList.isEmpty())) {
                        z12 = false;
                    }
                } else {
                    z12 = false;
                }
                sVar.f12380a = z12;
                if (!z13) {
                    z(listO3);
                    e(listO3);
                } else if (z12) {
                    z(listO3);
                    int size = listO3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        c(listO3.get(i10));
                    }
                }
                this.f10458d = false;
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
            lc.q qVar = lc.q.f12711a;
        }
    }

    public final d o(p pVar) {
        Object next;
        Iterator<T> it = this.f10456b.iterator();
        while (it.hasNext()) {
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.k.a(dVar.i(), pVar) && !dVar.l()) {
                return (d) next;
            }
        }
        next = null;
        return (d) next;
    }

    public final d p(p pVar) {
        Object next;
        Iterator<T> it = this.f10457c.iterator();
        while (it.hasNext()) {
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.k.a(dVar.i(), pVar) && !dVar.l()) {
                return (d) next;
            }
        }
        next = null;
        return (d) next;
    }

    public final void q() {
        if (h0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f10455a.isAttachedToWindow();
        synchronized (this.f10456b) {
            A();
            z(this.f10456b);
            for (d dVar : mc.w.O(this.f10457c)) {
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f10455a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                }
                dVar.c(this.f10455a);
            }
            for (d dVar2 : mc.w.O(this.f10456b)) {
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f10455a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                }
                dVar2.c(this.f10455a);
            }
            lc.q qVar = lc.q.f12711a;
        }
    }

    public final void r() {
        if (this.f10459e) {
            if (h0.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f10459e = false;
            n();
        }
    }

    public final d.a s(n0 fragmentStateManager) {
        kotlin.jvm.internal.k.e(fragmentStateManager, "fragmentStateManager");
        p pVarK = fragmentStateManager.k();
        kotlin.jvm.internal.k.d(pVarK, "fragmentStateManager.fragment");
        d dVarO = o(pVarK);
        d.a aVarJ = dVarO != null ? dVarO.j() : null;
        d dVarP = p(pVarK);
        d.a aVarJ2 = dVarP != null ? dVarP.j() : null;
        int i10 = aVarJ == null ? -1 : e.f10487a[aVarJ.ordinal()];
        return (i10 == -1 || i10 == 1) ? aVarJ2 : aVarJ;
    }

    public final ViewGroup t() {
        return this.f10455a;
    }

    public final boolean w() {
        return !this.f10456b.isEmpty();
    }

    public final void x() {
        d dVarPrevious;
        d.b bVarA;
        d.b bVarH;
        d.b bVar;
        synchronized (this.f10456b) {
            A();
            List<d> list = this.f10456b;
            ListIterator<d> listIterator = list.listIterator(list.size());
            do {
                if (!listIterator.hasPrevious()) {
                    dVarPrevious = null;
                    break;
                }
                dVarPrevious = listIterator.previous();
                d dVar = dVarPrevious;
                d.b.a aVar = d.b.f10479a;
                View view = dVar.i().O;
                kotlin.jvm.internal.k.d(view, "operation.fragment.mView");
                bVarA = aVar.a(view);
                bVarH = dVar.h();
                bVar = d.b.VISIBLE;
            } while (!(bVarH == bVar && bVarA != bVar));
            d dVar2 = dVarPrevious;
            p pVarI = dVar2 != null ? dVar2.i() : null;
            this.f10459e = pVarI != null ? pVarI.e0() : false;
            lc.q qVar = lc.q.f12711a;
        }
    }

    public final void y(d.b backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        if (h0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
        }
        List<d> list = this.f10457c;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            mc.t.o(arrayList, ((d) it.next()).g());
        }
        List listL = mc.w.L(mc.w.P(arrayList));
        int size = listL.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listL.get(i10)).e(backEvent, this.f10455a);
        }
    }

    public final void z(List<d> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).q();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            mc.t.o(arrayList, ((d) it.next()).g());
        }
        List listL = mc.w.L(mc.w.P(arrayList));
        int size2 = listL.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((b) listL.get(i11)).g(this.f10455a);
        }
    }
}
