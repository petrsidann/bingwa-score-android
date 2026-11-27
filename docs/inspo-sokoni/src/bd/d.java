package bd;

import mc.b0;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Iterable<Integer> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3071d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3074c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final d a(int i10, int i11, int i12) {
            return new d(i10, i11, i12);
        }
    }

    public d(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3072a = i10;
        this.f3073b = sc.c.b(i10, i11, i12);
        this.f3074c = i12;
    }

    public final int e() {
        return this.f3072a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f3072a != dVar.f3072a || this.f3073b != dVar.f3073b || this.f3074c != dVar.f3074c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int h() {
        return this.f3073b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3072a * 31) + this.f3073b) * 31) + this.f3074c;
    }

    public final int i() {
        return this.f3074c;
    }

    public boolean isEmpty() {
        if (this.f3074c > 0) {
            if (this.f3072a > this.f3073b) {
                return true;
            }
        } else if (this.f3072a < this.f3073b) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b0 iterator() {
        return new e(this.f3072a, this.f3073b, this.f3074c);
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f3074c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f3072a);
            sb2.append("..");
            sb2.append(this.f3073b);
            sb2.append(" step ");
            i10 = this.f3074c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f3072a);
            sb2.append(" downTo ");
            sb2.append(this.f3073b);
            sb2.append(" step ");
            i10 = -this.f3074c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
