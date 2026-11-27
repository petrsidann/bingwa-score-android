package k6;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l0<K, V> extends r<K, V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final r<Object, Object> f11576m = new l0(null, new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object f11577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Object[] f11578f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final transient int f11579l;

    public static class a<K, V> extends t<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient r<K, V> f11580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Object[] f11581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f11582e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient int f11583f;

        /* JADX INFO: renamed from: k6.l0$a$a, reason: collision with other inner class name */
        public class C0198a extends q<Map.Entry<K, V>> {
            public C0198a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> get(int i10) {
                j6.m.m(i10, a.this.f11583f);
                int i11 = i10 * 2;
                Object obj = a.this.f11581d[a.this.f11582e + i11];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f11581d[i11 + (a.this.f11582e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // k6.p
            public boolean l() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f11583f;
            }
        }

        public a(r<K, V> rVar, Object[] objArr, int i10, int i11) {
            this.f11580c = rVar;
            this.f11581d = objArr;
            this.f11582e = i10;
            this.f11583f = i11;
        }

        @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f11580c.get(key));
        }

        @Override // k6.p
        public int h(Object[] objArr, int i10) {
            return e().h(objArr, i10);
        }

        @Override // k6.p
        public boolean l() {
            return true;
        }

        @Override // k6.t, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: n */
        public t0<Map.Entry<K, V>> iterator() {
            return e().iterator();
        }

        @Override // k6.t
        public q<Map.Entry<K, V>> s() {
            return new C0198a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f11583f;
        }
    }

    public static final class b<K> extends t<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient r<K, ?> f11585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient q<K> f11586d;

        public b(r<K, ?> rVar, q<K> qVar) {
            this.f11585c = rVar;
            this.f11586d = qVar;
        }

        @Override // k6.p, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f11585c.get(obj) != null;
        }

        @Override // k6.t, k6.p
        public q<K> e() {
            return this.f11586d;
        }

        @Override // k6.p
        public int h(Object[] objArr, int i10) {
            return e().h(objArr, i10);
        }

        @Override // k6.p
        public boolean l() {
            return true;
        }

        @Override // k6.t, k6.p, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: n */
        public t0<K> iterator() {
            return e().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f11585c.size();
        }
    }

    public static final class c extends q<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f11587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f11588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f11589e;

        public c(Object[] objArr, int i10, int i11) {
            this.f11587c = objArr;
            this.f11588d = i10;
            this.f11589e = i11;
        }

        @Override // java.util.List
        public Object get(int i10) {
            j6.m.m(i10, this.f11589e);
            Object obj = this.f11587c[(i10 * 2) + this.f11588d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // k6.p
        public boolean l() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f11589e;
        }
    }

    public l0(Object obj, Object[] objArr, int i10) {
        this.f11577e = obj;
        this.f11578f = objArr;
        this.f11579l = i10;
    }

    public static <K, V> l0<K, V> k(int i10, Object[] objArr, r.a<K, V> aVar) {
        if (i10 == 0) {
            return (l0) f11576m;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            g.a(obj, obj2);
            return new l0<>(null, objArr, 1);
        }
        j6.m.r(i10, objArr.length >> 1);
        Object objL = l(objArr, i10, t.o(i10), 0);
        if (objL instanceof Object[]) {
            Object[] objArr2 = (Object[]) objL;
            r.a.C0200a c0200a = (r.a.C0200a) objArr2[2];
            if (aVar == null) {
                throw c0200a.a();
            }
            aVar.f11623e = c0200a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objL = obj3;
            i10 = iIntValue;
        }
        return new l0<>(objL, objArr, i10);
    }

    public static Object l(Object[] objArr, int i10, int i11, int i12) {
        r.a.C0200a c0200a = null;
        if (i10 == 1) {
            Object obj = objArr[i12];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj2);
            g.a(obj, obj2);
            return null;
        }
        int i13 = i11 - 1;
        int i14 = -1;
        if (i11 <= 128) {
            byte[] bArr = new byte[i11];
            Arrays.fill(bArr, (byte) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                int i17 = (i16 * 2) + i12;
                int i18 = (i15 * 2) + i12;
                Object obj3 = objArr[i17];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj4);
                g.a(obj3, obj4);
                int iB = o.b(obj3.hashCode());
                while (true) {
                    int i19 = iB & i13;
                    int i20 = bArr[i19] & 255;
                    if (i20 == 255) {
                        bArr[i19] = (byte) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj3;
                            objArr[i18 ^ 1] = obj4;
                        }
                        i15++;
                        break;
                    }
                    if (obj3.equals(objArr[i20])) {
                        int i21 = i20 ^ 1;
                        Object obj5 = objArr[i21];
                        Objects.requireNonNull(obj5);
                        c0200a = new r.a.C0200a(obj3, obj4, obj5);
                        objArr[i21] = obj4;
                        break;
                    }
                    iB = i19 + 1;
                }
            }
            return i15 == i10 ? bArr : new Object[]{bArr, Integer.valueOf(i15), c0200a};
        }
        if (i11 <= 32768) {
            short[] sArr = new short[i11];
            Arrays.fill(sArr, (short) -1);
            int i22 = 0;
            for (int i23 = 0; i23 < i10; i23++) {
                int i24 = (i23 * 2) + i12;
                int i25 = (i22 * 2) + i12;
                Object obj6 = objArr[i24];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i24 ^ 1];
                Objects.requireNonNull(obj7);
                g.a(obj6, obj7);
                int iB2 = o.b(obj6.hashCode());
                while (true) {
                    int i26 = iB2 & i13;
                    int i27 = sArr[i26] & 65535;
                    if (i27 == 65535) {
                        sArr[i26] = (short) i25;
                        if (i22 < i23) {
                            objArr[i25] = obj6;
                            objArr[i25 ^ 1] = obj7;
                        }
                        i22++;
                        break;
                    }
                    if (obj6.equals(objArr[i27])) {
                        int i28 = i27 ^ 1;
                        Object obj8 = objArr[i28];
                        Objects.requireNonNull(obj8);
                        c0200a = new r.a.C0200a(obj6, obj7, obj8);
                        objArr[i28] = obj7;
                        break;
                    }
                    iB2 = i26 + 1;
                }
            }
            return i22 == i10 ? sArr : new Object[]{sArr, Integer.valueOf(i22), c0200a};
        }
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i10) {
            int i31 = (i29 * 2) + i12;
            int i32 = (i30 * 2) + i12;
            Object obj9 = objArr[i31];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i31 ^ 1];
            Objects.requireNonNull(obj10);
            g.a(obj9, obj10);
            int iB3 = o.b(obj9.hashCode());
            while (true) {
                int i33 = iB3 & i13;
                int i34 = iArr[i33];
                if (i34 == i14) {
                    iArr[i33] = i32;
                    if (i30 < i29) {
                        objArr[i32] = obj9;
                        objArr[i32 ^ 1] = obj10;
                    }
                    i30++;
                    break;
                }
                if (obj9.equals(objArr[i34])) {
                    int i35 = i34 ^ 1;
                    Object obj11 = objArr[i35];
                    Objects.requireNonNull(obj11);
                    c0200a = new r.a.C0200a(obj9, obj10, obj11);
                    objArr[i35] = obj10;
                    break;
                }
                iB3 = i33 + 1;
                i14 = -1;
            }
            i29++;
            i14 = -1;
        }
        return i30 == i10 ? iArr : new Object[]{iArr, Integer.valueOf(i30), c0200a};
    }

    public static Object m(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iB = o.b(obj2.hashCode());
            while (true) {
                int i12 = iB & length;
                int i13 = bArr[i12] & 255;
                if (i13 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                iB = i12 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iB2 = o.b(obj2.hashCode());
            while (true) {
                int i14 = iB2 & length2;
                int i15 = sArr[i14] & 65535;
                if (i15 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                iB2 = i14 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iB3 = o.b(obj2.hashCode());
            while (true) {
                int i16 = iB3 & length3;
                int i17 = iArr[i16];
                if (i17 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i17])) {
                    return objArr[i17 ^ 1];
                }
                iB3 = i16 + 1;
            }
        }
    }

    @Override // k6.r
    public t<Map.Entry<K, V>> c() {
        return new a(this, this.f11578f, 0, this.f11579l);
    }

    @Override // k6.r
    public t<K> d() {
        return new b(this, new c(this.f11578f, 0, this.f11579l));
    }

    @Override // k6.r
    public p<V> e() {
        return new c(this.f11578f, 1, this.f11579l);
    }

    @Override // k6.r
    public boolean g() {
        return false;
    }

    @Override // k6.r, java.util.Map
    public V get(Object obj) {
        V v10 = (V) m(this.f11577e, this.f11578f, this.f11579l, 0, obj);
        if (v10 == null) {
            return null;
        }
        return v10;
    }

    @Override // java.util.Map
    public int size() {
        return this.f11579l;
    }
}
