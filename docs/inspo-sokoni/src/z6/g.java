package z6;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f20319b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f20320c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<c7.b> f20321a = new AtomicReference<>();

    public static class b implements c7.b {
        public b() {
        }

        @Override // c7.b
        public c7.b.a a(c7.c cVar, String str, String str2) {
            return f.f20317a;
        }
    }

    public static g b() {
        return f20319b;
    }

    public c7.b a() {
        c7.b bVar = this.f20321a.get();
        return bVar == null ? f20320c : bVar;
    }
}
