package i1;

import android.view.View;
import e0.m1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f10405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0 f10406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s0 f10407c;

    static {
        q0 q0Var = new q0();
        f10405a = q0Var;
        f10406b = new r0();
        f10407c = q0Var.c();
    }

    public static final void a(p inFragment, p outFragment, boolean z10, t.a<String, View> sharedElements, boolean z11) {
        kotlin.jvm.internal.k.e(inFragment, "inFragment");
        kotlin.jvm.internal.k.e(outFragment, "outFragment");
        kotlin.jvm.internal.k.e(sharedElements, "sharedElements");
        m1 m1VarX = z10 ? outFragment.x() : inFragment.x();
        if (m1VarX != null) {
            ArrayList arrayList = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it = sharedElements.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            ArrayList arrayList2 = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it2 = sharedElements.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getKey());
            }
            if (z11) {
                m1VarX.c(arrayList2, arrayList, null);
            } else {
                m1VarX.b(arrayList2, arrayList, null);
            }
        }
    }

    public static final String b(t.a<String, String> aVar, String value) {
        kotlin.jvm.internal.k.e(aVar, "<this>");
        kotlin.jvm.internal.k.e(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : aVar.entrySet()) {
            if (kotlin.jvm.internal.k.a(entry.getValue(), value)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        return (String) mc.w.v(arrayList);
    }

    public static final void d(t.a<String, String> aVar, t.a<String, View> namedViews) {
        kotlin.jvm.internal.k.e(aVar, "<this>");
        kotlin.jvm.internal.k.e(namedViews, "namedViews");
        int size = aVar.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!namedViews.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    public static final void e(List<? extends View> views, int i10) {
        kotlin.jvm.internal.k.e(views, "views");
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i10);
        }
    }

    public final s0 c() {
        try {
            kotlin.jvm.internal.k.c(f2.e.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (s0) f2.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
