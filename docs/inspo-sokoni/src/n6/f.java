package n6;

import j6.m;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class f extends g {

    public static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f13439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13441c;

        public a(int[] iArr, int i10, int i11) {
            this.f13439a = iArr;
            this.f13440b = i10;
            this.f13441c = i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && f.e(this.f13439a, ((Integer) obj).intValue(), this.f13440b, this.f13441c) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer get(int i10) {
            m.m(i10, size());
            return Integer.valueOf(this.f13439a[this.f13440b + i10]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f13439a[this.f13440b + i10] != aVar.f13439a[aVar.f13440b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer set(int i10, Integer num) {
            m.m(i10, size());
            int[] iArr = this.f13439a;
            int i11 = this.f13440b;
            int i12 = iArr[i11 + i10];
            iArr[i11 + i10] = ((Integer) m.o(num)).intValue();
            return Integer.valueOf(i12);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iD = 1;
            for (int i10 = this.f13440b; i10 < this.f13441c; i10++) {
                iD = (iD * 31) + f.d(this.f13439a[i10]);
            }
            return iD;
        }

        public int[] i() {
            return Arrays.copyOfRange(this.f13439a, this.f13440b, this.f13441c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iE;
            if (!(obj instanceof Integer) || (iE = f.e(this.f13439a, ((Integer) obj).intValue(), this.f13440b, this.f13441c)) < 0) {
                return -1;
            }
            return iE - this.f13440b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iF;
            if (!(obj instanceof Integer) || (iF = f.f(this.f13439a, ((Integer) obj).intValue(), this.f13440b, this.f13441c)) < 0) {
                return -1;
            }
            return iF - this.f13440b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13441c - this.f13440b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i10, int i11) {
            m.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            int[] iArr = this.f13439a;
            int i12 = this.f13440b;
            return new a(iArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
            sb2.append('[');
            sb2.append(this.f13439a[this.f13440b]);
            int i10 = this.f13440b;
            while (true) {
                i10++;
                if (i10 >= this.f13441c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.f13439a[i10]);
            }
        }
    }

    public static int c(int i10, int i11, int i12) {
        m.i(i11 <= i12, "min (%s) must be less than or equal to max (%s)", i11, i12);
        return Math.min(Math.max(i10, i11), i12);
    }

    public static int d(int i10) {
        return i10;
    }

    public static int e(int[] iArr, int i10, int i11, int i12) {
        while (i11 < i12) {
            if (iArr[i11] == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int f(int[] iArr, int i10, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (iArr[i13] == i10) {
                return i13;
            }
        }
        return -1;
    }

    public static int g(long j10) {
        if (j10 > 2147483647L) {
            return com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static int[] h(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).i();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = ((Number) m.o(array[i10])).intValue();
        }
        return iArr;
    }
}
