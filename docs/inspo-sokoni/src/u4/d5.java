package u4;

/* JADX INFO: loaded from: classes.dex */
public final class d5<V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f16086g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b5<V> f16088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V f16089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f16090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile V f16091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile V f16092f;

    public d5(String str, V v10, V v11, b5<V> b5Var) {
        this.f16090d = new Object();
        this.f16091e = null;
        this.f16092f = null;
        this.f16087a = str;
        this.f16089c = v10;
        this.f16088b = b5Var;
    }

    public final V a(V v10) {
        synchronized (this.f16090d) {
        }
        if (v10 != null) {
            return v10;
        }
        if (a5.f15982a == null) {
            return this.f16089c;
        }
        synchronized (f16086g) {
            if (g.a()) {
                return this.f16092f == null ? this.f16089c : this.f16092f;
            }
            try {
                for (d5 d5Var : p0.f16635a) {
                    if (g.a()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V vZza = null;
                    try {
                        b5<V> b5Var = d5Var.f16088b;
                        if (b5Var != null) {
                            vZza = b5Var.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (f16086g) {
                        d5Var.f16092f = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            b5<V> b5Var2 = this.f16088b;
            if (b5Var2 == null) {
                return this.f16089c;
            }
            try {
                return b5Var2.zza();
            } catch (IllegalStateException unused3) {
                return this.f16089c;
            } catch (SecurityException unused4) {
                return this.f16089c;
            }
        }
    }

    public final String b() {
        return this.f16087a;
    }
}
