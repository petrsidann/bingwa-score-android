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
public final class h {

    public static class a extends AbstractList<Long> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f13442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13444c;

        public a(long[] jArr, int i10, int i11) {
            this.f13442a = jArr;
            this.f13443b = i10;
            this.f13444c = i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && h.d(this.f13442a, ((Long) obj).longValue(), this.f13443b, this.f13444c) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Long get(int i10) {
            m.m(i10, size());
            return Long.valueOf(this.f13442a[this.f13443b + i10]);
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
                if (this.f13442a[this.f13443b + i10] != aVar.f13442a[aVar.f13443b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Long set(int i10, Long l10) {
            m.m(i10, size());
            long[] jArr = this.f13442a;
            int i11 = this.f13443b;
            long j10 = jArr[i11 + i10];
            jArr[i11 + i10] = ((Long) m.o(l10)).longValue();
            return Long.valueOf(j10);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i10 = this.f13443b; i10 < this.f13444c; i10++) {
                iC = (iC * 31) + h.c(this.f13442a[i10]);
            }
            return iC;
        }

        public long[] i() {
            return Arrays.copyOfRange(this.f13442a, this.f13443b, this.f13444c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Long) || (iD = h.d(this.f13442a, ((Long) obj).longValue(), this.f13443b, this.f13444c)) < 0) {
                return -1;
            }
            return iD - this.f13443b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Long) || (iE = h.e(this.f13442a, ((Long) obj).longValue(), this.f13443b, this.f13444c)) < 0) {
                return -1;
            }
            return iE - this.f13443b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13444c - this.f13443b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i10, int i11) {
            m.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            long[] jArr = this.f13442a;
            int i12 = this.f13443b;
            return new a(jArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 10);
            sb2.append('[');
            sb2.append(this.f13442a[this.f13443b]);
            int i10 = this.f13443b;
            while (true) {
                i10++;
                if (i10 >= this.f13444c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.f13442a[i10]);
            }
        }
    }

    public static int c(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static int d(long[] jArr, long j10, int i10, int i11) {
        while (i10 < i11) {
            if (jArr[i10] == j10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int e(long[] jArr, long j10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (jArr[i12] == j10) {
                return i12;
            }
        }
        return -1;
    }

    public static long[] f(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).i();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = ((Number) m.o(array[i10])).longValue();
        }
        return jArr;
    }
}
