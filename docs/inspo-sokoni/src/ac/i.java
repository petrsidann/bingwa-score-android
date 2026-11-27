package ac;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f512d = new int[10];

    public int a(int i10) {
        return this.f512d[i10];
    }

    public int b() {
        if ((this.f509a & 2) != 0) {
            return this.f512d[1];
        }
        return -1;
    }

    public int c(int i10) {
        return (this.f509a & 32) != 0 ? this.f512d[5] : i10;
    }

    public boolean d(int i10) {
        return ((1 << i10) & this.f509a) != 0;
    }

    public i e(int i10, int i11, int i12) {
        int[] iArr = this.f512d;
        if (i10 >= iArr.length) {
            return this;
        }
        int i13 = 1 << i10;
        this.f509a |= i13;
        this.f510b = (i11 & 1) != 0 ? this.f510b | i13 : this.f510b & (~i13);
        this.f511c = (i11 & 2) != 0 ? this.f511c | i13 : this.f511c & (~i13);
        iArr[i10] = i12;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f509a);
    }
}
