package dd;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<b<T>> f6708a;

    public a(b<? extends T> sequence) {
        k.e(sequence, "sequence");
        this.f6708a = new AtomicReference<>(sequence);
    }

    @Override // dd.b
    public Iterator<T> iterator() {
        b<T> andSet = this.f6708a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
