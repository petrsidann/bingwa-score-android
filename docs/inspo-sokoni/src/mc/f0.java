package mc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class f0<T> extends d<T> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f13295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13298e;

    public static final class a extends c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13300d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f0<T> f13301e;

        public a(f0<T> f0Var) {
            this.f13301e = f0Var;
            this.f13299c = f0Var.size();
            this.f13300d = f0Var.f13297d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // mc.c
        public void b() {
            if (this.f13299c == 0) {
                c();
                return;
            }
            d(this.f13301e.f13295b[this.f13300d]);
            this.f13300d = (this.f13300d + 1) % this.f13301e.f13296c;
            this.f13299c--;
        }
    }

    public f0(int i10) {
        this(new Object[i10], 0);
    }

    public f0(Object[] buffer, int i10) {
        kotlin.jvm.internal.k.e(buffer, "buffer");
        this.f13295b = buffer;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
        }
        if (i10 <= buffer.length) {
            this.f13296c = buffer.length;
            this.f13298e = i10;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // mc.d, java.util.List
    public T get(int i10) {
        d.f13286a.b(i10, size());
        return (T) this.f13295b[(this.f13297d + i10) % this.f13296c];
    }

    @Override // mc.b
    public int h() {
        return this.f13298e;
    }

    @Override // mc.d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void n(T t10) {
        if (q()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f13295b[(this.f13297d + size()) % this.f13296c] = t10;
        this.f13298e = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f0<T> o(int i10) {
        Object[] array;
        int i11 = this.f13296c;
        int iC = bd.h.c(i11 + (i11 >> 1) + 1, i10);
        if (this.f13297d == 0) {
            array = Arrays.copyOf(this.f13295b, iC);
            kotlin.jvm.internal.k.d(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iC]);
        }
        return new f0<>(array, size());
    }

    public final boolean q() {
        return size() == this.f13296c;
    }

    public final void r(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
        }
        if (!(i10 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
        }
        if (i10 > 0) {
            int i11 = this.f13297d;
            int i12 = (i11 + i10) % this.f13296c;
            if (i11 > i12) {
                j.i(this.f13295b, null, i11, this.f13296c);
                j.i(this.f13295b, null, 0, i12);
            } else {
                j.i(this.f13295b, null, i11, i12);
            }
            this.f13297d = i12;
            this.f13298e = size() - i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mc.b, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // mc.b, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.k.d(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f13297d; i11 < size && i12 < this.f13296c; i12++) {
            objArr[i11] = this.f13295b[i12];
            i11++;
        }
        while (i11 < size) {
            objArr[i11] = this.f13295b[i10];
            i11++;
            i10++;
        }
        return (T[]) n.d(size, objArr);
    }
}
