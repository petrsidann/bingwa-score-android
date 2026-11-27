package vb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f17341e = Logger.getLogger(e1.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static e1 f17342f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1.d f17343a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17344b = "unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<d1> f17345c = new LinkedHashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k6.r<String, d1> f17346d = k6.r.i();

    public final class b extends c1.d {
        public b() {
        }
    }

    public static final class c implements k1.b<d1> {
        public c() {
        }

        @Override // vb.k1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(d1 d1Var) {
            return d1Var.f();
        }

        @Override // vb.k1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(d1 d1Var) {
            return d1Var.e();
        }
    }

    public static synchronized e1 b() {
        if (f17342f == null) {
            List<d1> listE = k1.e(d1.class, d(), d1.class.getClassLoader(), new c());
            if (listE.isEmpty()) {
                f17341e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            f17342f = new e1();
            for (d1 d1Var : listE) {
                f17341e.fine("Service loader found " + d1Var);
                f17342f.a(d1Var);
            }
            f17342f.g();
        }
        return f17342f;
    }

    public static List<Class<?>> d() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = xb.e0.f18434a;
            arrayList.add(xb.e0.class);
        } catch (ClassNotFoundException e10) {
            f17341e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(d1 d1Var) {
        j6.m.e(d1Var.e(), "isAvailable() returned false");
        this.f17345c.add(d1Var);
    }

    public synchronized String c() {
        return this.f17344b;
    }

    public d1 e(String str) {
        if (str == null) {
            return null;
        }
        return f().get(str.toLowerCase(Locale.US));
    }

    public synchronized Map<String, d1> f() {
        return this.f17346d;
    }

    public final synchronized void g() {
        HashMap map = new HashMap();
        String strD = "unknown";
        int iF = Integer.MIN_VALUE;
        for (d1 d1Var : this.f17345c) {
            String strD2 = d1Var.d();
            d1 d1Var2 = (d1) map.get(strD2);
            if (d1Var2 == null || d1Var2.f() < d1Var.f()) {
                map.put(strD2, d1Var);
            }
            if (iF < d1Var.f()) {
                iF = d1Var.f();
                strD = d1Var.d();
            }
        }
        this.f17346d = k6.r.b(map);
        this.f17344b = strD;
    }
}
