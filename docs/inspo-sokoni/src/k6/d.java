package k6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d<K, V> implements c0<K, V> {
    @Override // k6.c0
    public abstract Map<K, Collection<V>> a();

    public boolean b(Object obj) {
        Iterator<Collection<V>> it = a().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return d0.a(this, obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
