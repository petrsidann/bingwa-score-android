package f2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f8123a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<t.a<ViewGroup, ArrayList<l>>>> f8124b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList<ViewGroup> f8125c = new ArrayList<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f8126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f8127b;

        /* JADX INFO: renamed from: f2.n$a$a, reason: collision with other inner class name */
        public class C0136a extends m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t.a f8128a;

            public C0136a(t.a aVar) {
                this.f8128a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f2.l.f
            public void c(l lVar) {
                ((ArrayList) this.f8128a.get(a.this.f8127b)).remove(lVar);
                lVar.U(this);
            }
        }

        public a(l lVar, ViewGroup viewGroup) {
            this.f8126a = lVar;
            this.f8127b = viewGroup;
        }

        public final void a() {
            this.f8127b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f8127b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!n.f8125c.remove(this.f8127b)) {
                return true;
            }
            t.a<ViewGroup, ArrayList<l>> aVarB = n.b();
            ArrayList<l> arrayList = aVarB.get(this.f8127b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarB.put(this.f8127b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f8126a);
            this.f8126a.a(new C0136a(aVarB));
            this.f8126a.m(this.f8127b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).W(this.f8127b);
                }
            }
            this.f8126a.T(this.f8127b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n.f8125c.remove(this.f8127b);
            ArrayList<l> arrayList = n.b().get(this.f8127b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().W(this.f8127b);
                }
            }
            this.f8126a.n(true);
        }
    }

    public static void a(ViewGroup viewGroup, l lVar) {
        if (f8125c.contains(viewGroup) || !p0.p0.T(viewGroup)) {
            return;
        }
        f8125c.add(viewGroup);
        if (lVar == null) {
            lVar = f8123a;
        }
        l lVarClone = lVar.clone();
        d(viewGroup, lVarClone);
        k.c(viewGroup, null);
        c(viewGroup, lVarClone);
    }

    public static t.a<ViewGroup, ArrayList<l>> b() {
        t.a<ViewGroup, ArrayList<l>> aVar;
        WeakReference<t.a<ViewGroup, ArrayList<l>>> weakReference = f8124b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        t.a<ViewGroup, ArrayList<l>> aVar2 = new t.a<>();
        f8124b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void c(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, l lVar) {
        ArrayList<l> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<l> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().S(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.m(viewGroup, true);
        }
        k kVarB = k.b(viewGroup);
        if (kVarB != null) {
            kVarB.a();
        }
    }
}
