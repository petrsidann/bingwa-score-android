package k6;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class s<K, V> extends e<K, V> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient r<K, ? extends p<V>> f11627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f11628b;

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, Collection<V>> f11629a = j0.c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Comparator<? super K> f11630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Comparator<? super V> f11631c;
    }

    public s(r<K, ? extends p<V>> rVar, int i10) {
        this.f11627a = rVar;
        this.f11628b = i10;
    }

    @Override // k6.d
    public boolean b(Object obj) {
        return obj != null && super.b(obj);
    }

    @Override // k6.d, k6.c0
    /* JADX INFO: renamed from: c */
    public r<K, Collection<V>> a() {
        return this.f11627a;
    }

    @Override // k6.d
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // k6.d
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // k6.d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
