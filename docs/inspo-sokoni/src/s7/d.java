package s7;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class d<K, V> implements Iterator<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<j<K, V>> f15594a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15595b;

    public d(h<K, V> hVar, K k10, Comparator<K> comparator, boolean z10) {
        int iCompare;
        this.f15595b = z10;
        while (!hVar.isEmpty()) {
            if (k10 != null) {
                K key = hVar.getKey();
                iCompare = z10 ? comparator.compare(k10, key) : comparator.compare(key, k10);
            } else {
                iCompare = 1;
            }
            if (iCompare < 0) {
                hVar = z10 ? hVar.a() : hVar.f();
            } else if (iCompare == 0) {
                this.f15594a.push((j) hVar);
                return;
            } else {
                this.f15594a.push((j) hVar);
                if (z10) {
                }
            }
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        try {
            j<K, V> jVarPop = this.f15594a.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(jVarPop.getKey(), jVarPop.getValue());
            if (this.f15595b) {
                for (h<K, V> hVarA = jVarPop.a(); !hVarA.isEmpty(); hVarA = hVarA.f()) {
                    this.f15594a.push((j) hVarA);
                }
            } else {
                for (h<K, V> hVarF = jVarPop.f(); !hVarF.isEmpty(); hVarF = hVarF.a()) {
                    this.f15594a.push((j) hVarF);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15594a.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
