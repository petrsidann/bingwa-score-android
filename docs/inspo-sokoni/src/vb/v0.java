package vb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xb.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static v0 f17539d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<u0> f17541a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, u0> f17542b = new LinkedHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17538c = Logger.getLogger(v0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Iterable<Class<?>> f17540e = c();

    public static final class a implements k1.b<u0> {
        @Override // vb.k1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(u0 u0Var) {
            return u0Var.c();
        }

        @Override // vb.k1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(u0 u0Var) {
            return u0Var.d();
        }
    }

    public static synchronized v0 b() {
        if (f17539d == null) {
            List<u0> listE = k1.e(u0.class, f17540e, u0.class.getClassLoader(), new a());
            f17539d = new v0();
            for (u0 u0Var : listE) {
                f17538c.fine("Service loader found " + u0Var);
                f17539d.a(u0Var);
            }
            f17539d.e();
        }
        return f17539d;
    }

    public static List<Class<?>> c() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = v1.f19025b;
            arrayList.add(v1.class);
        } catch (ClassNotFoundException e10) {
            f17538c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e10);
        }
        try {
            int i10 = ec.k.f7902b;
            arrayList.add(ec.k.class);
        } catch (ClassNotFoundException e11) {
            f17538c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(u0 u0Var) {
        j6.m.e(u0Var.d(), "isAvailable() returned false");
        this.f17541a.add(u0Var);
    }

    public synchronized u0 d(String str) {
        return this.f17542b.get(j6.m.p(str, "policy"));
    }

    public final synchronized void e() {
        this.f17542b.clear();
        for (u0 u0Var : this.f17541a) {
            String strB = u0Var.b();
            u0 u0Var2 = this.f17542b.get(strB);
            if (u0Var2 == null || u0Var2.c() < u0Var.c()) {
                this.f17542b.put(strB, u0Var);
            }
        }
    }
}
