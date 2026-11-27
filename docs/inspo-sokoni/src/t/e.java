package t;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public e(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i10;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int safeSizeOf(K k10, V v10) {
        int iSizeOf = sizeOf(k10, v10);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException("Negative size: " + k10 + "=" + v10);
    }

    public V create(K k10) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public void entryRemoved(boolean z10, K k10, V v10, V v11) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final V get(K k10) {
        V vPut;
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v10 = this.map.get(k10);
            if (v10 != null) {
                this.hitCount++;
                return v10;
            }
            this.missCount++;
            V vCreate = create(k10);
            if (vCreate == null) {
                return null;
            }
            synchronized (this) {
                this.createCount++;
                vPut = this.map.put(k10, vCreate);
                if (vPut != null) {
                    this.map.put(k10, vPut);
                } else {
                    this.size += safeSizeOf(k10, vCreate);
                }
            }
            if (vPut != null) {
                entryRemoved(false, k10, vCreate, vPut);
                return vPut;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final V put(K k10, V v10) {
        V vPut;
        if (k10 == null || v10 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k10, v10);
            vPut = this.map.put(k10, v10);
            if (vPut != null) {
                this.size -= safeSizeOf(k10, vPut);
            }
        }
        if (vPut != null) {
            entryRemoved(false, k10, vPut, v10);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final V remove(K k10) {
        V vRemove;
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            vRemove = this.map.remove(k10);
            if (vRemove != null) {
                this.size -= safeSizeOf(k10, vRemove);
            }
        }
        if (vRemove != null) {
            entryRemoved(false, k10, vRemove, null);
        }
        return vRemove;
    }

    public void resize(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i10;
        }
        trimToSize(i10);
    }

    public final synchronized int size() {
        return this.size;
    }

    public int sizeOf(K k10, V v10) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        i10 = this.hitCount;
        i11 = this.missCount + i10;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }

    public void trimToSize(int i10) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                }
                if (this.size > i10 && !this.map.isEmpty()) {
                    Map.Entry<K, V> next = this.map.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.map.remove(key);
                    this.size -= safeSizeOf(key, value);
                    this.evictionCount++;
                }
                return;
            }
            entryRemoved(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }
}
