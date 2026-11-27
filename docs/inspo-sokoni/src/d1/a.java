package d1;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<d.a<?>, Object> f6263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f6264b;

    /* JADX INFO: renamed from: d1.a$a, reason: collision with other inner class name */
    public static final class C0109a extends l implements xc.l<Map.Entry<d.a<?>, Object>, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0109a f6265a = new C0109a();

        public C0109a() {
            super(1);
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry<d.a<?>, Object> entry) {
            k.e(entry, "entry");
            return "  " + entry.getKey().a() + " = " + entry.getValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public a(Map<d.a<?>, Object> preferencesMap, boolean z10) {
        k.e(preferencesMap, "preferencesMap");
        this.f6263a = preferencesMap;
        this.f6264b = new AtomicBoolean(z10);
    }

    public /* synthetic */ a(Map map, boolean z10, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? true : z10);
    }

    @Override // d1.d
    public Map<d.a<?>, Object> a() {
        Map<d.a<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(this.f6263a);
        k.d(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    @Override // d1.d
    public <T> T b(d.a<T> key) {
        k.e(key, "key");
        return (T) this.f6263a.get(key);
    }

    public final void d() {
        if (!(!this.f6264b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void e(d.b<?>... pairs) {
        k.e(pairs, "pairs");
        d();
        for (d.b<?> bVar : pairs) {
            h(bVar.a(), bVar.b());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return k.a(this.f6263a, ((a) obj).f6263a);
        }
        return false;
    }

    public final <T> T f(d.a<T> key) {
        k.e(key, "key");
        d();
        return (T) this.f6263a.remove(key);
    }

    public final <T> void g(d.a<T> key, T t10) {
        k.e(key, "key");
        h(key, t10);
    }

    public final void h(d.a<?> key, Object obj) {
        Map<d.a<?>, Object> map;
        k.e(key, "key");
        d();
        if (obj == null) {
            f(key);
            return;
        }
        if (obj instanceof Set) {
            map = this.f6263a;
            obj = Collections.unmodifiableSet(w.P((Iterable) obj));
            k.d(obj, "unmodifiableSet(value.toSet())");
        } else {
            map = this.f6263a;
        }
        map.put(key, obj);
    }

    public int hashCode() {
        return this.f6263a.hashCode();
    }

    public String toString() {
        return w.A(this.f6263a.entrySet(), ",\n", "{\n", "\n}", 0, null, C0109a.f6265a, 24, null);
    }
}
