package t;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object[] f15755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f15756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Object[] f15757f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f15758l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f15759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f15760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15761c;

    public g() {
        this.f15759a = c.f15732a;
        this.f15760b = c.f15734c;
        this.f15761c = 0;
    }

    public g(int i10) {
        if (i10 == 0) {
            this.f15759a = c.f15732a;
            this.f15760b = c.f15734c;
        } else {
            a(i10);
        }
        this.f15761c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            j(gVar);
        }
    }

    private void a(int i10) {
        if (i10 == 8) {
            synchronized (g.class) {
                Object[] objArr = f15757f;
                if (objArr != null) {
                    this.f15760b = objArr;
                    f15757f = (Object[]) objArr[0];
                    this.f15759a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f15758l--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f15755d;
                if (objArr2 != null) {
                    this.f15760b = objArr2;
                    f15755d = (Object[]) objArr2[0];
                    this.f15759a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f15756e--;
                    return;
                }
            }
        }
        this.f15759a = new int[i10];
        this.f15760b = new Object[i10 << 1];
    }

    public static int b(int[] iArr, int i10, int i11) {
        try {
            return c.a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void d(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f15758l < 10) {
                    objArr[0] = f15757f;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f15757f = objArr;
                    f15758l++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f15756e < 10) {
                    objArr[0] = f15755d;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f15755d = objArr;
                    f15756e++;
                }
            }
        }
    }

    public void c(int i10) {
        int i11 = this.f15761c;
        int[] iArr = this.f15759a;
        if (iArr.length < i10) {
            Object[] objArr = this.f15760b;
            a(i10);
            if (this.f15761c > 0) {
                System.arraycopy(iArr, 0, this.f15759a, 0, i11);
                System.arraycopy(objArr, 0, this.f15760b, 0, i11 << 1);
            }
            d(iArr, objArr, i11);
        }
        if (this.f15761c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f15761c;
        if (i10 > 0) {
            int[] iArr = this.f15759a;
            Object[] objArr = this.f15760b;
            this.f15759a = c.f15732a;
            this.f15760b = c.f15734c;
            this.f15761c = 0;
            d(iArr, objArr, i10);
        }
        if (this.f15761c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public int e(Object obj, int i10) {
        int i11 = this.f15761c;
        if (i11 == 0) {
            return -1;
        }
        int iB = b(this.f15759a, i11, i10);
        if (iB < 0 || obj.equals(this.f15760b[iB << 1])) {
            return iB;
        }
        int i12 = iB + 1;
        while (i12 < i11 && this.f15759a[i12] == i10) {
            if (obj.equals(this.f15760b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iB - 1; i13 >= 0 && this.f15759a[i13] == i10; i13--) {
            if (obj.equals(this.f15760b[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f15761c; i10++) {
                try {
                    K kI = i(i10);
                    V vM = m(i10);
                    Object obj2 = gVar.get(kI);
                    if (vM == null) {
                        if (obj2 != null || !gVar.containsKey(kI)) {
                            return false;
                        }
                    } else if (!vM.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f15761c; i11++) {
                try {
                    K kI2 = i(i11);
                    V vM2 = m(i11);
                    Object obj3 = map.get(kI2);
                    if (vM2 == null) {
                        if (obj3 != null || !map.containsKey(kI2)) {
                            return false;
                        }
                    } else if (!vM2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public int g() {
        int i10 = this.f15761c;
        if (i10 == 0) {
            return -1;
        }
        int iB = b(this.f15759a, i10, 0);
        if (iB < 0 || this.f15760b[iB << 1] == null) {
            return iB;
        }
        int i11 = iB + 1;
        while (i11 < i10 && this.f15759a[i11] == 0) {
            if (this.f15760b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iB - 1; i12 >= 0 && this.f15759a[i12] == 0; i12--) {
            if (this.f15760b[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v10) {
        int iF = f(obj);
        return iF >= 0 ? (V) this.f15760b[(iF << 1) + 1] : v10;
    }

    public int h(Object obj) {
        int i10 = this.f15761c * 2;
        Object[] objArr = this.f15760b;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f15759a;
        Object[] objArr = this.f15760b;
        int i10 = this.f15761c;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public K i(int i10) {
        return (K) this.f15760b[i10 << 1];
    }

    public boolean isEmpty() {
        return this.f15761c <= 0;
    }

    public void j(g<? extends K, ? extends V> gVar) {
        int i10 = gVar.f15761c;
        c(this.f15761c + i10);
        if (this.f15761c != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(gVar.i(i11), gVar.m(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(gVar.f15759a, 0, this.f15759a, 0, i10);
            System.arraycopy(gVar.f15760b, 0, this.f15760b, 0, i10 << 1);
            this.f15761c = i10;
        }
    }

    public V k(int i10) {
        Object[] objArr = this.f15760b;
        int i11 = i10 << 1;
        V v10 = (V) objArr[i11 + 1];
        int i12 = this.f15761c;
        int i13 = 0;
        if (i12 <= 1) {
            d(this.f15759a, objArr, i12);
            this.f15759a = c.f15732a;
            this.f15760b = c.f15734c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.f15759a;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.f15760b;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.f15760b;
                int i17 = i14 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                a(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.f15761c) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f15759a, 0, i10);
                    System.arraycopy(objArr, 0, this.f15760b, 0, i11);
                }
                if (i10 < i14) {
                    int i18 = i10 + 1;
                    int i19 = i14 - i10;
                    System.arraycopy(iArr, i18, this.f15759a, i10, i19);
                    System.arraycopy(objArr, i18 << 1, this.f15760b, i11, i19 << 1);
                }
            }
            i13 = i14;
        }
        if (i12 != this.f15761c) {
            throw new ConcurrentModificationException();
        }
        this.f15761c = i13;
        return v10;
    }

    public V l(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f15760b;
        V v11 = (V) objArr[i11];
        objArr[i11] = v10;
        return v11;
    }

    public V m(int i10) {
        return (V) this.f15760b[(i10 << 1) + 1];
    }

    public V put(K k10, V v10) {
        int i10;
        int iE;
        int i11 = this.f15761c;
        if (k10 == null) {
            iE = g();
            i10 = 0;
        } else {
            int iHashCode = k10.hashCode();
            i10 = iHashCode;
            iE = e(k10, iHashCode);
        }
        if (iE >= 0) {
            int i12 = (iE << 1) + 1;
            Object[] objArr = this.f15760b;
            V v11 = (V) objArr[i12];
            objArr[i12] = v10;
            return v11;
        }
        int i13 = ~iE;
        int[] iArr = this.f15759a;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            Object[] objArr2 = this.f15760b;
            a(i14);
            if (i11 != this.f15761c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f15759a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f15760b, 0, objArr2.length);
            }
            d(iArr, objArr2, i11);
        }
        if (i13 < i11) {
            int[] iArr3 = this.f15759a;
            int i15 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i15, i11 - i13);
            Object[] objArr3 = this.f15760b;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.f15761c - i13) << 1);
        }
        int i16 = this.f15761c;
        if (i11 == i16) {
            int[] iArr4 = this.f15759a;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.f15760b;
                int i17 = i13 << 1;
                objArr4[i17] = k10;
                objArr4[i17 + 1] = v10;
                this.f15761c = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        return v11 == null ? put(k10, v10) : v11;
    }

    public V remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return k(iF);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        V vM = m(iF);
        if (obj2 != vM && (obj2 == null || !obj2.equals(vM))) {
            return false;
        }
        k(iF);
        return true;
    }

    public V replace(K k10, V v10) {
        int iF = f(k10);
        if (iF >= 0) {
            return l(iF, v10);
        }
        return null;
    }

    public boolean replace(K k10, V v10, V v11) {
        int iF = f(k10);
        if (iF < 0) {
            return false;
        }
        V vM = m(iF);
        if (vM != v10 && (v10 == null || !v10.equals(vM))) {
            return false;
        }
        l(iF, v11);
        return true;
    }

    public int size() {
        return this.f15761c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15761c * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f15761c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            K kI = i(i10);
            if (kI != this) {
                sb2.append(kI);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vM = m(i10);
            if (vM != this) {
                sb2.append(vM);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
