package n6;

import j6.m;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f13432a = c();

    public static class a extends AbstractList<Double> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double[] f13433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13435c;

        public a(double[] dArr, int i10, int i11) {
            this.f13433a = dArr;
            this.f13434b = i10;
            this.f13435c = i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && b.e(this.f13433a, ((Double) obj).doubleValue(), this.f13434b, this.f13435c) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double get(int i10) {
            m.m(i10, size());
            return Double.valueOf(this.f13433a[this.f13434b + i10]);
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
                if (this.f13433a[this.f13434b + i10] != aVar.f13433a[aVar.f13434b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Double set(int i10, Double d10) {
            m.m(i10, size());
            double[] dArr = this.f13433a;
            int i11 = this.f13434b;
            double d11 = dArr[i11 + i10];
            dArr[i11 + i10] = ((Double) m.o(d10)).doubleValue();
            return Double.valueOf(d11);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iD = 1;
            for (int i10 = this.f13434b; i10 < this.f13435c; i10++) {
                iD = (iD * 31) + b.d(this.f13433a[i10]);
            }
            return iD;
        }

        public double[] i() {
            return Arrays.copyOfRange(this.f13433a, this.f13434b, this.f13435c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iE;
            if (!(obj instanceof Double) || (iE = b.e(this.f13433a, ((Double) obj).doubleValue(), this.f13434b, this.f13435c)) < 0) {
                return -1;
            }
            return iE - this.f13434b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iF;
            if (!(obj instanceof Double) || (iF = b.f(this.f13433a, ((Double) obj).doubleValue(), this.f13434b, this.f13435c)) < 0) {
                return -1;
            }
            return iF - this.f13434b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13435c - this.f13434b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i10, int i11) {
            m.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            double[] dArr = this.f13433a;
            int i12 = this.f13434b;
            return new a(dArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 12);
            sb2.append('[');
            sb2.append(this.f13433a[this.f13434b]);
            int i10 = this.f13434b;
            while (true) {
                i10++;
                if (i10 >= this.f13435c) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.f13433a[i10]);
            }
        }
    }

    public static Pattern c() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    public static int d(double d10) {
        return Double.valueOf(d10).hashCode();
    }

    public static int e(double[] dArr, double d10, int i10, int i11) {
        while (i10 < i11) {
            if (dArr[i10] == d10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int f(double[] dArr, double d10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (dArr[i12] == d10) {
                return i12;
            }
        }
        return -1;
    }

    public static double[] g(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).i();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = ((Number) m.o(array[i10])).doubleValue();
        }
        return dArr;
    }
}
