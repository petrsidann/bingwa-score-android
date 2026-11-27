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
public final class d extends e {

    public static class a extends AbstractList<Float> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f13436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13438c;

        public a(float[] fArr, int i10, int i11) {
            this.f13436a = fArr;
            this.f13437b = i10;
            this.f13438c = i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && d.d(this.f13436a, ((Float) obj).floatValue(), this.f13437b, this.f13438c) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float get(int i10) {
            m.m(i10, size());
            return Float.valueOf(this.f13436a[this.f13437b + i10]);
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
                if (this.f13436a[this.f13437b + i10] != aVar.f13436a[aVar.f13437b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Float set(int i10, Float f10) {
            m.m(i10, size());
            float[] fArr = this.f13436a;
            int i11 = this.f13437b;
            float f11 = fArr[i11 + i10];
            fArr[i11 + i10] = ((Float) m.o(f10)).floatValue();
            return Float.valueOf(f11);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i10 = this.f13437b; i10 < this.f13438c; i10++) {
                iC = (iC * 31) + d.c(this.f13436a[i10]);
            }
            return iC;
        }

        public float[] i() {
            return Arrays.copyOfRange(this.f13436a, this.f13437b, this.f13438c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Float) || (iD = d.d(this.f13436a, ((Float) obj).floatValue(), this.f13437b, this.f13438c)) < 0) {
                return -1;
            }
            return iD - this.f13437b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Float) || (iE = d.e(this.f13436a, ((Float) obj).floatValue(), this.f13437b, this.f13438c)) < 0) {
                return -1;
            }
            return iE - this.f13437b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13438c - this.f13437b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i10, int i11) {
            m.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            float[] fArr = this.f13436a;
            int i12 = this.f13437b;
            return new a(fArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 12);
            sb2.append('[');
            sb2.append(this.f13436a[this.f13437b]);
            int i10 = this.f13437b;
            while (true) {
                i10++;
                if (i10 >= this.f13438c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.f13436a[i10]);
            }
        }
    }

    public static int c(float f10) {
        return Float.valueOf(f10).hashCode();
    }

    public static int d(float[] fArr, float f10, int i10, int i11) {
        while (i10 < i11) {
            if (fArr[i10] == f10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int e(float[] fArr, float f10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (fArr[i12] == f10) {
                return i12;
            }
        }
        return -1;
    }

    public static float[] f(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).i();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            fArr[i10] = ((Number) m.o(array[i10])).floatValue();
        }
        return fArr;
    }
}
