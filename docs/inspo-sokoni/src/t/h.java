package t;

/* JADX INFO: loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15762e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f15764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f15765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15766d;

    public h() {
        this(10);
    }

    public h(int i10) {
        this.f15763a = false;
        if (i10 == 0) {
            this.f15764b = c.f15732a;
            this.f15765c = c.f15734c;
        } else {
            int iE = c.e(i10);
            this.f15764b = new int[iE];
            this.f15765c = new Object[iE];
        }
    }

    public void a(int i10, E e10) {
        int i11 = this.f15766d;
        if (i11 != 0 && i10 <= this.f15764b[i11 - 1]) {
            j(i10, e10);
            return;
        }
        if (this.f15763a && i11 >= this.f15764b.length) {
            d();
        }
        int i12 = this.f15766d;
        if (i12 >= this.f15764b.length) {
            int iE = c.e(i12 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f15764b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f15765c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f15764b = iArr;
            this.f15765c = objArr;
        }
        this.f15764b[i12] = i10;
        this.f15765c[i12] = e10;
        this.f15766d = i12 + 1;
    }

    public void b() {
        int i10 = this.f15766d;
        Object[] objArr = this.f15765c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f15766d = 0;
        this.f15763a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f15764b = (int[]) this.f15764b.clone();
            hVar.f15765c = (Object[]) this.f15765c.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void d() {
        int i10 = this.f15766d;
        int[] iArr = this.f15764b;
        Object[] objArr = this.f15765c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f15762e) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f15763a = false;
        this.f15766d = i11;
    }

    public E f(int i10) {
        return g(i10, null);
    }

    public E g(int i10, E e10) {
        E e11;
        int iA = c.a(this.f15764b, this.f15766d, i10);
        return (iA < 0 || (e11 = (E) this.f15765c[iA]) == f15762e) ? e10 : e11;
    }

    public int h(E e10) {
        if (this.f15763a) {
            d();
        }
        for (int i10 = 0; i10 < this.f15766d; i10++) {
            if (this.f15765c[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    public int i(int i10) {
        if (this.f15763a) {
            d();
        }
        return this.f15764b[i10];
    }

    public void j(int i10, E e10) {
        int iA = c.a(this.f15764b, this.f15766d, i10);
        if (iA >= 0) {
            this.f15765c[iA] = e10;
            return;
        }
        int i11 = ~iA;
        int i12 = this.f15766d;
        if (i11 < i12) {
            Object[] objArr = this.f15765c;
            if (objArr[i11] == f15762e) {
                this.f15764b[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (this.f15763a && i12 >= this.f15764b.length) {
            d();
            i11 = ~c.a(this.f15764b, this.f15766d, i10);
        }
        int i13 = this.f15766d;
        if (i13 >= this.f15764b.length) {
            int iE = c.e(i13 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f15764b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f15765c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15764b = iArr;
            this.f15765c = objArr2;
        }
        int i14 = this.f15766d;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.f15764b;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.f15765c;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f15766d - i11);
        }
        this.f15764b[i11] = i10;
        this.f15765c[i11] = e10;
        this.f15766d++;
    }

    public int l() {
        if (this.f15763a) {
            d();
        }
        return this.f15766d;
    }

    public E m(int i10) {
        if (this.f15763a) {
            d();
        }
        return (E) this.f15765c[i10];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15766d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f15766d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(i(i10));
            sb2.append('=');
            E eM = m(i10);
            if (eM != this) {
                sb2.append(eM);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
