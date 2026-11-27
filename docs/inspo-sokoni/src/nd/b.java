package nd;

import gd.j0;
import gd.o1;
import java.util.concurrent.Executor;
import ld.i0;
import ld.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends o1 implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f13570d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j0 f13571e = m.f13591c.e0(k0.e("kotlinx.coroutines.io.parallelism", bd.h.a(64, i0.a()), 0, 0, 12, null));

    @Override // gd.j0
    public void c0(oc.i iVar, Runnable runnable) {
        f13571e.c0(iVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c0(oc.j.f13812a, runnable);
    }

    @Override // gd.j0
    public String toString() {
        return "Dispatchers.IO";
    }
}
