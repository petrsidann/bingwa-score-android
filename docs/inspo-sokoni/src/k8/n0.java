package k8;

import g8.k1;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.v f11749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, v0> f11750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, k1> f11751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<h8.k, h8.r> f11752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<h8.k> f11753e;

    public n0(h8.v vVar, Map<Integer, v0> map, Map<Integer, k1> map2, Map<h8.k, h8.r> map3, Set<h8.k> set) {
        this.f11749a = vVar;
        this.f11750b = map;
        this.f11751c = map2;
        this.f11752d = map3;
        this.f11753e = set;
    }

    public Map<h8.k, h8.r> a() {
        return this.f11752d;
    }

    public Set<h8.k> b() {
        return this.f11753e;
    }

    public h8.v c() {
        return this.f11749a;
    }

    public Map<Integer, v0> d() {
        return this.f11750b;
    }

    public Map<Integer, k1> e() {
        return this.f11751c;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.f11749a + ", targetChanges=" + this.f11750b + ", targetMismatches=" + this.f11751c + ", documentUpdates=" + this.f11752d + ", resolvedLimboDocuments=" + this.f11753e + '}';
    }
}
