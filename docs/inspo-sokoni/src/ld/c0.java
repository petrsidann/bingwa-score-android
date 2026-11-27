package ld;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class c0<T> {
    private volatile AtomicReferenceArray<T> array;

    public c0(int i10) {
        this.array = new AtomicReferenceArray<>(i10);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int i10) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i10 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i10);
        }
        return null;
    }

    public final void c(int i10, T t10) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i10 < length) {
            atomicReferenceArray.set(i10, t10);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(bd.h.a(i10 + 1, length * 2));
        for (int i11 = 0; i11 < length; i11++) {
            atomicReferenceArray2.set(i11, atomicReferenceArray.get(i11));
        }
        atomicReferenceArray2.set(i10, t10);
        this.array = atomicReferenceArray2;
    }
}
