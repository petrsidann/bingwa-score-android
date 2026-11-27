package vb;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vb.a.c<Map<String, ?>> f17504b = vb.a.c.a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.C0305b<k> f17505c = b.C0305b.b("internal:health-check-consumer-listener");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vb.a.c<Boolean> f17506d = vb.a.c.a("internal:has-health-check-producer-listener");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vb.a.c<Boolean> f17507e = vb.a.c.a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final j f17508f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17509a;

    public class a extends j {
        @Override // vb.t0.j
        public f a(g gVar) {
            return f.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<y> f17510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.a f17511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[][] f17512c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<y> f17513a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vb.a f17514b = vb.a.f17234c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object[][] f17515c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public <T> a b(C0305b<T> c0305b, T t10) {
                j6.m.p(c0305b, "key");
                j6.m.p(t10, "value");
                int length = 0;
                while (true) {
                    Object[][] objArr = this.f17515c;
                    if (length >= objArr.length) {
                        length = -1;
                        break;
                    }
                    if (c0305b.equals(objArr[length][0])) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f17515c.length + 1, 2);
                    Object[][] objArr3 = this.f17515c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f17515c = objArr2;
                    length = objArr2.length - 1;
                }
                this.f17515c[length] = new Object[]{c0305b, t10};
                return this;
            }

            public b c() {
                return new b(this.f17513a, this.f17514b, this.f17515c, null);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f17515c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List<y> list) {
                j6.m.e(!list.isEmpty(), "addrs is empty");
                this.f17513a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(vb.a aVar) {
                this.f17514b = (vb.a) j6.m.p(aVar, "attrs");
                return this;
            }
        }

        /* JADX INFO: renamed from: vb.t0$b$b, reason: collision with other inner class name */
        public static final class C0305b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f17516a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final T f17517b;

            public C0305b(String str, T t10) {
                this.f17516a = str;
                this.f17517b = t10;
            }

            public static <T> C0305b<T> b(String str) {
                j6.m.p(str, "debugString");
                return new C0305b<>(str, null);
            }

            public String toString() {
                return this.f17516a;
            }
        }

        public b(List<y> list, vb.a aVar, Object[][] objArr) {
            this.f17510a = (List) j6.m.p(list, "addresses are not set");
            this.f17511b = (vb.a) j6.m.p(aVar, "attrs");
            this.f17512c = (Object[][]) j6.m.p(objArr, "customOptions");
        }

        public /* synthetic */ b(List list, vb.a aVar, Object[][] objArr, a aVar2) {
            this(list, aVar, objArr);
        }

        public static a d() {
            return new a();
        }

        public List<y> a() {
            return this.f17510a;
        }

        public vb.a b() {
            return this.f17511b;
        }

        public <T> T c(C0305b<T> c0305b) {
            j6.m.p(c0305b, "key");
            int i10 = 0;
            while (true) {
                Object[][] objArr = this.f17512c;
                if (i10 >= objArr.length) {
                    return (T) c0305b.f17517b;
                }
                if (c0305b.equals(objArr[i10][0])) {
                    return (T) this.f17512c[i10][1];
                }
                i10++;
            }
        }

        public a e() {
            return d().e(this.f17510a).f(this.f17511b).d(this.f17512c);
        }

        public String toString() {
            return j6.g.b(this).d("addrs", this.f17510a).d("attrs", this.f17511b).d("customOptions", Arrays.deepToString(this.f17512c)).toString();
        }
    }

    public static abstract class c {
        public abstract t0 a(e eVar);
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f17518a;

        public d(f fVar) {
            this.f17518a = (f) j6.m.p(fVar, "result");
        }

        @Override // vb.t0.j
        public f a(g gVar) {
            return this.f17518a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f17518a + ")";
        }
    }

    public static abstract class e {
        public i a(b bVar) {
            throw new UnsupportedOperationException();
        }

        public vb.f b() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService c() {
            throw new UnsupportedOperationException();
        }

        public p1 d() {
            throw new UnsupportedOperationException();
        }

        public void e() {
            throw new UnsupportedOperationException();
        }

        public abstract void f(q qVar, j jVar);
    }

    public static final class f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f17519e = new f(null, null, l1.f17405e, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f17520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.k.a f17521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l1 f17522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17523d;

        public f(i iVar, vb.k.a aVar, l1 l1Var, boolean z10) {
            this.f17520a = iVar;
            this.f17521b = aVar;
            this.f17522c = (l1) j6.m.p(l1Var, "status");
            this.f17523d = z10;
        }

        public static f e(l1 l1Var) {
            j6.m.e(!l1Var.o(), "drop status shouldn't be OK");
            return new f(null, null, l1Var, true);
        }

        public static f f(l1 l1Var) {
            j6.m.e(!l1Var.o(), "error status shouldn't be OK");
            return new f(null, null, l1Var, false);
        }

        public static f g() {
            return f17519e;
        }

        public static f h(i iVar) {
            return i(iVar, null);
        }

        public static f i(i iVar, vb.k.a aVar) {
            return new f((i) j6.m.p(iVar, "subchannel"), aVar, l1.f17405e, false);
        }

        public l1 a() {
            return this.f17522c;
        }

        public vb.k.a b() {
            return this.f17521b;
        }

        public i c() {
            return this.f17520a;
        }

        public boolean d() {
            return this.f17523d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return j6.i.a(this.f17520a, fVar.f17520a) && j6.i.a(this.f17522c, fVar.f17522c) && j6.i.a(this.f17521b, fVar.f17521b) && this.f17523d == fVar.f17523d;
        }

        public int hashCode() {
            return j6.i.b(this.f17520a, this.f17522c, this.f17521b, Boolean.valueOf(this.f17523d));
        }

        public String toString() {
            return j6.g.b(this).d("subchannel", this.f17520a).d("streamTracerFactory", this.f17521b).d("status", this.f17522c).e("drop", this.f17523d).toString();
        }
    }

    public static abstract class g {
        public abstract vb.c a();

        public abstract a1 b();

        public abstract b1<?, ?> c();
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<y> f17524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.a f17525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f17526c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<y> f17527a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vb.a f17528b = vb.a.f17234c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f17529c;

            public h a() {
                return new h(this.f17527a, this.f17528b, this.f17529c, null);
            }

            public a b(List<y> list) {
                this.f17527a = list;
                return this;
            }

            public a c(vb.a aVar) {
                this.f17528b = aVar;
                return this;
            }

            public a d(Object obj) {
                this.f17529c = obj;
                return this;
            }
        }

        public h(List<y> list, vb.a aVar, Object obj) {
            this.f17524a = Collections.unmodifiableList(new ArrayList((Collection) j6.m.p(list, "addresses")));
            this.f17525b = (vb.a) j6.m.p(aVar, "attributes");
            this.f17526c = obj;
        }

        public /* synthetic */ h(List list, vb.a aVar, Object obj, a aVar2) {
            this(list, aVar, obj);
        }

        public static a d() {
            return new a();
        }

        public List<y> a() {
            return this.f17524a;
        }

        public vb.a b() {
            return this.f17525b;
        }

        public Object c() {
            return this.f17526c;
        }

        public a e() {
            return d().b(this.f17524a).c(this.f17525b).d(this.f17526c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return j6.i.a(this.f17524a, hVar.f17524a) && j6.i.a(this.f17525b, hVar.f17525b) && j6.i.a(this.f17526c, hVar.f17526c);
        }

        public int hashCode() {
            return j6.i.b(this.f17524a, this.f17525b, this.f17526c);
        }

        public String toString() {
            return j6.g.b(this).d("addresses", this.f17524a).d("attributes", this.f17525b).d("loadBalancingPolicyConfig", this.f17526c).toString();
        }
    }

    public static abstract class i {
        /* JADX WARN: Code duplicated, block: B:7:0x000f  */
        public final y a() {
            boolean z10;
            List<y> listB = b();
            if (listB != null) {
                z10 = listB.size() == 1;
            }
            j6.m.x(z10, "%s does not have exactly one group", listB);
            return listB.get(0);
        }

        public List<y> b() {
            throw new UnsupportedOperationException();
        }

        public abstract vb.a c();

        public vb.f d() {
            throw new UnsupportedOperationException();
        }

        public Object e() {
            throw new UnsupportedOperationException();
        }

        public abstract void f();

        public abstract void g();

        public void h(k kVar) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void i(List<y> list) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class j {
        public abstract f a(g gVar);

        @Deprecated
        public void b() {
        }
    }

    public interface k {
        void a(r rVar);
    }

    public l1 a(h hVar) {
        if (!hVar.a().isEmpty() || b()) {
            int i10 = this.f17509a;
            this.f17509a = i10 + 1;
            if (i10 == 0) {
                d(hVar);
            }
            this.f17509a = 0;
            return l1.f17405e;
        }
        l1 l1VarQ = l1.f17420t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
        c(l1VarQ);
        return l1VarQ;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(l1 l1Var);

    public void d(h hVar) {
        int i10 = this.f17509a;
        this.f17509a = i10 + 1;
        if (i10 == 0) {
            a(hVar);
        }
        this.f17509a = 0;
    }

    public void e() {
    }

    public abstract void f();
}
