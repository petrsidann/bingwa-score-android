package nd;

import java.util.concurrent.TimeUnit;
import ld.i0;
import ld.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13583a = i0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f13584b = k0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13585c = k0.e("kotlinx.coroutines.scheduler.core.pool.size", bd.h.a(i0.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13586d = k0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f13587e = TimeUnit.SECONDS.toNanos(k0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g f13588f = e.f13573a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f13589g = new j(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f13590h = new j(1);
}
