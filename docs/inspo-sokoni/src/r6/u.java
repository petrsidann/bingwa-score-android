package r6;

import e7.c0;
import e7.i0;
import e7.z;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class u<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<d, List<c<P>>> f15050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<P> f15051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<P> f15052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f15053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15054e;

    public static class b<P> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<P> f15055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConcurrentMap<d, List<c<P>>> f15056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<P> f15057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c7.a f15058d;

        public b(Class<P> cls) {
            this.f15056b = new ConcurrentHashMap();
            this.f15055a = cls;
            this.f15058d = c7.a.f3409b;
        }

        public b<P> a(P p10, c0.c cVar) {
            return c(p10, cVar, true);
        }

        public b<P> b(P p10, c0.c cVar) {
            return c(p10, cVar, false);
        }

        public final b<P> c(P p10, c0.c cVar, boolean z10) throws GeneralSecurityException {
            if (this.f15056b == null) {
                throw new IllegalStateException("addPrimitive cannot be called after build");
            }
            if (cVar.U() != z.ENABLED) {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
            c<P> cVarB = u.b(p10, cVar, this.f15056b);
            if (z10) {
                if (this.f15057c != null) {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                this.f15057c = cVarB;
            }
            return this;
        }

        public u<P> d() {
            ConcurrentMap<d, List<c<P>>> concurrentMap = this.f15056b;
            if (concurrentMap == null) {
                throw new IllegalStateException("build cannot be called twice");
            }
            u<P> uVar = new u<>(concurrentMap, this.f15057c, this.f15058d, this.f15055a);
            this.f15056b = null;
            return uVar;
        }

        public b<P> e(c7.a aVar) {
            if (this.f15056b == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build");
            }
            this.f15058d = aVar;
            return this;
        }
    }

    public static final class c<P> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P f15059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f15060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z f15061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i0 f15062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f15063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final f f15064f;

        public c(P p10, byte[] bArr, z zVar, i0 i0Var, int i10, f fVar) {
            this.f15059a = p10;
            this.f15060b = Arrays.copyOf(bArr, bArr.length);
            this.f15061c = zVar;
            this.f15062d = i0Var;
            this.f15063e = i10;
            this.f15064f = fVar;
        }

        public final byte[] a() {
            byte[] bArr = this.f15060b;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public f b() {
            return this.f15064f;
        }

        public int c() {
            return this.f15063e;
        }

        public i0 d() {
            return this.f15062d;
        }

        public t e() {
            return this.f15064f.a();
        }

        public P f() {
            return this.f15059a;
        }

        public z g() {
            return this.f15061c;
        }
    }

    public static class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f15065a;

        public d(byte[] bArr) {
            this.f15065a = Arrays.copyOf(bArr, bArr.length);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            byte[] bArr = this.f15065a;
            int length = bArr.length;
            byte[] bArr2 = dVar.f15065a;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i10 = 0;
            while (true) {
                byte[] bArr3 = this.f15065a;
                if (i10 >= bArr3.length) {
                    return 0;
                }
                byte b10 = bArr3[i10];
                byte b11 = dVar.f15065a[i10];
                if (b10 != b11) {
                    return b10 - b11;
                }
                i10++;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return Arrays.equals(this.f15065a, ((d) obj).f15065a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f15065a);
        }

        public String toString() {
            return f7.k.b(this.f15065a);
        }
    }

    public u(ConcurrentMap<d, List<c<P>>> concurrentMap, c<P> cVar, c7.a aVar, Class<P> cls) {
        this.f15050a = concurrentMap;
        this.f15051b = cVar;
        this.f15052c = cls;
        this.f15053d = aVar;
        this.f15054e = false;
    }

    public static <P> c<P> b(P p10, c0.c cVar, ConcurrentMap<d, List<c<P>>> concurrentMap) {
        Integer numValueOf = Integer.valueOf(cVar.S());
        if (cVar.T() == i0.RAW) {
            numValueOf = null;
        }
        c<P> cVar2 = new c<>(p10, r6.c.a(cVar), cVar.U(), cVar.T(), cVar.S(), z6.h.a().c(z6.l.b(cVar.R().S(), cVar.R().T(), cVar.R().R(), cVar.T(), numValueOf), e.a()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar2);
        d dVar = new d(cVar2.a());
        List<c<P>> listPut = concurrentMap.put(dVar, Collections.unmodifiableList(arrayList));
        if (listPut != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(listPut);
            arrayList2.add(cVar2);
            concurrentMap.put(dVar, Collections.unmodifiableList(arrayList2));
        }
        return cVar2;
    }

    public static <P> b<P> j(Class<P> cls) {
        return new b<>(cls);
    }

    public Collection<List<c<P>>> c() {
        return this.f15050a.values();
    }

    public c7.a d() {
        return this.f15053d;
    }

    public c<P> e() {
        return this.f15051b;
    }

    public List<c<P>> f(byte[] bArr) {
        List<c<P>> list = this.f15050a.get(new d(bArr));
        return list != null ? list : Collections.emptyList();
    }

    public Class<P> g() {
        return this.f15052c;
    }

    public List<c<P>> h() {
        return f(r6.c.f15026a);
    }

    public boolean i() {
        return !this.f15053d.b().isEmpty();
    }
}
