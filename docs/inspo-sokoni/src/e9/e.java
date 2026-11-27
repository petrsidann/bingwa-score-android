package e9;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e9.d A = e9.c.f7385a;
    public static final w B = v.f7456a;
    public static final w C = v.f7457b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f7393z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Map<l9.a<?>, x<?>>> f7394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<l9.a<?>, x<?>> f7395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g9.c f7396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h9.e f7397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<y> f7398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g9.d f7399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e9.d f7400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Type, g<?>> f7401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f7404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f7405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f7406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f7408o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f7409p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f7410q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f7411r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f7412s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final t f7413t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<y> f7414u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<y> f7415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w f7416w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final w f7417x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<u> f7418y;

    public class a extends x<Number> {
        public a() {
        }

        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Double c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return Double.valueOf(aVar.c0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
                return;
            }
            double dDoubleValue = number.doubleValue();
            e.d(dDoubleValue);
            cVar.j0(dDoubleValue);
        }
    }

    public class b extends x<Number> {
        public b() {
        }

        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Float c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return Float.valueOf((float) aVar.c0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
                return;
            }
            float fFloatValue = number.floatValue();
            e.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            cVar.m0(number);
        }
    }

    public class c extends x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return Long.valueOf(aVar.e0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
            } else {
                cVar.n0(number.toString());
            }
        }
    }

    public class d extends x<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f7421a;

        public d(x xVar) {
            this.f7421a = xVar;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLong c(m9.a aVar) {
            return new AtomicLong(((Number) this.f7421a.c(aVar)).longValue());
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, AtomicLong atomicLong) {
            this.f7421a.e(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: e9.e$e, reason: collision with other inner class name */
    public class C0126e extends x<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f7422a;

        public C0126e(x xVar) {
            this.f7422a = xVar;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray c(m9.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.d();
            while (aVar.I()) {
                arrayList.add(Long.valueOf(((Number) this.f7422a.c(aVar)).longValue()));
            }
            aVar.z();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.k();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f7422a.e(cVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            cVar.z();
        }
    }

    public static class f<T> extends h9.l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x<T> f7423a = null;

        @Override // e9.x
        public T c(m9.a aVar) {
            return g().c(aVar);
        }

        @Override // e9.x
        public void e(m9.c cVar, T t10) {
            g().e(cVar, t10);
        }

        @Override // h9.l
        public x<T> f() {
            return g();
        }

        public final x<T> g() {
            x<T> xVar = this.f7423a;
            if (xVar != null) {
                return xVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public void h(x<T> xVar) {
            if (this.f7423a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f7423a = xVar;
        }
    }

    public e() {
        this(g9.d.f9059l, A, Collections.emptyMap(), false, false, false, true, false, false, false, true, t.f7448a, f7393z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), B, C, Collections.emptyList());
    }

    public e(g9.d dVar, e9.d dVar2, Map<Type, g<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, t tVar, String str, int i10, int i11, List<y> list, List<y> list2, List<y> list3, w wVar, w wVar2, List<u> list4) {
        this.f7394a = new ThreadLocal<>();
        this.f7395b = new ConcurrentHashMap();
        this.f7399f = dVar;
        this.f7400g = dVar2;
        this.f7401h = map;
        g9.c cVar = new g9.c(map, z17, list4);
        this.f7396c = cVar;
        this.f7402i = z10;
        this.f7403j = z11;
        this.f7404k = z12;
        this.f7405l = z13;
        this.f7406m = z14;
        this.f7407n = z15;
        this.f7408o = z16;
        this.f7409p = z17;
        this.f7413t = tVar;
        this.f7410q = str;
        this.f7411r = i10;
        this.f7412s = i11;
        this.f7414u = list;
        this.f7415v = list2;
        this.f7416w = wVar;
        this.f7417x = wVar2;
        this.f7418y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(h9.o.W);
        arrayList.add(h9.j.f(wVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(h9.o.C);
        arrayList.add(h9.o.f9894m);
        arrayList.add(h9.o.f9888g);
        arrayList.add(h9.o.f9890i);
        arrayList.add(h9.o.f9892k);
        x<Number> xVarN = n(tVar);
        arrayList.add(h9.o.b(Long.TYPE, Long.class, xVarN));
        arrayList.add(h9.o.b(Double.TYPE, Double.class, e(z16)));
        arrayList.add(h9.o.b(Float.TYPE, Float.class, f(z16)));
        arrayList.add(h9.i.f(wVar2));
        arrayList.add(h9.o.f9896o);
        arrayList.add(h9.o.f9898q);
        arrayList.add(h9.o.a(AtomicLong.class, b(xVarN)));
        arrayList.add(h9.o.a(AtomicLongArray.class, c(xVarN)));
        arrayList.add(h9.o.f9900s);
        arrayList.add(h9.o.f9905x);
        arrayList.add(h9.o.E);
        arrayList.add(h9.o.G);
        arrayList.add(h9.o.a(BigDecimal.class, h9.o.f9907z));
        arrayList.add(h9.o.a(BigInteger.class, h9.o.A));
        arrayList.add(h9.o.a(g9.g.class, h9.o.B));
        arrayList.add(h9.o.I);
        arrayList.add(h9.o.K);
        arrayList.add(h9.o.O);
        arrayList.add(h9.o.Q);
        arrayList.add(h9.o.U);
        arrayList.add(h9.o.M);
        arrayList.add(h9.o.f9885d);
        arrayList.add(h9.c.f9806b);
        arrayList.add(h9.o.S);
        if (k9.d.f11898a) {
            arrayList.add(k9.d.f11902e);
            arrayList.add(k9.d.f11901d);
            arrayList.add(k9.d.f11903f);
        }
        arrayList.add(h9.a.f9800c);
        arrayList.add(h9.o.f9883b);
        arrayList.add(new h9.b(cVar));
        arrayList.add(new h9.h(cVar, z11));
        h9.e eVar = new h9.e(cVar);
        this.f7397d = eVar;
        arrayList.add(eVar);
        arrayList.add(h9.o.X);
        arrayList.add(new h9.k(cVar, dVar2, dVar, eVar, list4));
        this.f7398e = Collections.unmodifiableList(arrayList);
    }

    public static void a(Object obj, m9.a aVar) {
        if (obj != null) {
            try {
                if (aVar.l0() == m9.b.END_DOCUMENT) {
                } else {
                    throw new s("JSON document was not fully consumed.");
                }
            } catch (m9.d e10) {
                throw new s(e10);
            } catch (IOException e11) {
                throw new l(e11);
            }
        }
    }

    public static x<AtomicLong> b(x<Number> xVar) {
        return new d(xVar).b();
    }

    public static x<AtomicLongArray> c(x<Number> xVar) {
        return new C0126e(xVar).b();
    }

    public static void d(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static x<Number> n(t tVar) {
        return tVar == t.f7448a ? h9.o.f9901t : new c();
    }

    public final x<Number> e(boolean z10) {
        return z10 ? h9.o.f9903v : new a();
    }

    public final x<Number> f(boolean z10) {
        return z10 ? h9.o.f9902u : new b();
    }

    public <T> T g(Reader reader, l9.a<T> aVar) {
        m9.a aVarO = o(reader);
        T t10 = (T) j(aVarO, aVar);
        a(t10, aVarO);
        return t10;
    }

    public <T> T h(String str, Type type) {
        return (T) i(str, l9.a.b(type));
    }

    public <T> T i(String str, l9.a<T> aVar) {
        if (str == null) {
            return null;
        }
        return (T) g(new StringReader(str), aVar);
    }

    public <T> T j(m9.a aVar, l9.a<T> aVar2) {
        boolean zJ = aVar.J();
        boolean z10 = true;
        aVar.q0(true);
        try {
            try {
                try {
                    aVar.l0();
                    z10 = false;
                    T tC = l(aVar2).c(aVar);
                    aVar.q0(zJ);
                    return tC;
                } catch (EOFException e10) {
                    if (!z10) {
                        throw new s(e10);
                    }
                    aVar.q0(zJ);
                    return null;
                } catch (AssertionError e11) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
                }
            } catch (IOException e12) {
                throw new s(e12);
            } catch (IllegalStateException e13) {
                throw new s(e13);
            }
        } catch (Throwable th) {
            aVar.q0(zJ);
            throw th;
        }
    }

    public <T> x<T> k(Class<T> cls) {
        return l(l9.a.a(cls));
    }

    public <T> x<T> l(l9.a<T> aVar) {
        boolean z10;
        Objects.requireNonNull(aVar, "type must not be null");
        x<T> xVar = (x) this.f7395b.get(aVar);
        if (xVar != null) {
            return xVar;
        }
        Map<? extends l9.a<?>, ? extends x<?>> map = this.f7394a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f7394a.set((Map<l9.a<?>, x<?>>) map);
            z10 = true;
        } else {
            x<T> xVar2 = (x) map.get(aVar);
            if (xVar2 != null) {
                return xVar2;
            }
            z10 = false;
        }
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator<y> it = this.f7398e.iterator();
            x<T> xVarCreate = null;
            while (it.hasNext()) {
                xVarCreate = it.next().create(this, aVar);
                if (xVarCreate != null) {
                    fVar.h(xVarCreate);
                    map.put(aVar, xVarCreate);
                    break;
                }
            }
            if (z10) {
                this.f7394a.remove();
            }
            if (xVarCreate != null) {
                if (z10) {
                    this.f7395b.putAll(map);
                }
                return xVarCreate;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } catch (Throwable th) {
            if (z10) {
                this.f7394a.remove();
            }
            throw th;
        }
    }

    public <T> x<T> m(y yVar, l9.a<T> aVar) {
        if (!this.f7398e.contains(yVar)) {
            yVar = this.f7397d;
        }
        boolean z10 = false;
        for (y yVar2 : this.f7398e) {
            if (z10) {
                x<T> xVarCreate = yVar2.create(this, aVar);
                if (xVarCreate != null) {
                    return xVarCreate;
                }
            } else if (yVar2 == yVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public m9.a o(Reader reader) {
        m9.a aVar = new m9.a(reader);
        aVar.q0(this.f7407n);
        return aVar;
    }

    public m9.c p(Writer writer) throws IOException {
        if (this.f7404k) {
            writer.write(")]}'\n");
        }
        m9.c cVar = new m9.c(writer);
        if (this.f7406m) {
            cVar.f0("  ");
        }
        cVar.e0(this.f7405l);
        cVar.g0(this.f7407n);
        cVar.h0(this.f7402i);
        return cVar;
    }

    public String q(k kVar) {
        StringWriter stringWriter = new StringWriter();
        t(kVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        return obj == null ? q(m.f7445a) : s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        v(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(k kVar, Appendable appendable) {
        try {
            u(kVar, p(g9.m.c(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f7402i + ",factories:" + this.f7398e + ",instanceCreators:" + this.f7396c + "}";
    }

    public void u(k kVar, m9.c cVar) {
        boolean zE = cVar.E();
        cVar.g0(true);
        boolean zD = cVar.D();
        cVar.e0(this.f7405l);
        boolean zC = cVar.C();
        cVar.h0(this.f7402i);
        try {
            try {
                g9.m.b(kVar, cVar);
                cVar.g0(zE);
                cVar.e0(zD);
                cVar.h0(zC);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } catch (Throwable th) {
            cVar.g0(zE);
            cVar.e0(zD);
            cVar.h0(zC);
            throw th;
        }
    }

    public void v(Object obj, Type type, Appendable appendable) {
        try {
            w(obj, type, p(g9.m.c(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public void w(Object obj, Type type, m9.c cVar) {
        x xVarL = l(l9.a.b(type));
        boolean zE = cVar.E();
        cVar.g0(true);
        boolean zD = cVar.D();
        cVar.e0(this.f7405l);
        boolean zC = cVar.C();
        cVar.h0(this.f7402i);
        try {
            try {
                xVarL.e(cVar, obj);
                cVar.g0(zE);
                cVar.e0(zD);
                cVar.h0(zC);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } catch (Throwable th) {
            cVar.g0(zE);
            cVar.e0(zD);
            cVar.h0(zC);
            throw th;
        }
    }
}
