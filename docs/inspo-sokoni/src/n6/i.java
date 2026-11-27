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
public final class i extends j {

    public static class a extends AbstractList<Short> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f13445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13447c;

        public a(short[] sArr, int i10, int i11) {
            this.f13445a = sArr;
            this.f13446b = i10;
            this.f13447c = i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Short) && i.d(this.f13445a, ((Short) obj).shortValue(), this.f13446b, this.f13447c) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Short get(int i10) {
            m.m(i10, size());
            return Short.valueOf(this.f13445a[this.f13446b + i10]);
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
                if (this.f13445a[this.f13446b + i10] != aVar.f13445a[aVar.f13446b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Short set(int i10, Short sh) {
            m.m(i10, size());
            short[] sArr = this.f13445a;
            int i11 = this.f13446b;
            short s10 = sArr[i11 + i10];
            sArr[i11 + i10] = ((Short) m.o(sh)).shortValue();
            return Short.valueOf(s10);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i10 = this.f13446b; i10 < this.f13447c; i10++) {
                iC = (iC * 31) + i.c(this.f13445a[i10]);
            }
            return iC;
        }

        public short[] i() {
            return Arrays.copyOfRange(this.f13445a, this.f13446b, this.f13447c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Short) || (iD = i.d(this.f13445a, ((Short) obj).shortValue(), this.f13446b, this.f13447c)) < 0) {
                return -1;
            }
            return iD - this.f13446b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Short) || (iE = i.e(this.f13445a, ((Short) obj).shortValue(), this.f13446b, this.f13447c)) < 0) {
                return -1;
            }
            return iE - this.f13446b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13447c - this.f13446b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i10, int i11) {
            m.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            short[] sArr = this.f13445a;
            int i12 = this.f13446b;
            return new a(sArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 6);
            sb2.append('[');
            sb2.append((int) this.f13445a[this.f13446b]);
            int i10 = this.f13446b;
            while (true) {
                i10++;
                if (i10 >= this.f13447c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append((int) this.f13445a[i10]);
            }
        }
    }

    public static int c(short s10) {
        return s10;
    }

    public static int d(short[] sArr, short s10, int i10, int i11) {
        while (i10 < i11) {
            if (sArr[i10] == s10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int e(short[] sArr, short s10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (sArr[i12] == s10) {
                return i12;
            }
        }
        return -1;
    }

    public static short[] f(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).i();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = ((Number) m.o(array[i10])).shortValue();
        }
        return sArr;
    }
}
