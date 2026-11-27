package mc;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 implements Iterator<Integer> {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
