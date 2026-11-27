package q7;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class x<T> implements o8.b<Set<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set<T> f14896b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set<o8.b<T>> f14895a = Collections.newSetFromMap(new ConcurrentHashMap());

    public x(Collection<o8.b<T>> collection) {
        this.f14895a.addAll(collection);
    }

    public static x<?> b(Collection<o8.b<?>> collection) {
        return new x<>((Set) collection);
    }

    public synchronized void a(o8.b<T> bVar) {
        Set set;
        if (this.f14896b == null) {
            set = this.f14895a;
        } else {
            set = this.f14896b;
            bVar = (o8.b<T>) bVar.get();
        }
        set.add(bVar);
    }

    @Override // o8.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f14896b == null) {
            synchronized (this) {
                if (this.f14896b == null) {
                    this.f14896b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f14896b);
    }

    public final synchronized void d() {
        Iterator<o8.b<T>> it = this.f14895a.iterator();
        while (it.hasNext()) {
            this.f14896b.add(it.next().get());
        }
        this.f14895a = null;
    }
}
