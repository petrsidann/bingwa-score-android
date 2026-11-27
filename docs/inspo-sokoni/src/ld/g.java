package ld;

import java.util.Collection;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection<gd.k0> f12723a = dd.i.f(dd.g.c(ServiceLoader.load(gd.k0.class, gd.k0.class.getClassLoader()).iterator()));

    public static final Collection<gd.k0> a() {
        return f12723a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
