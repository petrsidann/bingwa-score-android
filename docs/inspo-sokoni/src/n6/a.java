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
public final class a {

    /* JADX INFO: renamed from: n6.a$a, reason: collision with other inner class name */
    public static class C0228a extends AbstractList<Byte> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f13429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13431c;

        public C0228a(byte[] bArr, int i10, int i11) {
            this.f13429a = bArr;
            this.f13430b = i10;
            this.f13431c = i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && a.d(this.f13429a, ((Byte) obj).byteValue(), this.f13430b, this.f13431c) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Byte get(int i10) {
            m.m(i10, size());
            return Byte.valueOf(this.f13429a[this.f13430b + i10]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0228a)) {
                return super.equals(obj);
            }
            C0228a c0228a = (C0228a) obj;
            int size = size();
            if (c0228a.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f13429a[this.f13430b + i10] != c0228a.f13429a[c0228a.f13430b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Byte set(int i10, Byte b10) {
            m.m(i10, size());
            byte[] bArr = this.f13429a;
            int i11 = this.f13430b;
            byte b11 = bArr[i11 + i10];
            bArr[i11 + i10] = ((Byte) m.o(b10)).byteValue();
            return Byte.valueOf(b11);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i10 = this.f13430b; i10 < this.f13431c; i10++) {
                iC = (iC * 31) + a.c(this.f13429a[i10]);
            }
            return iC;
        }

        public byte[] i() {
            return Arrays.copyOfRange(this.f13429a, this.f13430b, this.f13431c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Byte) || (iD = a.d(this.f13429a, ((Byte) obj).byteValue(), this.f13430b, this.f13431c)) < 0) {
                return -1;
            }
            return iD - this.f13430b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Byte) || (iE = a.e(this.f13429a, ((Byte) obj).byteValue(), this.f13430b, this.f13431c)) < 0) {
                return -1;
            }
            return iE - this.f13430b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13431c - this.f13430b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i10, int i11) {
            m.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            byte[] bArr = this.f13429a;
            int i12 = this.f13430b;
            return new C0228a(bArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
            sb2.append('[');
            sb2.append((int) this.f13429a[this.f13430b]);
            int i10 = this.f13430b;
            while (true) {
                i10++;
                if (i10 >= this.f13431c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append((int) this.f13429a[i10]);
            }
        }
    }

    public static int c(byte b10) {
        return b10;
    }

    public static int d(byte[] bArr, byte b10, int i10, int i11) {
        while (i10 < i11) {
            if (bArr[i10] == b10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int e(byte[] bArr, byte b10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (bArr[i12] == b10) {
                return i12;
            }
        }
        return -1;
    }

    public static byte[] f(Collection<? extends Number> collection) {
        if (collection instanceof C0228a) {
            return ((C0228a) collection).i();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = ((Number) m.o(array[i10])).byteValue();
        }
        return bArr;
    }
}
