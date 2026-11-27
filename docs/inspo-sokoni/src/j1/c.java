package j1;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import i1.p;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import mc.e0;
import mc.h0;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11138a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0182c f11139b = C0182c.f11151d;

    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface b {
    }

    /* JADX INFO: renamed from: j1.c$c, reason: collision with other inner class name */
    public static final class C0182c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f11150c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0182c f11151d = new C0182c(h0.b(), null, e0.d());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<a> f11152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Set<Class<? extends g>>> f11153b;

        /* JADX INFO: renamed from: j1.c$c$a */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0182c(Set<? extends a> flags, b bVar, Map<String, ? extends Set<Class<? extends g>>> allowedViolations) {
            k.e(flags, "flags");
            k.e(allowedViolations, "allowedViolations");
            this.f11152a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends g>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f11153b = linkedHashMap;
        }

        public final Set<a> a() {
            return this.f11152a;
        }

        public final b b() {
            return null;
        }

        public final Map<String, Set<Class<? extends g>>> c() {
            return this.f11153b;
        }
    }

    public static final void d(String str, g violation) {
        k.e(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(p fragment, String previousFragmentId) {
        k.e(fragment, "fragment");
        k.e(previousFragmentId, "previousFragmentId");
        j1.a aVar = new j1.a(fragment, previousFragmentId);
        c cVar = f11138a;
        cVar.e(aVar);
        C0182c c0182cB = cVar.b(fragment);
        if (c0182cB.a().contains(a.DETECT_FRAGMENT_REUSE) && cVar.l(c0182cB, fragment.getClass(), aVar.getClass())) {
            cVar.c(c0182cB, aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(p fragment, ViewGroup viewGroup) {
        k.e(fragment, "fragment");
        d dVar = new d(fragment, viewGroup);
        c cVar = f11138a;
        cVar.e(dVar);
        C0182c c0182cB = cVar.b(fragment);
        if (c0182cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && cVar.l(c0182cB, fragment.getClass(), dVar.getClass())) {
            cVar.c(c0182cB, dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(p fragment) {
        k.e(fragment, "fragment");
        e eVar = new e(fragment);
        c cVar = f11138a;
        cVar.e(eVar);
        C0182c c0182cB = cVar.b(fragment);
        if (c0182cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.l(c0182cB, fragment.getClass(), eVar.getClass())) {
            cVar.c(c0182cB, eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(p fragment, ViewGroup container) {
        k.e(fragment, "fragment");
        k.e(container, "container");
        h hVar = new h(fragment, container);
        c cVar = f11138a;
        cVar.e(hVar);
        C0182c c0182cB = cVar.b(fragment);
        if (c0182cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && cVar.l(c0182cB, fragment.getClass(), hVar.getClass())) {
            cVar.c(c0182cB, hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(p fragment, p expectedParentFragment, int i10) {
        k.e(fragment, "fragment");
        k.e(expectedParentFragment, "expectedParentFragment");
        i iVar = new i(fragment, expectedParentFragment, i10);
        c cVar = f11138a;
        cVar.e(iVar);
        C0182c c0182cB = cVar.b(fragment);
        if (c0182cB.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && cVar.l(c0182cB, fragment.getClass(), iVar.getClass())) {
            cVar.c(c0182cB, iVar);
        }
    }

    public final C0182c b(p pVar) {
        while (pVar != null) {
            if (pVar.a0()) {
                i1.h0 h0VarH = pVar.H();
                k.d(h0VarH, "declaringFragment.parentFragmentManager");
                if (h0VarH.B0() != null) {
                    C0182c c0182cB0 = h0VarH.B0();
                    k.b(c0182cB0);
                    return c0182cB0;
                }
            }
            pVar = pVar.G();
        }
        return f11139b;
    }

    public final void c(C0182c c0182c, final g gVar) {
        p pVarA = gVar.a();
        final String name = pVarA.getClass().getName();
        if (c0182c.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, gVar);
        }
        c0182c.b();
        if (c0182c.a().contains(a.PENALTY_DEATH)) {
            k(pVarA, new Runnable() { // from class: j1.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(name, gVar);
                }
            });
        }
    }

    public final void e(g gVar) {
        if (i1.h0.I0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + gVar.a().getClass().getName(), gVar);
        }
    }

    public final void k(p pVar, Runnable runnable) {
        if (pVar.a0()) {
            Handler handlerW = pVar.H().v0().w();
            if (!k.a(handlerW.getLooper(), Looper.myLooper())) {
                handlerW.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    public final boolean l(C0182c c0182c, Class<? extends p> cls, Class<? extends g> cls2) {
        Set<Class<? extends g>> set = c0182c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (k.a(cls2.getSuperclass(), g.class) || !w.s(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
