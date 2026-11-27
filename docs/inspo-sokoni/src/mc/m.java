package mc;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements Iterator<Character> {
    public abstract char b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
