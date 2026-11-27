package t;

/* JADX INFO: loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15735e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f15737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f15738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15739d;

    public d() {
        this(10);
    }

    public d(int i10) {
        this.f15736a = false;
        if (i10 == 0) {
            this.f15737b = c.f15733b;
            this.f15738c = c.f15734c;
        } else {
            int iF = c.f(i10);
            this.f15737b = new long[iF];
            this.f15738c = new Object[iF];
        }
    }

    public void a() {
        int i10 = this.f15739d;
        Object[] objArr = this.f15738c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f15739d = 0;
        this.f15736a = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f15737b = (long[]) this.f15737b.clone();
            dVar.f15738c = (Object[]) this.f15738c.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void c() {
        int i10 = this.f15739d;
        long[] jArr = this.f15737b;
        Object[] objArr = this.f15738c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f15735e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f15736a = false;
        this.f15739d = i11;
    }

    public E d(long j10) {
        return f(j10, null);
    }

    public E f(long j10, E e10) {
        E e11;
        int iB = c.b(this.f15737b, this.f15739d, j10);
        return (iB < 0 || (e11 = (E) this.f15738c[iB]) == f15735e) ? e10 : e11;
    }

    public int g(long j10) {
        if (this.f15736a) {
            c();
        }
        return c.b(this.f15737b, this.f15739d, j10);
    }

    public long h(int i10) {
        if (this.f15736a) {
            c();
        }
        return this.f15737b[i10];
    }

    public void i(long j10, E e10) {
        int iB = c.b(this.f15737b, this.f15739d, j10);
        if (iB >= 0) {
            this.f15738c[iB] = e10;
            return;
        }
        int i10 = ~iB;
        int i11 = this.f15739d;
        if (i10 < i11) {
            Object[] objArr = this.f15738c;
            if (objArr[i10] == f15735e) {
                this.f15737b[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f15736a && i11 >= this.f15737b.length) {
            c();
            i10 = ~c.b(this.f15737b, this.f15739d, j10);
        }
        int i12 = this.f15739d;
        if (i12 >= this.f15737b.length) {
            int iF = c.f(i12 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f15737b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f15738c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15737b = jArr;
            this.f15738c = objArr2;
        }
        int i13 = this.f15739d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f15737b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f15738c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f15739d - i10);
        }
        this.f15737b[i10] = j10;
        this.f15738c[i10] = e10;
        this.f15739d++;
    }

    public void j(long j10) {
        int iB = c.b(this.f15737b, this.f15739d, j10);
        if (iB >= 0) {
            Object[] objArr = this.f15738c;
            Object obj = objArr[iB];
            Object obj2 = f15735e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f15736a = true;
            }
        }
    }

    public void l(int i10) {
        Object[] objArr = this.f15738c;
        Object obj = objArr[i10];
        Object obj2 = f15735e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f15736a = true;
        }
    }

    public int m() {
        if (this.f15736a) {
            c();
        }
        return this.f15739d;
    }

    public E n(int i10) {
        if (this.f15736a) {
            c();
        }
        return (E) this.f15738c[i10];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15739d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f15739d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(h(i10));
            sb2.append('=');
            E eN = n(i10);
            if (eN != this) {
                sb2.append(eN);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
