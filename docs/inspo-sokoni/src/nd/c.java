package nd;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f13572n = new c();

    public c() {
        super(l.f13585c, l.f13586d, l.f13587e, l.f13583a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // gd.j0
    public String toString() {
        return "Dispatchers.Default";
    }
}
